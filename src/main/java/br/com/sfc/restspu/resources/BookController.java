package br.com.sfc.restspu.resources;

import br.com.sfc.restspu.model.vo.BookVO;
import br.com.sfc.restspu.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Operation(summary = "Return all books")
    @GetMapping(produces = { "application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<PagedModel<BookVO>> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                        @RequestParam(value = "limit", defaultValue = "12") int limit,
                                                        @RequestParam(value = "direction", defaultValue = "asc") String direction,
                                                        PagedResourcesAssembler assembler) {
        Page<BookVO> bookVOS = bookService.findAll(page, limit, direction);
        return new ResponseEntity<>(assembler.toModel(bookVOS), HttpStatus.OK);
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
