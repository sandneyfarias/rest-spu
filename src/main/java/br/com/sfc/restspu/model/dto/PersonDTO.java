package br.com.sfc.restspu.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PersonDTO implements Serializable {

    private Long id;
    @EqualsAndHashCode.Include
    private String firstName;
    @EqualsAndHashCode.Include
    private String lasttName;
    @EqualsAndHashCode.Include
    private String address;
    @EqualsAndHashCode.Include
    private String gender;

}
