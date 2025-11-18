# user-management-service
user-management-service task from Looyt company

# User Management Service

A RESTful API service for managing users built with Spring Boot and PostgreSQL.

## 🚀 Live Demo

**Base URL:** `https://your-app-name.onrender.com`

**Health Check:** `https://your-app-name.onrender.com/api/users/health`

⚠️ **Note:** Free tier may take 30-60 seconds for first request (cold start).

---

## 📋 Features

- Create, Read, Update, Delete (CRUD) users
- Input validation
- Error handling with proper HTTP status codes
- PostgreSQL database
- Dockerized application
- Deployed and accessible online

---

## 🛠️ Tech Stack

- **Java 21**
- **Spring Boot 3.x**
- **PostgreSQL 15**
- **Docker & Docker Compose**
- **Maven**

---

## 📦 Local Setup

### Prerequisites

- Java 21+
- PostgreSQL
- Docker & Docker Compose (optional)

### Option 1: Run with Docker Compose (Recommended)
```bash
# Clone repository
git clone https://github.com/yourusername/user-management-service.git
cd user-management-service

# Start application and database
docker-compose up --build

# Application runs on http://localhost:8081
```

### Option 2: Run Locally
```bash
# Create database
psql -U postgres
CREATE DATABASE usermanagement;
\q

# Configure application.properties with your database credentials

# Run application
./mvnw spring-boot:run
```

---

## 🔌 API Endpoints

### Base URL: `/api/users`

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/health` | Health check |
| POST | `/` | Create new user |
| GET | `/` | Get all users |
| GET | `/{id}` | Get user by ID |
| PUT | `/{id}` | Update user |
| DELETE | `/{id}` | Delete user |

---

## 📝 API Usage Examples

### 1. Health Check
```bash
curl https://your-app-name.onrender.com/api/users/health
```

**Response:**
```
User Management Service is running!
```

### 2. Create User
```bash
curl -X POST https://your-app-name.onrender.com/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "email": "john.doe@example.com",
    "phone": "+1234567890",
    "role": "ADMIN"
  }'
```

**Response (201 Created):**
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com",
  "phone": "+1234567890",
  "role": "ADMIN",
  "createdAt": "2025-11-17T10:30:00",
  "updatedAt": "2025-11-17T10:30:00"
}
```

### 3. Get All Users
```bash
curl https://your-app-name.onrender.com/api/users
```

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john.doe@example.com",
    "phone": "+1234567890",
    "role": "ADMIN",
    "createdAt": "2025-11-17T10:30:00",
    "updatedAt": "2025-11-17T10:30:00"
  }
]
```

### 4. Get User by ID
```bash
curl https://your-app-name.onrender.com/api/users/1
```

**Response (200 OK):**
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com",
  "phone": "+1234567890",
  "role": "ADMIN",
  "createdAt": "2025-11-17T10:30:00",
  "updatedAt": "2025-11-17T10:30:00"
}
```

### 5. Update User
```bash
curl -X PUT https://your-app-name.onrender.com/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Updated",
    "email": "john.updated@example.com",
    "phone": "+9876543210",
    "role": "USER"
  }'
```

**Response (200 OK):**
```json
{
  "id": 1,
  "name": "John Updated",
  "email": "john.updated@example.com",
  "phone": "+9876543210",
  "role": "USER",
  "createdAt": "2025-11-17T10:30:00",
  "updatedAt": "2025-11-17T10:45:00"
}
```

### 6. Delete User
```bash
curl -X DELETE https://your-app-name.onrender.com/api/users/1
```

**Response (204 No Content)**

---

### 7. Get Users with Pagination
```bash
curl "https://your-app-name.onrender.com/api/users?page=0&size=5"
```

**Response (200 OK):**
```json
{
  "users": [...],
  "currentPage": 0,
  "totalItems": 15,
  "totalPages": 3
}
```

### 8. Search User by Email
```bash
curl "https://your-app-name.onrender.com/api/users/search?email=john.doe@example.com"
```

### 9. API Info
```bash
curl https://your-app-name.onrender.com/api/info
```

**Shows all available endpoints**


## 🚨 Error Responses

### Validation Error (400 Bad Request)
```json
{
  "timestamp": "2025-11-17T10:30:00",
  "message": "Validation failed",
  "errors": {
    "email": "Email should be valid",
    "name": "Name is required"
  },
  "status": 400
}
```

### User Not Found (404 Not Found)
```json
{
  "timestamp": "2025-11-17T10:30:00",
  "message": "User not found with id: 99",
  "status": 404
}
```

---

## 📁 Project Structure
```
src/main/java/com/yourname/usermanagement/
├── controller/      # REST controllers
├── service/         # Business logic
├── repository/      # Data access layer
├── model/           # Entity classes
├── dto/             # Data Transfer Objects
└── exception/       # Exception handling
```

---

## 🐳 Docker Commands
```bash
# Build and start
docker-compose up --build

# Run in background
docker-compose up -d

# View logs
docker-compose logs -f app

# Stop containers
docker-compose down

# Remove volumes (clean database)
docker-compose down -v
```

---

## 👤 Author

Your Name - [GitHub Profile](https://github.com/yourusername)

---

## 📄 License

This project is open source and available under the MIT License.
