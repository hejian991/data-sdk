import jodd.http.HttpRequest
import net.sf.json.JSONObject
import org.joda.time.DateTime
import scala.collection.JavaConverters._
import scala.util.Try

/**
  * Created by hj on 16/3/21.
  */


trait DocumentAPI {

  def addDocument(body: String) = {
    val jobj = JSONObject.fromObject(body)
    jobj.put("create_time", System.currentTimeMillis())
    HttpRequest.post("http://nj02-lbs-impala1.nj02.baidu.com:8567/twitter/tweet/")
      .bodyText(jobj.toString)
      .send()

  }
}

trait IndexAPI {
  def fetchIndexNames = {
    val response = HttpRequest.get("http://szwg-common001-m52-hadoop014.szwg01.baidu.com:8567/_stats/indices").send
    JSONObject.fromObject(response.bodyText()).getJSONObject("indices").keySet().toArray.map(_.asInstanceOf[String])
  }

  def deleteIndex(dayNum: Long, splitter: String) = {

    val nowDay = new DateTime().toString("yyyyMMdd").toLong
    val needRm = fetchIndexNames.map(_.split(splitter)).filter(_.size > 1).filter { f =>
      val t = Try(f(f.size - 1).replaceAll("\\.", "").toLong)
      if (t.isSuccess) nowDay - t.get >= dayNum else false
    }.map(_.mkString(splitter))

    needRm.foreach { f =>
      println(f)
      HttpRequest.delete(s"http://szwg-common001-m52-hadoop014.szwg01.baidu.com:8567/$f").send()
      Thread.sleep(100L)
    }
  }
}

object DeleteIndex extends App with IndexAPI {
  deleteIndex(5, "_")
  deleteIndex(5, "-")

}

object EsClient extends App with DocumentAPI {


  val body = "{\n    \"user\" : " +
    "\"AA\",\n    \"post_date\" : \"2009-11-15T14:12:12\",\n    \"message\" : \"trying out Elasticsearch\"\n"
  addDocument(body)


}
