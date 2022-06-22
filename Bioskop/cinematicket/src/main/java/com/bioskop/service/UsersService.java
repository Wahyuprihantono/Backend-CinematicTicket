package com.bioskop.service;

import com.bioskop.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface UsersService {

    Users getUserByUsername(String username);

    Users getUserByEmail(String email);

    Optional<Users> getUserById(Integer userId);

    Users addUser(Users users);

    Users updateUserById(Users users);

    String deleteUser(Integer userId);

    List<Users> getAllUsers();
}