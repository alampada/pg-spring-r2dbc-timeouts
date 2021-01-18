#!/usr/bin/env bash
docker run -it -d --rm -e POSTGRES_PASSWORD=postgres -v `pwd -P`/sql:/docker-entrypoint-initdb.d  -v `pwd -P`/sql/my-postgres.conf:/etc/postgresql/postgresql.conf --name pgtimeouts postgres  -c 'config_file=/etc/postgresql/postgresql.conf'


docker inspect pgtimeouts | grep -i ipaddress


