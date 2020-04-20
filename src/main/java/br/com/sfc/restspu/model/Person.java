package br.com.sfc.restspu.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.BitSet;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 100)
    private String firstName;

    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 100)
    private String lastName;

    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 100)
    private String address;

    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 6)
    private String gender;

    @Column(nullable = false)
    private Integer enabled;

}
