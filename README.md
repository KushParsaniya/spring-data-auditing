# Spring Data JPA Auditing Example

This repository demonstrates how to implement **Spring Data JPA Auditing** in a Spring Boot application. It includes examples of tracking entity changes using annotations like `@CreatedBy`, `@CreatedDate`, `@LastModifiedBy`, and `@LastModifiedDate`. The project also integrates **Spring Security** for dynamic user tracking and uses **Testcontainers** for integration testing with a real PostgreSQL database.

## 📝 Medium Article

You can find the detailed article explaining this implementation here:  
🔗 **[Mastering Auditing in Spring Data JPA: Track Entity Changes Effortlessly](https://medium.com/@kushparsaniya/mastering-auditing-in-spring-data-jpa-track-entity-changes-effortlessly-cdd18859d0c8)**

---

## 🚀 Features

- **Spring Data JPA Auditing**: Automatically track entity creation and modification timestamps.
- **Spring Security Integration**: Dynamically populate `createdBy` and `modifiedBy` fields with the currently authenticated user.
- **Testcontainers**: Run integration tests against a real PostgreSQL database.
- **Example Entity**: A fully audited `Order` entity with fields for creation and modification metadata.

---

## 🛠️ Technologies Used

- **Spring Boot**: The core framework for building the application.
- **Spring Data JPA**: Simplifies database interactions and enables auditing.
- **Spring Security**: Handles user authentication and provides the current user for auditing.
- **Testcontainers**: Provides lightweight, disposable instances of PostgreSQL for testing.
- **PostgreSQL**: The relational database used for this example.

---

## 🏁 Getting Started

### Prerequisites

- Java 17 or higher
- Gradle
- Docker (for running Testcontainers)

### Setup

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/KushParsaniya/spring-data-auditing.git
    cd spring-data-auditing
    ```
2. **Run the Application**:
    ```bash
    ./gradlew bootRun
    ```
3. **Run Tests**:
   The integration tests use Testcontainers to spin up a PostgreSQL database. To run the tests, use:
    ```bash
    ./gradlew test
    ```