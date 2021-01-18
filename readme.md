Project for experiment with r2dbc postgres timeouts.

## How to start

1. Run `launch-db.sh` to start a container running postgres. 
2. Update `PgTimeoutsConfiguration` with the container's ip address (if needed)
3. Run `./gradlew bootRun`
4. Endpoint to curl `http://localhost:8080/1`

Notes:
- A 60 second delay has been added to the db query (see `PersonRepository`) in order to slow down the database and confirm if the timeout settings work.
- `PgTimeoutsConfiguration` defines a statement timeout of 2 seconds. The database server setting is 5 seconds.
- `http://localhost:8080/1` should return in approx 2 seconds.
