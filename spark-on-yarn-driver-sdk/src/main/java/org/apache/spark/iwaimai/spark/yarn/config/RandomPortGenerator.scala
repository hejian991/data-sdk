package org.apache.spark.iwaimai.spark.yarn.config

import java.net.ServerSocket

import net.csdn.modules.http.PortGenerator


class RandomPortGenerator extends PortGenerator {
  override def getPort: Int = {
    var socket: ServerSocket = null
    try {
      socket = new ServerSocket(0)
      socket.setReuseAddress(true)
      val port = socket.getLocalPort()
      try {
        socket.close()
      } catch {
        case e: Exception =>
        // Ignore IOException on close()
      }
      return port;
    } catch {
      case e: Exception =>
    } finally {
      if (socket != null) {
        try {
          socket.close();
        } catch {
          case e: Exception =>
        }
      }
    }
    throw new IllegalStateException("Could not find a free TCP/IP port to start embedded Jetty HTTP Server on");
  }
}
