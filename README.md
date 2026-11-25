# Happy Mart - Shop Billing System

A React frontend and Spring Boot backend for managing products, stock, and sales.
The backend uses an embedded, file-based H2 database by default, so MySQL is not
required. Data is saved under `backend/data/` and remains available after restarts.

## Requirements

- Java 17 or newer
- Node.js 20.19+ or 22.12+
- Internet access on the first run to download Maven and project dependencies

You do not need to install Maven or MySQL. The Maven Wrapper downloads the
project's pinned Maven version automatically.

## Run the application

Open two terminals in the project folder.

### Backend

Linux/macOS:

```sh
cd backend
../mvnw spring-boot:run
```

Windows PowerShell or Command Prompt:

```bat
cd backend
..\mvnw.cmd spring-boot:run
```

The backend starts at `http://localhost:8080`.

### Frontend

```sh
cd frontend
npm ci
npm run dev
```

Open the URL printed by Vite, normally `http://localhost:5173`.
The frontend uses `/api` by default, and Vite proxies those requests to the
backend at `http://localhost:8080`, avoiding browser CORS and remote `localhost`
issues during development.

## Optional MySQL

MySQL is only needed if you want to use an existing MySQL server. Copy
`backend/.env.example` to `backend/.env`, fill in the connection values, then
activate the `mysql` Spring profile when starting the backend:

Linux/macOS:

```sh
SPRING_PROFILES_ACTIVE=mysql ../mvnw spring-boot:run
```

Windows PowerShell:

```powershell
$env:SPRING_PROFILES_ACTIVE = "mysql"
..\mvnw.cmd spring-boot:run
```

The default H2 database and the optional MySQL database are separate; switching
profiles does not migrate data between them.
