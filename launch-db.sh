#!/usr/bin/env bash
docker run -it -d --rm -e POSTGRES_PASSWORD=postgres -v `pwd -P`/sql:/docker-entrypoint-initdb.d --name pgtimeouts postgres

docker inspect pgtimeouts | grep -i ipaddress


