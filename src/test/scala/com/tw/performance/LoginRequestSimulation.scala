package com.tw.performance

import com.tw.utils.PerformanceTestBase
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class LoginRequestSimulation extends PerformanceTestBase {
  val performLogin = http("Post Login")
    .post("/sandbox/login")
    .formParam("username", "user")
    .formParam("password", "password")
    .disableFollowRedirect
    .check(status.is(302))

  val loginPost = scenario("Post Login")
    .exec(performLogin)

  setUp(loginPost.inject(atOnceUsers(users))).protocols(httpProtocol)
    .assertions(global.responseTime.max.between(4000, 5000))
}