package br.com.sfc.restspu.resources;

import br.com.sfc.restspu.model.vo.PersonVO;
import br.com.sfc.restspu.service.PersonService;
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
@RequestMapping(value = "/api/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @Operation(summary = "Return ther person data identified by id")
    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml"})
    public PersonVO findById(@PathVariable("id") Long id) {
        PersonVO personVO = personService.findById(id);
        personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return personVO;
    }

    @Operation(summary = "Return all persons and informations")
    @GetMapping(produces = { "application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<PagedModel<PersonVO>> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                        @RequestParam(value = "limit", defaultValue = "12") int limit,
                                                        @RequestParam(value = "direction", defaultValue = "asc") String direction,
                                                        PagedResourcesAssembler assembler) {
        var sortDirection = "desc".equalsIgnoreCase((direction)) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, limit, sortDirection, "firstName");

        Page<PersonVO> personVOS = personService.findAll(pageable);
        personVOS.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class)
                .findById(p.getId())).withSelfRel()));
        return new ResponseEntity<>(assembler.toModel(personVOS), HttpStatus.OK);
    }

    @Operation(summary = "Insert person data")
    @PostMapping(produces = { "application/json", "application/xml", "application/x-yaml"},
            consumes = { "application/json", "application/xml", "application/x-yaml"})
    public PersonVO create(@RequestBody PersonVO person) {
        PersonVO personVO = personService.create(person);
        personVO.add(linkTo(methodOn(PersonController.class).findById(person.getId())).withSelfRel());
        return personVO;
    }

    @Operation(summary = "Update person data")
    @PutMapping(produces = { "application/json", "application/xml", "application/x-yaml"},
            consumes = { "application/json", "application/xml", "application/x-yaml"})
    public PersonVO update(@RequestBody PersonVO person) {
        PersonVO personVO = personService.update(person);
        personVO.add(linkTo(methodOn(PersonController.class).findById(person.getId())).withSelfRel());
        return personVO;
    }

    @Operation(summary = "Disable one person by your id")
    @PatchMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml"})
    public PersonVO disablePersonById(@PathVariable("id") Long id) {
        PersonVO personVO = personService.disablePersonById(id);
        personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return personVO;
    }

    @Operation(summary = "Delete one person by your id")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        personService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
