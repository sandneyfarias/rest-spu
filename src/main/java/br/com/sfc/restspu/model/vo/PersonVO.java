package br.com.sfc.restspu.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.BitSet;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {

    private Long id;

    @EqualsAndHashCode.Include
    private String firstName;

    @EqualsAndHashCode.Include
    private String lastName;

    @EqualsAndHashCode.Include
    private String address;

    @EqualsAndHashCode.Include
    private String gender;

    private Integer enabled;

}
