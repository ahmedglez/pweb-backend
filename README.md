# Pweb-Backend

## Description

This is the backend for the Pweb project, located in [](https://github.com/ahmedglez/pweb-jsf). It is a REST API that allows to create, read, update and delete users and their data. It also allows to create, read, update and delete posts and their data. It's about a car rental service where users can rent cars and post their own cars to rent. It's a simple CRUD application.

## Installation

### Requirements

- Java 8
- Maven
- PostgreSQL
- Spring Boot
- Spring Data JPA
- Spring Security
- Spring Web

### Steps

- Clone the repository
- Create a database in PostgreSQL
- Restore the database from the backup file located in the root of the project
- Create a file called `application.properties` in `src/main/resources` and add the following properties:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults=false
spring.jpa.properties.hibernate.jdbc.time_zone=UTC
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
```

- Run the application

## Usage

### Endpoints

- Go to swagger to see the endpoints and their documentation: [](http://localhost:8080/swagger-ui.html)

### Postman

- Import the collection located in the root of the project to Postman to test the endpoints

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

- [Baeldung](https://www.baeldung.com/)
- [Spring](https://spring.io/)
- [PostgreSQL](https://www.postgresql.org/)
- [Swagger](https://swagger.io/)
- [Postman](https://www.postman.com/)
- [StackOverflow](https://stackoverflow.com/)

## Colaborators

- **Ahmed Gonzalez** - [ahmedglez](https://github.com/ahmedglez)
- **Ernesto Abella** - [eaad2000](https://github.com/eaad2000)
- **Jeankarlo Santana** - [JeanCharlie](https://github.com/JeanCharlie)
