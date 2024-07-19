CREATE TABLE product(id bigint not null AUTO_INCREMENT,
                     productName varchar(255),
                     description varchar(255),
                     productPrice decimal,
                     quantity bigint,
                     primary key(id));