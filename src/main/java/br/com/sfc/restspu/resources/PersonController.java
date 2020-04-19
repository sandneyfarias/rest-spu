package br.com.sfc.restspu.resources;

import br.com.sfc.restspu.model.vo.PersonVO;
import br.com.sfc.restspu.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping(value = "/api/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml"})
    public PersonVO findById(@PathVariable("id") Long id) {
        PersonVO personVO = personService.findById(id);
        personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return personVO;
    }

    @GetMapping(produces = { "application/json", "application/xml", "application/x-yaml"})
    public List<PersonVO> findAll() {
        List<PersonVO> personVOS = personService.findAll();
        personVOS.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class)
                .findById(p.getId())).withSelfRel()));
        return personVOS;
    }

    @PostMapping(produces = { "application/json", "application/xml", "application/x-yaml"},
            consumes = { "application/json", "application/xml", "application/x-yaml"})
    public PersonVO create(@RequestBody PersonVO person) {
        PersonVO personVO = personService.create(person);
        personVO.add(linkTo(methodOn(PersonController.class).findById(person.getId())).withSelfRel());
        return personVO;
    }

    @PutMapping(produces = { "application/json", "application/xml", "application/x-yaml"},
            consumes = { "application/json", "application/xml", "application/x-yaml"})
    public PersonVO update(@RequestBody PersonVO person) {
        PersonVO personVO = personService.update(person);
        personVO.add(linkTo(methodOn(PersonController.class).findById(person.getId())).withSelfRel());
        return personVO;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        personService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
