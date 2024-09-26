package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import payload.BookDto;
import service.BookService;

@RestController
@RequestMapping
public class BooksController {

	@Autowired
	private BookService bookService;
	
	@PostMapping
	public ResponseEntity<BookDto> saveBook(@RequestBody BookDto dto){
		BookDto bookDto=bookService.saveBook(dto);
		return new ResponseEntity<>(bookDto,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<BookDto> findBookById(@PathVariable int id){
		BookDto bookDto=bookService.findBookById(id);
		return new ResponseEntity<>(bookDto,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<BookDto>> getAllBooks(){
		List<BookDto> allBooks = bookService.getAllBooks();
		return new ResponseEntity<>(allBooks,HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<BookDto> updateBook(@PathVariable int id,@RequestBody BookDto dto){
		BookDto bookDto=bookService.updateBook(id,dto);
		return new ResponseEntity<>(bookDto,HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteeBook(@PathVariable int id){
		String deleteeBook = bookService.deleteeBook(id);
		return new ResponseEntity<>(deleteeBook,HttpStatus.OK);
	}
}
