# Meli Desafio Backend IT ARC

## Overview

This project is orchestrated using Docker Compose. It has three sub projects: a Postgres database, a Spring Java API and a Spring Java Worker.


## Services

### PostgreSQL
- **Image**: `postgres:15`
- **Description**: This service runs a PostgreSQL database to store notifications and user data.

### API
- **Build**: `./desafio-backend-it-arc-api`
- **Description**: This service runs the main API for the project, which interacts with the PostgreSQL database and external CPTEC API.

### Worker
- **Build**: `./desafio-backend-it-arc-worker`
- **Description**: This service runs a scheduler that queries the database to check for any pending notifications that should be sent, calling the API via HTTP when need.

## Running the Project

1. **Clone the repository**:
    ```sh
    git clone <repository-url>
    cd <repository-directory>
    ```

2. **Start the services**:
    ```sh
    docker-compose up -d
    ```

3. **Check the status of the services**:
    ```sh
    docker-compose ps
    ```

## Database Initialization

The PostgreSQL database is initialized with the following scripts located in the `./db` directory:

- `01-create-tables.sql`: Creates the `notifications` and `users` tables.
- `02-insert-data.sql`: Inserts seed data into the `notifications` and `users` tables.

## Health Checks

The `postgres` service includes a health check to ensure the database is ready before other services start.


## Conclusion

This project demonstrates a multi-service architecture using Docker Compose, with a focus on database interactions, background processing, and external API integration. Follow the steps above to set up and run the project locally.