drop sequence  IF EXISTS hibernate_sequence;
create sequence hibernate_sequence;

drop table IF EXISTS customers;
create table customers
(
    id                 	bigint    not null,
    created_date       	timestamp not null,
    last_modified_date 	timestamp,
    email              	varchar(255),
    enabled           	boolean   not null,
    first_name         	varchar(255),
    last_name          	varchar(255),
    telephone          	varchar(255)
);

alter table customers add constraint customer_pk primary key (id);
