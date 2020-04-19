package br.com.sfc.restspu.resources;

import br.com.sfc.restspu.model.vo.BookVO;
import br.com.sfc.restspu.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping(value = "/api/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml"})
    public BookVO findById(@PathVariable("id") Long id) {
        BookVO BookVO = bookService.findById(id);
        BookVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
        return BookVO;
    }

    @GetMapping(produces = { "application/json", "application/xml", "application/x-yaml"})
    public List<BookVO> findAll() {
        List<BookVO> BookVOS = bookService.findAll();
        BookVOS.stream().forEach(p -> p.add(linkTo(methodOn(BookController.class)
                .findById(p.getId())).withSelfRel()));
        return BookVOS;
    }

    @PostMapping(produces = { "application/json", "application/xml", "application/x-yaml"},
            consumes = { "application/json", "application/xml", "application/x-yaml"})
    public BookVO create(@RequestBody BookVO book) {
        BookVO BookVO = bookService.create(book);
        BookVO.add(linkTo(methodOn(BookController.class).findById(book.getId())).withSelfRel());
        return BookVO;
    }

    @PutMapping(produces = { "application/json", "application/xml", "application/x-yaml"},
            consumes = { "application/json", "application/xml", "application/x-yaml"})
    public BookVO update(@RequestBody BookVO book) {
        BookVO BookVO = bookService.update(book);
        BookVO.add(linkTo(methodOn(BookController.class).findById(book.getId())).withSelfRel());
        return BookVO;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
