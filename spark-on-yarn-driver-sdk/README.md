## 使用说明
### 通过给driver引入web server来接收请求，达到stop、restart、upgrade Spark Streaming(简称SS)的目的。

以下是spark-on-yarn-driver-sdk 的使用说明

#### 1.引入spark-on-yarn-driver-sdk jar包
```
<dependency>
  <groupId>data-sdk</groupId>
  <artifactId>spark-on-yarn-driver-sdk</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
```

#### 2.在driver中编码调用

```scala
    // 通过ssc创建的第一个dStream
    val dStream = ssc......
    // fs.default.name的值
    val fsName = "hdfs://do-szwg-nameservice"
    dStream.foreachRDD(rdd => {
      // 调用checkUpgrade，第一个参数指定fs.default.name的值，第二个指定SS的CheckPointPath
      // 如果SS没有使用checkpoint的话，可不传参；此时Upgrade执行逻辑跟restart逻辑完全一致
      DriverHelper.checkUpgrade(Some(fsName), Some(Config.upCheckPointPath))
      // 调用checkRestart
      DriverHelper.checkRestart
    })
    ......
```


```scala
    ......
    ssc.start()
    // 在ssc.start()启动之后，调用DriverHelper.runWebServer，启动web server
    // 并把host:port写到${streamingIdListDirPrefix}/${appId} hdfs文件中
    // 其中streamingIdListDirPrefix默认为/spock/streaming_id_list
    DriverHelper.runWebServer(ssc.sparkContext, fsName)
    ssc.awaitTermination()
```

#### 3.打包，创建运行脚本，Run


```
#!/usr/bin/env bash

HUATUO_HOME="/home/map/workspace/huatuo"
SPARKBIN="/home/map/workspace/contrib/spark-1.6.0-bin-hadoop2.6/bin/"
$SPARKBIN/spark-submit --class DirectKafkaWordCount \
    --master yarn-cluster \
    ...
    // 设置为 graceful stop
    --conf spark.streaming.stopGracefullyOnShutdown=true \
    // 设置 统计AM失败次数的时间间隔，单位为ms
    --conf spark.yarn.am.attemptFailuresValidityInterval=3600000 \

    ...
```


#### 4.现在可通过Rest API发起请求了

```
请求方式：curl -XPOST ${host}:${port}/ss/op?action=$action
或curl -XPOST `hadoop fs -cat /spock/streaming_id_list/${applicationId}`/ss/op?action=$action
可选action有 stop、retart、upgrade。
PS:
1. 响应情况：
stop => (200, graceful stopping...)
retart => (200, restarting...)
upgrade => (200, upgrading...)
_ => (400, unSupported action param.)
2. 为了保证不丢数据，其中涉及到的所有stop都为graceful stop，因此不会立即停止，wait a moment或查看AM日志观察进度。
```
