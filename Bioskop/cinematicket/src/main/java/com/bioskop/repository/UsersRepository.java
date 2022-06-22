package com.bioskop.repository;

import com.bioskop.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    public Users findByUserId(Integer userId);
    public Users findByUsername(String username);
    public Users findByEmail(String email);
}
