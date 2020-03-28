package com.tw.utils

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class PerformanceTestBase extends Simulation {
  val users = System.getenv("USERS_COUNT").toInt
  val baseUrl = System.getenv("BASE_URL")

  val httpProtocol = http
    .baseUrl(baseUrl)
    .inferHtmlResources()
    .acceptHeader("image/webp,*/*")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:74.0) Gecko/20100101 Firefox/74.0")
    .headers(
      Map("Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
        "Origin" -> "https://sandbox.2checkout.com",
        "Upgrade-Insecure-Requests" -> "1"))
}
