create schema 2tables;

create table CUSTOMERS
(
    id           int                     not null auto_increment,
    age          int check ( age < 150 ) not null,
    name         varchar(255)            not null,
    phone_number varchar(14)             not null,
    surname      varchar(255)            not null,
    primary key (id)
);

create table ORDERS
(
    id           int          not null auto_increment,
    amount       varchar(255) not null,
    date         varchar(10)  not null,
    product_name varchar(255) not null,
    customer_id  int          not null,
    primary key (id),
    foreign key (customer_id) references CUSTOMERS (id)
);