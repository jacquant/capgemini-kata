# Capgemini Kata

## Description

This is a requested kata, where I had to write a simple application to perform simple customer/accounts management.

The application is written in Java 21, using Spring Boot.

I also wrote a simple frontend application using Angular. This application is available in the `client` folder.

## How to run

### Local development

#### Java application

To run the spring application locally, you need to have Java 21 installed on your machine.

```shell
./gradlew bootRun
```

The application will be available at `http://localhost:8080`

### Angular application

To run the frontend application locally

```shell
cd client && npm run start
```

The application will be available at `http://127.0.0.1:4200`

### Docker

To run the application using docker, you need to have docker/podman installed on your machine.

The docker image is already built and available on github
packages https://github.com/jacquant/capgemini-kata/pkgs/container/capgemini-kata%2Fcapgemini
To pull the image:

```shell
docker pull ghcr.io/jacquant/capgemini-kata/capgemini:latest
```

and run it:

```shell
docker run -p 8080:8080 ghcr.io/jacquant/capgemini-kata/capgemini:latest
```