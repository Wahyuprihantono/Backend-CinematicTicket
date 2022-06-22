package com.bioskop.service;

import com.bioskop.model.Seats;
import org.springframework.stereotype.Service;

@Service
public interface SeatsService {

    Seats addSeat(Seats seats);

    Seats getSeat(String seatsCode);
}
