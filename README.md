# Exam Management Application

A **Spring Boot** application for managing quizzes, exams, courses, and users. The project follows a RESTful architecture, using **Spring Data JPA** for database management and **Spring Boot** for backend logic.

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Features
- User management (CRUD operations)
- Course management
- Quiz and exam creation and management
- Question bank with categories and difficulty levels
- RESTful API for interaction
- Persistence using **Spring Data JPA**

## Technologies Used
- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **SQL**
- **IntelliJ IDEA**
- **GitHub for version control**

## Usage
- The backend provides a RESTful API for managing users, quizzes, courses, and exams.
- You can interact with the API using **Postman** or a frontend client.

## API Endpoints
| Method | Endpoint | Description |
|--------|---------|-------------|
| GET | `/questions` | Get all questions |
| GET | `/questions/get/{id}` | Get question by ID |
| POST | `/questions/new` | Create a new question |
| PUT | `/questions/update/{id}` | Update a questions |
| DELETE | `/questions/delete/{id}` | Delete a question |
| GET | `/quizzes` | Get all quizzes |
| GET | `/quizzes/get/{id}` | Get quiz by ID |
| POST | `/quizzes/new` | Create a new quiz |
| PUT | `/quizzes/update/{id}` | Update a quiz |
| DELETE | `/quizzes/delete/{id}` | Delete a quiz |
| GET | `/exams` | Get all exams |
| GET | `/exams/get/{id}` | Get exam by ID |
| POST | `/exams/new` | Create a new exam |
| PUT | `/exams/update/{id}` | Update an exam |
| DELETE | `/exams/delete/{id}` | Delete an exam |
| GET | `/users` | Get all users |
| GET | `/users/get/{id}` | Get user by ID |
| POST | `/users/new` | Create a new user |
| PUT | `/users/update/{id}` | Update a user |
| DELETE | `/users/delete/{id}` | Delete a user |
| GET | `/courses` | Get all courses |
| GET | `/courses/get/{id}` | Get course by ID |
| POST | `/courses/new` | Create a new course |
| PUT | `/courses/update/{id}` | Update a course |
| DELETE | `/courses/delete/{id}` | Delete a course |

