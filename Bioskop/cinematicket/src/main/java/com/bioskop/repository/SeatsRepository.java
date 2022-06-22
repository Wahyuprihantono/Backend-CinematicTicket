package com.bioskop.repository;

import com.bioskop.model.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SeatsRepository extends JpaRepository <Seats, Integer> {
    Seats findSeatsBySeatsCode(String seatsCode);
}
