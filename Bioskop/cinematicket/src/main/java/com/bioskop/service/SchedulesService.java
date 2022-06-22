package com.bioskop.service;

import com.bioskop.model.Schedules;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface SchedulesService {

    void addSchedule(Object filmId, Object tanggalTayang, Object jamMulai, Object jamSelesai, Object hargaTiket);

    List<Schedules> getSchedules(Integer schedulesId);

    Schedules getSchedulesByScheduleId(Integer schedulesId);
}
