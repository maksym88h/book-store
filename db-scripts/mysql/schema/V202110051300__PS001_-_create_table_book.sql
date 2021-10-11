CREATE TABLE book
(
    id      BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(255),
    price   DOUBLE (10, 2),
    cover   VARCHAR(255),
    description VARCHAR(500)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
