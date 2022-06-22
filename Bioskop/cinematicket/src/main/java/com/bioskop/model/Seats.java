package com.bioskop.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Getter
@Setter
@Entity
@IdClass(SeatsId.class)
public class Seats {
    @Id
    private Character studioName;

    @Id
    private String seatsCode;
}
