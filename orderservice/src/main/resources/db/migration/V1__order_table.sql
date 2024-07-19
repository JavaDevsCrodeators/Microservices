CREATE TABLE order(id bigint not null AUTO_INCREMENT,
                         productId bigint,
                         totalPrice Decimal,
                         quantity bigint);