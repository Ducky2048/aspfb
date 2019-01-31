FROM maven:3.6.0-jdk-8-alpine as build
WORKDIR /workspace/app

# Dependency caching
COPY ./pom.xml ./pom.xml
RUN mkdir -p {arena,camp,promoter,service-discovery,frontent,config-server,archive}
COPY ./arena/pom.xml ./arena/pom.xml
COPY ./camp/pom.xml ./camp/pom.xml
COPY ./promoter/pom.xml ./promoter/pom.xml
COPY ./service-discovery/pom.xml ./service-discovery/pom.xml
COPY ./frontend/pom.xml ./frontend/pom.xml
COPY ./config-server/pom.xml ./config-server/pom.xml
COPY ./archive/pom.xml ./archive/pom.xml

RUN mvn dependency:go-offline -B

# actual build starts here
ARG MODULE

COPY ./$MODULE ./$MODULE

RUN mvn package spring-boot:repackage -pl $MODULE -am

FROM openjdk:8-jre-slim
ARG MODULE
ARG VERSION
ARG JAR=/workspace/app/$MODULE/target/$MODULE-$VERSION-SNAPSHOT.jar

COPY config-files /app/config-files
COPY --from=build ${JAR} /app/app.jar
COPY entrypoint.sh /app/entrypoint.sh

# Create a group and user
RUN addgroup appgroup \
	&& useradd -m appuser \
	&& usermod -a -G appgroup appuser \
	&& chown appuser.appgroup /app

# install nc
RUN apt-get update && apt-get install -y netcat && rm -rf /var/lib/apt/lists/*

USER appuser
ENV MOD=${MODULE}
CMD ["/app/entrypoint.sh"]
