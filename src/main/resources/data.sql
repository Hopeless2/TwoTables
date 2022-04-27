select product_name from ORDERS O
join CUSTOMERS C on O.customer_id = C.id
where C.name = :name