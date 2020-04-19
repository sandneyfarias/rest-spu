package br.com.sfc.restspu.security;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AccountCredentialsVO implements Serializable {

    @EqualsAndHashCode.Include
    private String username;
    private String password;

}
