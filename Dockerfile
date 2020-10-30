FROM selenium/standalone-chrome
#FROM maven:3.6.2-jdk-8-openj9
#FROM maven:3.6.3-jdk-11-openj9
FROM maven:3.6.2-jdk-8
#FROM maven:3.6.2-jdk-8-openj9
#FROM maven:3.6.3-jdk-11-slim
#FROM maven:3.6.2-jdk-8
#FROM java:8-jdk
#FROM maven:3.6.0-jdk-8
COPY . /app/
WORKDIR /app

RUN apt-get update && apt-get install curl vim gnupg2 wget unzip nano -y
# Running the procps
#RUN apt update && apt-get install  --no-install-recommends -y procps
ENV JAVA_HOME="/usr/local/openjdk-8"
ENV PATH $JAVA_HOME/bin:$PATH
WORKDIR /app/
# RUN apt-mark showmanual > /tmp/versions && apt-show-versions | grep -f /tmp/version