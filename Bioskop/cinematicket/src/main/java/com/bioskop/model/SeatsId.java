package com.bioskop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor

public class SeatsId implements Serializable{
    @Column
    private Character studioName;

    @Column
    private String seatsCode;

    public void seatsId(Character studioName, String seatsCode){
        this.studioName = studioName;
        this.seatsCode = seatsCode;
    }
}