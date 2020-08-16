delete user table if exists;

create table user(
	id bigint ,
	email varchar ,
	name varchar ,
	password varchar ,
	token varchar ,
	token_creation_date timestamp
);
