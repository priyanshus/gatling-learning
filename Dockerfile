FROM maven:latest

COPY . /home/workspace/gatling-learning
WORKDIR /home/workspace/gatling-learning

ENTRYPOINT sh run.sh
