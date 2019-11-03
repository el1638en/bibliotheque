drop database if exists bibliotheque;
drop role if exists bibliotheque;
-- create the requested bibliotheque user

create user bibliotheque createdb password 'bibliotheque';

-- create a bibliotheque database
create database bibliotheque owner bibliotheque;