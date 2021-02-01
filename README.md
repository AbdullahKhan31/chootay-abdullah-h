# Chootay Bikes Shop
## First Time Run
On running the application for the first time the system will autmatically create 4 roles (ADMIN, MANAGER, MECHANIC, SALESPERSON) and an admin account CHOOTAY with password "password" will be created.
## DATABASE
MYSQL database is used for this application. The name of the database is chootay_bikes which will be automatically created when the application runs for the first time. username = root and password = root, you can change according to your system credentials.
## Application.proerties
spring.datasource.initialization-mode=always change this to spring.datasource.initialization-mode=never in application.properties after first time run.
## Application Details
applications port is changed to 8081, so the base url will be http://localhost:8081/
Swagger is added for the ease of end points documentation at http://localhost:8081/swagger-ui/
All the Request and Response bodies are documented via Swagger.