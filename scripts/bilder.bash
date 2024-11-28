#!/bin/bash

cd ./
mvn clean package
echo 'START DOCKER BUILD'
docker build -t farrokh4/somethinggood -f Dockerfile .
echo 'DOCKER PUSH'
docker push farrokh4/somethinggood
echo 'DONE'