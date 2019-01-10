FROM maven:3.6.0-jdk-8-alpine as build
WORKDIR /workspace/app

COPY . .
RUN mvn dependency:resolve

ARG MODULE

RUN mvn install -pl $MODULE -am

FROM openjdk:8-jre-alpine3.8
VOLUME /tmp
ARG MODULE
ARG JAR=/workspace/app/$MODULE/target/*.jar

COPY config-files /app/
COPY --from=build ${JAR} /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
