package com.bioskop.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity

public class Schedules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedules_id")
    private Integer schedulesId;

    @ManyToOne(targetEntity = Films.class)
    @JoinColumn(name = "film_id", nullable = false)
    private Films filmId;

    @NotBlank
    @Size(max = 25)
    @Column(name = "tanggal_tayang")
    private String tanggalTayang;

    @NotBlank
    @Size(max = 25)
    @Column(name = "jam_mulai")
    private String jamMulai;

    @NotBlank
    @Size(max = 25)
    @Column(name = "jam_selesai")
    private String jamSelesai;

    @NotBlank
    @Size(max = 25)
    @Column(name = "harga_tiket")
    private Integer hargaTiket;
}
