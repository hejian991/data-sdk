package com.iwm.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
//  static Logger logger = Logger.getLogger(HelloWorld.class.getName());
  static Logger logger = LoggerFactory.getLogger(HelloWorld.class.getName());

  public static void main(String[] args) {
//    PropertyConfigurator.configure(args[0]);
    logger.info("Entering application.");
    logger.debug("Debugging!.");
    logger.info("Exiting application.");
  }
}