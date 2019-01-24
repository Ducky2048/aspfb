#! /bin/bash

TAG=$1

for i in archive arena camp config-server frontend promoter service-discovery
do
	docker build . -t izolight/aspbf-$i:$TAG --build-arg MODULE=$i --build-arg VERSION=1.0
done
