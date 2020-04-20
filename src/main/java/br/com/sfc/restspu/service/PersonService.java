package br.com.sfc.restspu.service;

import br.com.sfc.restspu.exception.ResourceNotFoundException;
import br.com.sfc.restspu.model.Person;
import br.com.sfc.restspu.model.converter.DozerConverter;
import br.com.sfc.restspu.model.vo.PersonVO;
import br.com.sfc.restspu.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonVO create(PersonVO person) {
        var entity = DozerConverter.parseObject(person, Person.class);
        var vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);

        return vo;
    }

    public PersonVO update(PersonVO person) {
        var personEntity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No recrods found for this ID"));

        personEntity.setGender(person.getGender());
        personEntity.setAddress(person.getAddress());
        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());

        return DozerConverter.parseObject(personRepository.save(personEntity), PersonVO.class);
    }

    @Transactional
    public PersonVO disablePersonById(Long id) {
        personRepository.disablePerson(id);
        var entity = personRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No recrods found for this ID"));

        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public void deleteById(Long id) {
        Person personEntity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No recrods found for this ID"));

        personRepository.deleteById(id);
    }

    public PersonVO findById(Long id) {
        var entity = personRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No recrods found for this ID"));

        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public Page<PersonVO> findAll(Pageable pageable) {
        var page = personRepository.findAll(pageable);
        return page.map(this::convertToPersonVO);
    }

    private PersonVO convertToPersonVO(Person entity) {
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

}
