package az.developia.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.booking.dao.BookDAO;
import az.developia.booking.model.Book;

@RestController
@RequestMapping(path = "/books")
@CrossOrigin(origins="*")
public class BookRestController {

	@Autowired
	private BookDAO bookDAO;

	@PostMapping
	public Book save(@RequestBody Book book) {

		return bookDAO.save(book);

	}

	@GetMapping(path = "/find-all")
	public List<Book> findAll() {
		return bookDAO.findAll();

	}

	@GetMapping(path = "/find-by-id/{id}")
	public Book findById(@PathVariable(name = "id") Integer id) {
		return bookDAO.findById(id).get();

	}

	@PutMapping(path = "/update")
	public void update(@RequestBody Book book) {

		bookDAO.save(book);

	}

	//return this.http.delete(`${API_URL}/books/${id}`);
	@DeleteMapping(path="/{id}")
	public void delete(@PathVariable  Integer id){
		bookDAO.deleteById(id);
	}
	
	@GetMapping(path = "/validate")
	public void  validate(  ) {
		 

	}
	// api_url/books/find-partial/10/10
		@GetMapping(path = "/find-partial/{begin}/{length}")
		public List<Book> findAllPartial(@PathVariable(name = "begin") Integer begin,
				@PathVariable(name = "length") Integer length) {
			return bookDAO.findAllPartial(begin, length);

		}
}
