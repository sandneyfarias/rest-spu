package br.com.sfc.restspu.model.security;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Permission implements GrantedAuthority, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @EqualsAndHashCode.Include
    @Column(name = "description")
    private String description;

    @Override
    public String getAuthority() {
        return null;
    }

}
