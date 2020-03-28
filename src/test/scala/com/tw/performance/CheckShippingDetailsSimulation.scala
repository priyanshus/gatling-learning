package com.tw.performance

import com.tw.utils.PerformanceTestBase
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CheckShippingDetailsSimulation extends PerformanceTestBase {
  val performLogin = http("Post Login")
    .post("/sandbox/login")
    .formParam("username", "demouser1002")
    .formParam("password", "Test@1234")
    .check(status.is(200))


  val checkShippingDetails = http("Check Shipping Details")
    .get("/sandbox/shipping/")
    .check(css(".context-btn.add").exists)

  val shippingScenario = scenario("Check Shipping Details")
    .exec(performLogin)
    .exec(checkShippingDetails)

  setUp(shippingScenario.inject(atOnceUsers(users))).protocols(httpProtocol)
    .assertions(global.responseTime.max.between(4000, 10000))
}
