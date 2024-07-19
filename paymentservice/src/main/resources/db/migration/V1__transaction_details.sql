CREATE TABLE transaction_details(id bigint not null AUTO_INCREMENT,
                                 orderId bigint,
                                 paymentMode varchar(255),
                                 referenceNumber varchar(255),
                                 paymentStatus varchar(255),
                                 amount decimal,
                                 date date,
                                 primary key(id));