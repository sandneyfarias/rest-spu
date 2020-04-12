package br.com.sfc.restspu.service;

import br.com.sfc.restspu.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    public Person create(Person person) {
        return person;
    }

    public Person update(Person person) {
        return person;
    }

    public void deleteById(String id) {
    }

    public Person findById(String id) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Sandney");
        person.setLasttName("Farias");
        person.setAddress("Maeció - Alagoas - Brasil");
        person.setGender("Male");

        return person;
    }

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<Person>();

        for (int i = 0; i<= 8; i++) {
            Person person1 = mockPerson(i);
            persons.add(person1);
        }

        return persons;
    }

    private Person mockPerson(int id) {
        Person person1 = new Person();
        person1.setId(counter.incrementAndGet());
        person1.setFirstName("Sandney " + id);
        person1.setLasttName("Farias " + id);
        person1.setAddress("Maeció - Alagoas - Brasil " + id);
        person1.setGender("Male "  + id);

        return person1;
    }

}
