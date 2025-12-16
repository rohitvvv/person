# Getting Started

gradlew.bat :bootRun

./gradlew :bootRun


curl localhost:8080/books

curl -X PUT -H "Content-Type: application/json" -d '{"title": "Updated Title", "author": "Updated Author"}'  http://localhost:8080/books/1

For paging
http://localhost:8080/books?page=0&size=5&sort=title,asc