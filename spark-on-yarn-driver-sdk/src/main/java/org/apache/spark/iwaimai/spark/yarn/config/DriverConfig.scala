package org.apache.spark.iwaimai.spark.yarn.config

/**
  * Created by hj on 16/4/13.
  */
object DriverConfig {

  var isRestart = false
  var isUpgrade = false
  var hasRmCkptShutdownHook = false
  val priority = 31
}
