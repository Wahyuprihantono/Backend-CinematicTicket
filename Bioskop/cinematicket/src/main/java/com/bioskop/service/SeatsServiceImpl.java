package com.bioskop.service;

import com.bioskop.model.Seats;
import com.bioskop.repository.SeatsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SeatsServiceImpl implements SeatsService {

    @Autowired
    SeatsRepository seatsRepository;

    @Override
    public Seats addSeat(Seats seats) {
        seats.getStudioName();
        seats.getSeatsCode();
        return seatsRepository.save(seats);
    }

    @Override
    public Seats getSeat(String seatsCode) {
        return seatsRepository.findSeatsBySeatsCode(seatsCode);
    }
}
