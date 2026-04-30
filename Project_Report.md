# Spring Boot CRUD Application: Library Management System

## Overview
This project is a Spring Boot application designed to manage a Library Catalog. It features two entities: **Books** and **Authors**, establishing a many-to-one relationship (Many books can belong to one author). The application implements Create, Read, and Update (CRUD) operations and follows a layered architecture using Spring MVC (Model-View-Controller).

## Entity Relationship Design
The domain model consists of two main entities:
- **Author**: Represents a book author. It has fields like `id`, `name`, and `biography`. It has a one-to-many relationship with `Book` (mapped by the `author` field).
- **Book**: Represents a book. It contains `id`, `title`, `genre`, `price`, and a many-to-one relationship with `Author`.

This relationship is managed using JPA annotations `@OneToMany` and `@ManyToOne`, with an inner join custom query to fetch both entities efficiently.

## Implementation Details

### 1. Database Population
The `DataInitializer` component implements `CommandLineRunner` to insert 10 sample Authors and 10 sample Books into the database during application startup.

### 2. Read Operation
- **Repository**: Created a custom query `@Query("SELECT b FROM Book b JOIN b.author a") List<Book> findAllWithAuthors();` in `BookRepository.java` to perform an inner join and fetch books with author details.
- **Controller & View**: The `/books` endpoint fetches this list and passes it to `list.jsp`, which renders it using JSTL tags inside a beautifully styled responsive table.

### 3. Create Operation
- **View**: A user-friendly form is available at `/books/add`.
- **Controller**: Accepts the POST request and saves the Book entity.
- **Exception Handling**: A `GlobalExceptionHandler` with `@ControllerAdvice` is implemented to catch `DataIntegrityViolationException` and redirect the user to an `error.jsp` page in case of missing or duplicate data.

### 4. Update Operation
- **View**: Clicking the "Edit" button for a specific book routes to `/books/edit/{id}`, pre-filling an HTML form.
- **Controller**: Processes the form submission, updates the entity details, and saves them back to the repository.

### 5. Testing
Unit tests were written using JUnit 5 and Mockito:
- **Repository Test**: Used `@DataJpaTest` to verify the custom inner-join query.
- **Service Test**: Mocked the repository layer to ensure the business logic functions appropriately without making real database calls.

## Challenges Faced & Resolutions
- **Challenge**: Managing the Many-To-One mapping efficiently without causing N+1 select query issues.
  - **Resolution**: Utilized a custom JPQL query with an explicit `JOIN` in `BookRepository` to fetch books and their corresponding authors in a single query.
- **Challenge**: Passing data appropriately from the Service layer to the JSP views while maintaining a responsive and modern design.
  - **Resolution**: Used a centralized CSS file (`styles.css`) and JSTL (`<c:forEach>`) to dynamically populate the HTML structure, ensuring a separation of concerns and an elegant user interface.

## GitHub URL
[https://github.com/pravallikha502/Spring-Boot-application](https://github.com/pravallikha502/Spring-Boot-application)
