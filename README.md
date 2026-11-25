# Happy Mart – Shop Billing System

College project: React frontend + Java Spring Boot backend + MySQL database.

## Features
- Add, edit and delete products / stock
- Counter screen: add products to cart and change quantity
- Automatic stock reduction after billing
- Printable customer bill / invoice
- White, colourful responsive user interface

## Setup

### 1. MySQL
Start MySQL on your computer. The database `shop_billing_db` is created automatically when the backend runs.

### 2. Backend (Java 17 and Maven needed)
1. Open the `backend` folder.
2. Open `.env` and replace `CHANGE_ME` with your MySQL password.
3. Run `ShopBillingApplication`. The backend automatically reads this `.env` file.

Or in PowerShell, inside `backend`:
```powershell
mvn spring-boot:run
```

Backend will run at `http://localhost:8080`.

### 3. Frontend (Node.js needed)
1. Open the `frontend` folder.
2. Copy `.env.example` to `.env`.
3. Run:
```powershell
npm install
npm run dev
```
4. Open the shown URL, normally `http://localhost:5173`.

## Environment files
- `frontend/.env` has `VITE_API_URL`, the frontend-to-backend connection.
- `backend/.env` is a ready reference for database credentials. Spring Boot reads the same names (`DB_HOST`, `DB_PORT`, `DB_NAME`, `DB_USERNAME`, `DB_PASSWORD`) when supplied as environment variables by your IDE or terminal.
