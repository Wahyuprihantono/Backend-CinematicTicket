package com.bioskop.service;

import com.bioskop.model.Films;
import com.bioskop.model.Schedules;
import com.bioskop.repository.FilmsRepository;
import com.bioskop.repository.SchedulesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FilmsServiceImpl implements FilmsService {

    private static final Logger LOG = LoggerFactory.getLogger(FilmsServiceImpl.class);

    @Autowired
    private FilmsRepository filmsRepository;

    @Autowired
    private SchedulesRepository schedulesRepository;

    @Autowired
    public FilmsServiceImpl(FilmsRepository filmsRepository) {
        this.filmsRepository = filmsRepository;
    }

    @Cacheable(value = "getFilmByFilmName")
    @Override
    public Films getFilmByFilmName(String filmName) {
        return filmsRepository.findByFilmName(filmName);
    }

    @Override
    public Films getFilmByFilmId(Integer filmId) {
        return filmsRepository.findByFilmId(filmId);
    }

    @Override
    public Films addFilm(Films films) {
        films.getFilmCode();
        films.getFilmName();
        films.getIsShow();
        return filmsRepository.save(films);
    }

    @Override
    public Films updateFilm(Films films) {
        films.getFilmCode();
        Films updateFilm = filmsRepository.findByFilmId(films.getFilmId());
        updateFilm.setFilmCode(films.getFilmCode());
        updateFilm.setFilmName(films.getFilmName());
        updateFilm.setIsShow(films.getIsShow());
        return filmsRepository.save(films);
    }

    @Override
    public String deleteFilm(Integer filmId) {
        filmsRepository.deleteById(filmId);
        return "Delete film id " + filmId + " has been successful!";
    }

    @Override
    public void getSchedulesFilms(Integer filmId) {
        List<Schedules> listSchedules = schedulesRepository.findSchedulesByFilmId(filmId);
        listSchedules.forEach(schedules -> LOG.info(listSchedules.toString()));
    }

    @Override
    public List<Films> getFilmTayang() {
        return filmsRepository.getFilmTayang();
    }

    @Cacheable(value = "getAllFilms")
    @Override
    public List<Films> getAllFilms() {
        return filmsRepository.findAll();
    }
}