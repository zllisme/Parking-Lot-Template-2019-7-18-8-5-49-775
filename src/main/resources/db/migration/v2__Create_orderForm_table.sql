create table order_form (
    ID int primary key,
    PARKING_LOT_NAME varchar(50),
    PLATE_NUMBER varchar(50),
    CREATE_TIME timestamp,
    END_TIME timestamp,
    STATE boolean
);