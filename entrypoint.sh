#! /bin/sh

if [[ "$MOD" != "config-server" && "$MOD" != "service-discovery" ]];
then
	while ! nc -z configserver 8091;
	do
		echo "waiting for configserver to come up"
		sleep 3;
	done
#	while ! nc -z service-discovery 8090;
#	do
#		echo "waiting for service-discovery to come up"
#		sleep 3;
#	done
fi
java -Deureka.client.serviceUrl.defaultZone=http://service-discovery:8090/eureka -Dspring.cloud.config.uri=http://configserver:8091 -jar /app/app.jar
