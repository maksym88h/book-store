CREATE TABLE books
(
    id      BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(255),
    price   DOUBLE (10, 2),
    cover   VARCHAR(255),
    description VARCHAR(500)
);
