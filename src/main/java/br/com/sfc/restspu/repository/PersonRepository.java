package br.com.sfc.restspu.repository;

import br.com.sfc.restspu.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Modifying
    @Query("Update Person p set p.enabled = 0 WHERE p.id = :id")
    void disablePerson(@Param("id") Long id);

}
