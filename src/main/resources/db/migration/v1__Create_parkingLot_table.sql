create table parking_lot (
    ID int primary key,
    NAME varchar(50) unique,
    CAPACITY int check(capacity > 0),
    location varchar(100)
);