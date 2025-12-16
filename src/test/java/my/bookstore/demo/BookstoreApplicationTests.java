package my.bookstore.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookstoreApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private BookRepository bookRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void shouldUpdateBook() {
		// Given
		Book book = new Book("Original Title", "Original Author");
		book = bookRepository.save(book);
		Book updatedBook = new Book("Updated Title", "Updated Author");

		// When
		ResponseEntity<Book> response = restTemplate.exchange(
				"/books/{id}",
				HttpMethod.PUT,
				new HttpEntity<>(updatedBook),
				Book.class,
				book.getId());

		// Then
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getTitle()).isEqualTo("Updated Title");
		assertThat(response.getBody().getAuthor()).isEqualTo("Updated Author");

		Book bookFromDb = bookRepository.findById(book.getId()).orElseThrow();
		assertThat(bookFromDb.getTitle()).isEqualTo("Updated Title");
		assertThat(bookFromDb.getAuthor()).isEqualTo("Updated Author");
	}
}
