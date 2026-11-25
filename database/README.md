# Database Setup

MySQL me database aur tables create karne ke liye project root se chalaayein:

```powershell
mysql -u root -p < database\setup.sql
```

Password poochhne par MySQL root password enter karein.

Script following items create karega:

- `shop_billing_db` database
- `product` table
- `sale` table
- `sale_item` table
- `sale_items` relationship table
- Tea, Coffee, Biscuits aur Milk ke sample products

Setup ke baad verification:

```sql
USE shop_billing_db;
SHOW TABLES;
SELECT * FROM product;
```
