DROP TABLE if EXISTS location
DROP TABLE if EXISTS user

CREATE TABLE location(
    id int auto_increment primary key,
    lat double,
    lng double,
    place varchar_ignorecase(50) not null,
    description varchar_ignorecase(50) not null
);

CREATE TABLE user(
    id int auto_increment primary key,
    username varchar_ignorecase(50),
    first_name varchar_ignorecase(50),
    last_name varchar_ignorecase(50),
    password varchar_ignorecase(50) not null,
    email varchar_ignorecase(50) not null
)