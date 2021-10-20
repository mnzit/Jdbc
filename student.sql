create table STUDENTS
(
    ID           bigint unsigned auto_increment,
    NAME         varchar(150)                         not null,
    DOB          datetime                             not null,
    ADDRESS      varchar(200)                         not null,
    CONTACT_NO   varchar(14)                          not null,
    CREATED_DATE timestamp  default CURRENT_TIMESTAMP null,
    STATUS       tinyint(1) default 1                 null,
    constraint CONTACT_NO
        unique (CONTACT_NO),
    constraint ID
        unique (ID)
);

alter table STUDENTS
    add primary key (ID);