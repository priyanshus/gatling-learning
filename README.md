### gatling-learning
Contains gatling based performance test scripts.

#### Pre-requisites
* JAVA
* Maven
* Scala

#### How to run
```
git clone https://github.com/priyanshus/gatling-learning.git
cd gatling-learning
export USERS_COUNT=1
export BASE_URL=https://example.site
sh run.sh

or
docker build -t gatling .
docker run -it -e USERS_COUNT=1 -e BASE_URL=https://example.com --name gatling-container --rm gatling

or
mvn clean gatling:test -Dgatling.simulationClass=com.tw.performance.LoginRequestSimulation
```

#### How to start a new maven based gatling project
Refer to https://gatling.io/docs/current/extensions/maven_archetype/#maven-archetype

```
mvn archetype:generate -DarchetypeGroupId=io.gatling.highcharts -DarchetypeArtifactId=gatling-highcharts-maven-archetype
```
