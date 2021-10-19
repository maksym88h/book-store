CREATE TABLE author
(
    id      BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name    VARCHAR(255),
    last_name VARCHAR(225),
    email   VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;