# Getting Started

gradlew.bat :bootRun

./gradlew :bootRun


curl localhost:8080/books

curl -X PUT -H "Content-Type: application/json" -d '{"title": "Updated Title", "author": "Updated Author"}'  http://localhost:8080/books/1