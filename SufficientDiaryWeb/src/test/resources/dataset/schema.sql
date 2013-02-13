DROP TABLE IF EXISTS trx_user;
create table trx_user ( 
SUFF_ID    VARCHAR(35) not null PRIMARY KEY,
USERNAME   varchar(50) not null,
CREDENTIAL varchar(35) not null,
EXPIRY     timestamp ,
STATUS     varchar(20),
LAST_LOGIN timestamp ,
CREATED    timestamp ,
CREATED_BY varchar(50),
LAST_UPD   timestamp ,
UPD_BY     varchar(50)
);