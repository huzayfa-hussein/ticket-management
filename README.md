# 🎟️ Ticket Management System (Spring Boot + Kotlin)

A simple REST API demo built with **Spring Boot** and **Kotlin**, showcasing basic ticket management operations including creation, retrieval, update, deletion, and filtering by status and priority.

---

## 🚀 Features

- Create a new ticket
- Update existing tickets
- Delete tickets
- Retrieve all tickets
- Retrieve tickets by ID
- Filter tickets by:
  - Status (e.g., OPEN, CLOSED)
  - Priority (e.g., HIGH, MEDIUM, LOW)
  - Combined status and priority

---

## 🧱 Tech Stack

- Kotlin
- Spring Boot
- Spring Web
- Validation
- DTO & Request Models
- Clean Controller-Service Architecture

---

## 🔧 API Endpoints

| Method | Endpoint                  | Description                          |
|--------|---------------------------|--------------------------------------|
| GET    | `/api/v1/tickets/all`     | Get all tickets                      |
| GET    | `/api/v1/tickets?id={id}` | Get ticket by ID                     |
| POST   | `/api/v1/tickets/create`  | Create a new ticket                  |
| PATCH  | `/api/v1/tickets/update`  | Update an existing ticket            |
| DELETE | `/api/v1/tickets/delete`  | Delete a ticket                      |
| GET    | `/api/v1/tickets/get-by-status?status=` | Get tickets by status      |
| GET    | `/api/v1/tickets/get-by-priority?priority=` | Get tickets by priority |
| GET    | `/api/v1/tickets/filter?status=&priority=` | Filter by status & priority |

---

## 📁 Project Structure

src/ ├── controller/ │ └── TicketController.kt ├── dto/ │ └── TicketDto.kt ├── entity/ │ └── TicketStatus.kt, TicketPriority.kt ├── request/ │ └── CreateTicketRequest.kt, UpdateTicketRequest.kt ├── service/ │ └── TicketService.kt

## ▶️ Run the Project

```bash
./gradlew bootRun

or run directly from the IDE.
```

## 📌 Tags

#kotlin #springboot #restapi #backend #ticketing-system #springboot-kotlin-demo
