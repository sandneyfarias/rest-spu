package br.com.sfc.restspu.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 180)
    private String author;

    @Column(nullable = false)
    private Double price;

    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private String title;

    @Column(name = "launch_date", columnDefinition = "TIMESTAMP")
    @NotNull
    private LocalDateTime launchDate;

}
