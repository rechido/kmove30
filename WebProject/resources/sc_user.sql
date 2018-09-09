create user socialCommunity identified by 12345
default tablespace users
temporary tablespace temp;

grant connect, resource, alter session, create table, create sequence, create view to socialCommunity;

commit;