create schema 2tables;

create table CUSTOMERS
(
    id           int                     not null auto_increment,
    name         varchar(255)            not null,
    surname      varchar(255)            not null,
    age          int check ( age < 150 ) not null,
    phone_number varchar(14)             not null,
    primary key (id)
);

create table ORDERS
(
    id           int          not null auto_increment,
    date         varchar(10)  not null,
    customer_id  int          not null,
    product_name varchar(255) not null,
    amount       varchar(255) not null,
    primary key (id),
    foreign key (customer_id) references CUSTOMERS (id)
);

select product_name, customer_id from ORDERS O
join CUSTOMERS C on O.customer_id = C.id
where C.name = 'алексей'