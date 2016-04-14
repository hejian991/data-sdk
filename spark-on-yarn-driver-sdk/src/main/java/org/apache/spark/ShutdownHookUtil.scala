package org.apache.spark

import org.apache.spark.util.ShutdownHookManager

/**
  * Created by hj on 16/3/30.
  */
object ShutdownHookUtil {

  def addShutdownHook(priority: Int)(hook: () => Unit): AnyRef = {
    ShutdownHookManager.addShutdownHook(priority)(hook)
  }

  def removeShutdownHook(ref: AnyRef): Boolean = {
    ShutdownHookManager.removeShutdownHook(ref)
  }

}
