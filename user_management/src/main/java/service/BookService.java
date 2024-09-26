package service;

import java.util.List;

import payload.BookDto;

public interface BookService {
	BookDto saveBook(BookDto dto);

	BookDto findBookById(int id);

	BookDto updateBook(int id, BookDto dto);

	String deleteeBook(int id);

	List<BookDto> getAllBooks();
}
