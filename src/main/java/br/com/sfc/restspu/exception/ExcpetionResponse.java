package br.com.sfc.restspu.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class ExcpetionResponse implements Serializable {

    private Date timestamp;
    private String message;
    private String details;

}
