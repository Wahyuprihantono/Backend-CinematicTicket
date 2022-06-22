package com.bioskop.service;

import com.bioskop.model.Films;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface FilmsService {

    Films getFilmByFilmName(String filmName);

    Films getFilmByFilmId(Integer filmId);

    Films addFilm(Films films);

    Films updateFilm(Films films);

    String deleteFilm(Integer filmId);

    void getSchedulesFilms(Integer filmId);

    List<Films> getFilmTayang();

    List<Films> getAllFilms();
}