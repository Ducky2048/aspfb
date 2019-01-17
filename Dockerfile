FROM maven:3.6.0-jdk-8-alpine as build
WORKDIR /workspace/app

COPY . .

ARG MODULE

RUN mvn package spring-boot:repackage -pl $MODULE -am

FROM openjdk:8-jre-alpine3.8
VOLUME /tmp
ARG MODULE
ARG VERSION=0.0.1
ARG JAR=/workspace/app/$MODULE/target/$MODULE-$VERSION-SNAPSHOT.jar

COPY config-files /app/config-files
COPY --from=build ${JAR} /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
