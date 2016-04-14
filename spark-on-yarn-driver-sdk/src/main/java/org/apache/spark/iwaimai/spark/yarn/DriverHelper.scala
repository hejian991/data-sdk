package org.apache.spark.iwaimai.spark.yarn

import java.net.InetAddress
import net.csdn.ServiceFramwork
import net.csdn.bootstrap.Application
import net.csdn.common.settings.Settings
import net.csdn.modules.http.HttpServer
import org.apache.spark.iwaimai.hdfs.HdfsUtil
import org.apache.spark.iwaimai.spark.yarn.config.DriverConfig
import org.apache.spark.iwaimai.spark.yarn.controller.DriverController
import org.apache.spark.iwaimai.spark.yarn.exception.DriverException
import org.apache.spark.{ShutdownHookUtil, SparkContext}
import org.apache.spark.internal.Logging

/**
  * Created by hj on 16/4/13.
  */
object DriverHelper extends Logging {
  def checkRestart = {
    if (DriverConfig.isRestart) {
      val msg = "restarting..., expect to exit am process."
      logWarning(msg)
      throw new DriverException(msg)
    }
  }


  def checkUpgrade(fsName: Option[String] = None, checkpointPath: Option[String] = None) = {
    if (fsName.isDefined && checkpointPath.isDefined) {
      if (DriverConfig.isUpgrade && !DriverConfig.hasRmCkptShutdownHook) {

        DriverConfig.hasRmCkptShutdownHook = true
        ShutdownHookUtil.addShutdownHook(DriverConfig.priority) { () =>
          logWarning(s"rm hdfs checkpoint hook running...")
          val hdfsUtil = new HdfsUtil(fsName.get, HdfsUtil.config())
          hdfsUtil.rmr(checkpointPath.get)
        }

        val msg = "upgrading..., expect to exit am process with rm hdfs ckpt hook."
        logWarning(msg)
        throw new DriverException(msg)
      }
    } else {
      // restart
      if (DriverConfig.isUpgrade) {
        val msg = "hdfsPath or checkpointPath is not defined, so just restarting..."
        logWarning(msg)
        throw new DriverException(msg)
      }
    }
  }


  def runWebServer(sc: SparkContext, fsName: String, settings: Option[Settings] = None) = {
    ServiceFramwork.scanService.setLoader(classOf[DriverController])
    ServiceFramwork.applicaionYamlName("driver.application.yml")
    ServiceFramwork.disableDubbo()
    ServiceFramwork.disableThrift()
    ServiceFramwork.disableLog()
    ServiceFramwork.enableNoThreadJoin()
    Application.main(Array())
    logInfo("web server in driver is running...")

    writeHostAndPort(sc, fsName, settings)

  }


  def writeHostAndPort(sc: SparkContext, fsName: String, settings: Option[Settings] = None) = {
    val httpServer = ServiceFramwork.injector.getInstance(classOf[HttpServer])
    val hostAndPort = s"${InetAddress.getLocalHost.getHostAddress}:${httpServer.getHttpPort}"
    val appId = sc.applicationId
    logInfo(appId + " " + hostAndPort)

    val hdfsUtil = new HdfsUtil(fsName, HdfsUtil.config())
    val set = ServiceFramwork.injector.getInstance(classOf[Settings])
    try {
      hdfsUtil.createFile(
        s"""${settings.getOrElse(set).get("streamingIdListDirPrefix", "/spock/streaming_id_list")}/${appId}"""
        , hostAndPort
      )
    } catch {
      case e: Throwable => {
        logWarning("hdfsUtil createFile occur exception.")
      }
    }
  }

}



