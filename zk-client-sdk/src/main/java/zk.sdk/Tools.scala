package zk.sdk

import jodd.http.HttpRequest
import net.sf.json.JSONObject

/**
  * Created by hj on 16/4/7.
  */
object Tools {

//  val zkClient = ZKConfUtil.create().client

  //  zk.sdk.Tools zkNodePath configFilePath
  //              /huatuo/test1 /Users/hj/code/project_baidu/huatuo/conf/application.yml
  def main(args: Array[String]) {
    val jsonStr = configToJsonStr(args(1))
    httpWrite(args(0), jsonStr)
  }

  def configToJsonStr(configPath: String) = {
    import scala.io._

    val configStr = Source.fromFile(configPath, "utf8").mkString
    val json = new JSONObject()
    json.put("value", configStr)
    json.toString
  }

  def httpWrite(zkNodePath: String, jsonStr: String) = {
    HttpRequest.post(s"http://szwg-do2-m52-hadoop031.szwg01.baidu.com:8401/zk/znode?path=${zkNodePath}&force=true")
      .bodyText(jsonStr)
      .send()
  }

//  def write(path: String, value: String) = {
//
//    if (!zkClient.exists(path)) {
//      zkClient.createPersistent(path, true)
//    }
//
//    //    val newV = value.replace(";", "\n")
//    zkClient.writeData(path, value.getBytes)
//  }
//
//
//  def fetch(path: String) = {
//    val zNodeValue: String = new String(zkClient.readData[Array[Byte]](path))
//    zNodeValue
//  }


}
