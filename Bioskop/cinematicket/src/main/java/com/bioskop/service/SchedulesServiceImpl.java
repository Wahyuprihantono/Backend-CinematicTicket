package com.bioskop.service;

import com.bioskop.model.Films;
import com.bioskop.model.Schedules;
import com.bioskop.repository.FilmsRepository;
import com.bioskop.repository.SchedulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SchedulesServiceImpl implements SchedulesService {

    @Autowired
    private FilmsRepository filmsRepository;

    @Autowired
    private FilmsService filmsService;

    @Autowired
    private SchedulesRepository schedulesRepository;

    @Autowired
    public SchedulesServiceImpl(SchedulesRepository schedulesRepository) {
        this.schedulesRepository = schedulesRepository;
    }

    @Override
    public void addSchedule(Object filmId, Object tanggalTayang, Object jamMulai, Object jamSelesai, Object hargaTiket) {
        Schedules schedules = new Schedules();
        schedules.setTanggalTayang(tanggalTayang.toString());
        schedules.setJamMulai(jamMulai.toString());
        schedules.setJamSelesai(jamSelesai.toString());
        schedules.setHargaTiket(Integer.parseInt(hargaTiket.toString()));
        Films films = filmsService.getFilmByFilmId(Integer.parseInt(filmId.toString()));
        if(films != null) {
            schedules.setFilmId(films);
        } else {
            filmsService.addFilm(films);
            schedules.setFilmId(filmsService.getFilmByFilmId(Integer.parseInt(filmId.toString())));
        }
        schedulesRepository.save(schedules);
    }

    @Override
    public List<Schedules> getSchedules(Integer schedulesId) {
        return schedulesRepository.findSchedulesByFilmId(schedulesId);
    }

    @Override
    public Schedules getSchedulesByScheduleId(Integer schedulesId) {
        return schedulesRepository.findSchedulesBySchedulesId(schedulesId);
    }
}