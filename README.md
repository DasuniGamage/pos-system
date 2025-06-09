# 🛒 Point of Sale (POS) System Backend – Spring Boot

This repository contains the backend implementation of a Point of Sale (POS) system developed using Spring Boot. The system provides a robust foundation for managing products, categories, transactions, and inventory-related data, enabling seamless integration with a frontend UI or mobile app.

## 🔧 Key Features

CRUD operations for product and category management

MySQL database integration using Spring Data JPA

API documentation with Swagger UI

DTO conversion using MapStruct and ModelMapper

Custom data types support using hibernate-types-5

Input validation with Jakarta Bean Validation

Development enhancements with Spring Boot DevTools

Simplified code with Lombok

## 🛠 Tech Stack

Java 11

Spring Boot 2.5.4

Spring Data JPA

MySQL


Lombok

MapStruct & ModelMapper

Swagger 2 (Springfox)

Hibernate Types

Jakarta Validation

## 📁 Project Structure

controller/ – Exposes RESTful endpoints

service/ & serviceImpl/ – Business logic layers

repository/ – Interfaces for DB operations

model/ – Entity classes representing the DB schema

dto/ – Data Transfer Objects for API interaction

exception/ – Global exception handling

## 🚀 Getting Started

Clone the repository:

git clone https://github.com/your-username/point-of-sale.git

cd point-of-sale


Configure the database:

Update the application.properties with your local MySQL credentials.

Run the application:

mvn spring-boot:run

Access Swagger UI:

http://localhost:8080/swagger-ui/

## 📌 Future Enhancements

User authentication & role-based access control (Spring Security + JWT)

Sales reports & analytics

Unit and integration tests

Docker support for containerization
