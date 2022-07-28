# Market-place-app
![](https://truust.io/wp-content/uploads/sites/18/2017/09/Que%CC%81-es-un-Marketplace-y-co%CC%81mo-puedes-ganar-dinero-con-e%CC%81l.jpg)


#  Project Description
This simple application of working marketplace with:
- creating, deleting, editing, displaying products
- creating, deleting, editing, displaying users

##  Project Structure

This Project is based on 3-layered architecture:

- Data access layer (repository)

- Application layer (service)

- Presentation layer (controllers)

## Technologies:
- JAVA 11+
- Spring Boot, REST, Spring Data JPA, JDBC
- Swagger
- Hibernate
- Git
- MySQL
- Maven

## System requirements

- IntelliJ IDEA Ultimate IDEA
- Postman
- Database (MySQL)

## Configure you env

- First, make sure your env meets requirements listed above
- Create schema in MySQL
- Then clone project on your IDE, change your driver, url, username and password in resources/application.properties file
- Install Postman
- After loading app system from the start has 3 products and 3 users. 
  You can test app in Postman using next urls:

| Actions                          | Endpoints                                         |
|----------------------------------|---------------------------------------------------|
| Create new product               | POST http://localhost:8080/products               |
| Get product by id                | GET http://localhost:8080/products/1              |
| Get all products                 | GET http://localhost:8080/products                |
| Update product by id             | PUT http://localhost:8080/products/1              |
| Delete product by id             | DELETE http://localhost:8080/products/1           |
| Get all products by user id      | PUT http://localhost:8080/products/users/1        |
| Create new user                  | POST http://localhost:8080/users                  |
| Get user by id                   | GET http://localhost:8080/users/1                 |
| Get all users                    | GET http://localhost:8080/users                   |
| Update user by id                | PUT http://localhost:8080/users/1                 |
| Delete user by id                | DELETE http://localhost:8080/users/1              |
| Update user after buying product | PUT http://localhost:8080/users/1/buy?productId=2 |
| Get all users by product id      | PUT http://localhost:8080/users/products/1        |