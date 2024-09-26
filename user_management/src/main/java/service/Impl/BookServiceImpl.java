package service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import entity.Book;
import payload.BookDto;
import repository.BookRepository;
import service.BookService;

public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	
	@Override
	public BookDto saveBook(BookDto dto) {
		Book book = new Book();
		book.setTittle(dto.getTittle());
		book.setAurthor(dto.getAurthor());
		book.setPrice(dto.getPrice());
		Book saveBook =bookRepository.save(book);
		BookDto bookDto= new BookDto();
		bookDto.setTittle(saveBook.getTittle());
		bookDto.setAurthor(saveBook.getAurthor());
		bookDto.setPrice(saveBook.getPrice());
		return bookDto;
	}


	@Override
	public BookDto findBookById(int id) {
		Book book = bookRepository.findById(id).get();
		BookDto bookDto= new BookDto();
		bookDto.setTittle(book.getTittle());
		bookDto.setAurthor(book.getAurthor());
		bookDto.setPrice(book.getPrice());
		return bookDto;
	}


	@Override
	public BookDto updateBook(int id, BookDto dto) {
		Book book = bookRepository.findById(id).get();
		book.setTittle(dto.getTittle());
		book.setAurthor(dto.getAurthor());
		book.setPrice(dto.getPrice());
		Book saveBook =bookRepository.save(book);
	
		BookDto bookDto= new BookDto();
		bookDto.setTittle(saveBook.getTittle());
		bookDto.setAurthor(saveBook.getAurthor());
		bookDto.setPrice(saveBook.getPrice());
		return bookDto;
	}


	@Override
	public String deleteeBook(int id) {
		Optional<Book> byId = bookRepository.findById(id);
		if(byId.isPresent()) {
			bookRepository.deleteById(id);
			return "book successfully deleted";
		}
		return "no book found with id:"+id;
	}


	@Override
	public List<BookDto> getAllBooks() {
	    List<Book> allBooks = bookRepository.findAll();

	    // Convert List<Book> to List<BookDto>
	    List<BookDto> bookDtos = allBooks.stream().map(book -> {
	        BookDto bookDto = new BookDto();
	        bookDto.setTittle(book.getTittle());
	        bookDto.setAurthor(book.getAurthor());
	        bookDto.setPrice(book.getPrice());
	        return bookDto;
	    }).collect(Collectors.toList());

	    return bookDtos;
	}

}
