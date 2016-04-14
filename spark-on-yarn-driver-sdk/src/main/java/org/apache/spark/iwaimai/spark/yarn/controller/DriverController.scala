package org.apache.spark.iwaimai.spark.yarn.controller

import net.csdn.annotation.rest.At
import net.csdn.modules.http.{ApplicationController, RestRequest, ViewType}
import org.apache.spark.internal.Logging
import org.apache.spark.iwaimai.spark.yarn.config.DriverConfig


class DriverController extends ApplicationController with Logging{


  @At(
    path = Array("/ss/op"),
    types = Array(RestRequest.Method.PUT, RestRequest.Method.POST)
  )
  def stop = {
    param("action") match {
      case "stop" => {
        new Thread("shut down thread") {
          override def run: Unit = {
            System.exit(0)
          }
        }.start
        val msg = "graceful stopping..."
        logWarning(msg)
        render(200, msg, ViewType.string)
      }

      case "restart" => {
        // 1. throw exception
        DriverConfig.isRestart = true
        render(200, s"restarting...", ViewType.string)
      }

      case "upgrade" => {
        // 1. throw exception, 2. rm hdfs ckpt
        DriverConfig.isUpgrade = true
        render(200, s"upgrading...", ViewType.string)
      }

      case _ => render(400, s"unSupported action param.", ViewType.string)
    }

  }


}
