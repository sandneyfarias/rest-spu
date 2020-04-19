package br.com.sfc.restspu.service;

import br.com.sfc.restspu.exception.ResourceNotFoundException;
import br.com.sfc.restspu.model.Book;
import br.com.sfc.restspu.model.converter.DozerConverter;
import br.com.sfc.restspu.model.vo.BookVO;
import br.com.sfc.restspu.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookVO create(BookVO book) {
        var entity = DozerConverter.parseObject(book, Book.class);
        var vo = DozerConverter.parseObject(bookRepository.save(entity), BookVO.class);

        return vo;
    }

    public BookVO update(BookVO book) {
        var bookEntity = bookRepository.findById(book.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No recrods found for this ID"));

        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setLaunchDate(book.getLaunchDate());
        bookEntity.setPrice(book.getPrice());
        bookEntity.setTitle(book.getTitle());

        return DozerConverter.parseObject(bookRepository.save(bookEntity), BookVO.class);
    }

    public void deleteById(Long id) {
        Book bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No recrods found for this ID"));

        bookRepository.deleteById(id);
    }

    public BookVO findById(Long id) {
        var entity = bookRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No recrods found for this ID"));

        return DozerConverter.parseObject(entity, BookVO.class);
    }

    public List<BookVO> findAll() {
        return DozerConverter.parseListObjects(bookRepository.findAll(), BookVO.class);
    }

}
