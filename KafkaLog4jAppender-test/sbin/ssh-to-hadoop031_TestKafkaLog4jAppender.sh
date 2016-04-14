#!/usr/bin/env bash

. /etc/profile
cd ..
PROJECT_NAME=KafkaLog4jAppender-test
JAR=${PROJECT_NAME}.jar
MAINCLASS=com.iwm.test.HelloWorld
ssh hadoop031 "cd /home/map/workspace/huatuo/sbin;rm -rf $PROJECT_NAME"
mvn clean && tar -zcf - ../$PROJECT_NAME | nc szwg-do2-m52-hadoop031.szwg01.baidu.com 8899

ssh hadoop031 "export JAVA_HOME=/home/map/do/pids/jdk/current;
cd /home/map/workspace/huatuo/sbin/$PROJECT_NAME; pwd;
mvn clean package;
sh bin/run.sh target/$JAR $MAINCLASS"

