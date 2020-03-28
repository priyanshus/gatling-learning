#!/bin/sh
mvn clean package
mvn clean gatling:test -Dgatling.simulationClass=com.tw.performance.CheckShippingDetailsSimulation
mvn clean gatling:test -Dgatling.simulationClass=com.tw.performance.LoginRequestSimulation