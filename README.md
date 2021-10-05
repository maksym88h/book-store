# Book Store application

# Database Docker container
Create DB container based on MySQL:
.........
docker run --name books-db1 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=book_store -e MYSQL_USER=book_store -e MYSQL_PASSWORD=book_store -p 3306:3306 mysql:8.0.26 
.........
