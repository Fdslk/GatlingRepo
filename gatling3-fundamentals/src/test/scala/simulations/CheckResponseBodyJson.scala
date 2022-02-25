package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CheckResponseBodyJson extends Simulation{
  val httpConf = http.baseUrl("http://localhost:8080/app/")
    .header("Accept", "application/json")

  val scn = scenario("Check Json Path")

    .exec(http("get specific game")
    .get("videogames/1")
    .check(jsonPath("$.name").is("Resident Evil 4")))

    .exec(http("get all video games")
    .get("videogames")
    .check(jsonPath("$[0].id").saveAs("gameId"))) //saveAs can save the result and pass to following cases
    .exec {
      t => println(t); t //debug session
    }

    .exec(http("get specific game")
    .get("videogames/${gameId}")
    .check(jsonPath("$.name").is("Resident Evil 4"))
    .check(bodyString.saveAs("responseBody")))
    .exec{
      session => println(session("responseBody").as[String]); session
    }

  setUp(
    scn.inject(atOnceUsers(1))
      .protocols(httpConf)
  )
}
