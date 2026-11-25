# Optional MySQL Database

The project runs without MySQL by default, using a local H2 database stored in
`backend/data/`. Use this SQL setup only when choosing the optional MySQL profile.

Run the script from the project root:

```sh
mysql -u root -p < database/setup.sql
```

The script creates `shop_billing_db`, the product and sales tables, and sample
products. Configure `backend/.env` and activate the `mysql` Spring profile as
described in the root README.
