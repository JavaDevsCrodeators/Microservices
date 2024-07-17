CREATE TABLE master_product(id bigint not null AUTO_INCREMENT,
                              productId bigint,
                              productName varchar(255),
                              description varchar(255),
                              productPrice DECIMAL(50,5),
                              quantity bigint,
                              PRIMARY KEY (id);