package br.com.sfc.restspu.service;

import br.com.sfc.restspu.exception.ResourceNotFoundException;
import br.com.sfc.restspu.model.Book;
import br.com.sfc.restspu.model.converter.DozerConverter;
import br.com.sfc.restspu.model.vo.BookVO;
import br.com.sfc.restspu.repository.BookRepository;
import br.com.sfc.restspu.resources.BookController;
import br.com.sfc.restspu.resources.PersonController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

    public Page<BookVO> findAll(int page,
                                int limit,
                                String direction) {
        var sortDirection = "desc".equalsIgnoreCase((direction)) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, limit, sortDirection, "title");

        var pageResult = bookRepository.findAll(pageable);

        Page<BookVO> bookVOS = pageResult.map(this::convertToBookVO);

        bookVOS.stream().forEach(p -> p.add(linkTo(methodOn(BookController.class)
                .findById(p.getId())).withSelfRel()));

        return bookVOS;
    }

    private BookVO convertToBookVO(Book entity) {
        return DozerConverter.parseObject(entity, BookVO.class);
    }

}
