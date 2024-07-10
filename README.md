
# Organization

This project contains all that's needed to build, run and deploy the backend.

```
/dep            usefull dependencies for running the service locally
/docs           docs (in progress) and tools
/.mvn           maven dependencies
/src            project sources
```

# Setup

## Building and running locally

To build and run the project, you need the following environment:

- JDK 21 or higher
- docker
- docker-compose

You can also set runtime properties by adding them in the `.config-local/local.properties` file.

# Running

To run locally:

1) you need to launch the external services (MySQL, ...) as following:

```
docker-compose -f dep/docker-compose.yml up -d
```
you need to restart it with option --force-recreate.

```
docker-compose -f dep/docker-compose.yml up --force-recreate -d
```

2) set the Provider service file in `.config-local`; this file is not included in the project for security reasons.

3) configure properties in `.config-local/local.properties`; especially, the `smart.content.generate=true` directive will create some test data to start; don't forget to put it to false after.

4) run the project via any of the following method:

- launching the `Application` class in IntelliJ (need to provide the VM options `-Dspring.profiles.active=local` in the launch configuration)

## Postman

A shared collection is available in this folder with all the API calls registered. Use [PMS](http://localhost:8080/pms) to get it. The collection integrates a pre-request script that will automatically gather an authentication token before each request.

## API doc

A Swagger documentation is generated at runtime by SpringDoc at
```
http://localhost:8080/docs/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/
```