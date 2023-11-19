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

The application will be available at `http://localhost:8080`. By accessing this endpoint, you will reach the web
application.

## How to test the application

### Through the swagger UI

The application exposes a swagger UI, which can be accessed at `http://localhost:8080/swagger-ui/index.html`

The application provides 4 endpoints:

- `GET /api/v1/customers`: returns the list of all customers: extra endpoint build to test the UI application
- `GET /api/v1/customers/{id}`: returns the customer with the given id
- `POST /api/v1/customers`: creates a new customer: extra endpoint build to test the UI application
- `POST /api/v1/customers/{id}/accounts`: creates a new account (with initial amount) for the customer with the given id

### Through the Angular application

The Angular application provides a simple UI to test the application.
The application usage is pretty straightforward:

- Create customers through the `Create a new customer` button. Will display a popup to enter the customer information
- Select the current customer from the table. Once selected, the row will be highlighted in purple.
- Create an account for the selected customer through the `Create a new account` button. Will display a popup to enter
  the account information
- Select the current account from the table. Once selected, the row will be highlighted in blue.
- Read the table of transactions for the selected account.
