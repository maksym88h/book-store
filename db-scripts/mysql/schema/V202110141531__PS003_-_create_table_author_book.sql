CREATE TABLE author_book
(
    author_id BIGINT NOT NULL,
    book_id   BIGINT NOT NULL ,
    FOREIGN KEY (author_id) REFERENCES author (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    PRIMARY KEY (author_id,book_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;