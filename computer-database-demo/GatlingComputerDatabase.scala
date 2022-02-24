
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class GatlingComputerDatabase extends Simulation {

  private val httpProtocol = http
    .baseUrl("https://computer-database.gatling.io")
    .inferHtmlResources(AllowList(), DenyList())
    .acceptHeader("text/css,*/*;q=0.1")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.9")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36")
  
  private val headers_0 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
  		"Cache-Control" -> "max-age=0",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "same-origin",
  		"Sec-Fetch-User" -> "?1",
  		"Upgrade-Insecure-Requests" -> "1",
  		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="98", "Google Chrome";v="98""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "macOS"
  )
  
  private val headers_1 = Map(
  		"Sec-Fetch-Dest" -> "style",
  		"Sec-Fetch-Mode" -> "no-cors",
  		"Sec-Fetch-Site" -> "same-origin",
  		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="98", "Google Chrome";v="98""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "macOS"
  )
  
  private val headers_3 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "same-origin",
  		"Sec-Fetch-User" -> "?1",
  		"Upgrade-Insecure-Requests" -> "1",
  		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="98", "Google Chrome";v="98""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "macOS"
  )
  
  private val headers_6 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
  		"Cache-Control" -> "max-age=0",
  		"Origin" -> "https://computer-database.gatling.io",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "same-origin",
  		"Sec-Fetch-User" -> "?1",
  		"Upgrade-Insecure-Requests" -> "1",
  		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="98", "Google Chrome";v="98""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "macOS"
  )


  private val scn = scenario("GatlingComputerDatabase")
    .exec(
      http("LOAD_HOMEPAGE")
        .get("/computers")
        .headers(headers_0)
        .resources(
          http("request_1")
            .get("/assets/css/main.css")
            .headers(headers_1),
          http("request_2")
            .get("/assets/css/bootstrap.min.css")
            .headers(headers_1)
        )
    )
    .pause(1)
    .exec(
      http("OPEN_CREATE_PAGE")
        .get("/computers/new")
        .headers(headers_3)
        .resources(
          http("request_4")
            .get("/assets/css/main.css")
            .headers(headers_1),
          http("request_5")
            .get("/assets/css/bootstrap.min.css")
            .headers(headers_1)
        )
    )
    .pause(1)
    .exec(
      http("CREATE_NEW_COMPUTER")
        .post("/computers")
        .headers(headers_6)
        .formParam("name", "test-pc")
        .formParam("introduced", "2022-02-24")
        .formParam("discontinued", "2023-02-24")
        .formParam("company", "1")
        .resources(
          http("request_7")
            .get("/assets/css/main.css")
            .headers(headers_1),
          http("request_8")
            .get("/assets/css/bootstrap.min.css")
            .headers(headers_1)
        )
    )
    .pause(1)
    .exec(
      http("SEARCH_COMPUTER")
        .get("/computers?f=test-pc")
        .headers(headers_3)
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
