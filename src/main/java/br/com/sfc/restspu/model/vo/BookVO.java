package br.com.sfc.restspu.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BookVO extends RepresentationModel<BookVO> implements Serializable {

    private Long id;
    @EqualsAndHashCode.Include
    private String author;
    private Double price;
    @EqualsAndHashCode.Include
    private String title;
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private LocalDateTime launchDate;

}
