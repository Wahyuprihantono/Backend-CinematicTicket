package com.bioskop.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "film_code"),
        @UniqueConstraint(columnNames = "film_name")
})

public class Films {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Integer filmId;

    @NotBlank
    @Size(max = 25)
    @Column(name = "film_code")
    private String filmCode;

    @NotBlank
    @Size(max = 50)
    @Column(name = "film_name")
    private String filmName;

    @NotBlank
    @Column(name = "is_show")
    private Boolean isShow;
}
