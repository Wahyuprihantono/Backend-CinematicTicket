package com.bioskop.service;

import com.bioskop.model.Users;
import com.bioskop.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Users getUserByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public Users getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public Optional<Users> getUserById(Integer userId) {
        return usersRepository.findById(userId);
    }


    @Override
    public Users addUser(Users users) {
        users.getUsername();
        users.getEmail();
        users.getPassword();
        return usersRepository.save(users);
    }

    @Override
    public Users updateUserById(Users users) {
        users.getUsername();
        Users updateUser = usersRepository.findById(users.getUserId()).get();
        updateUser.setUsername(users.getUsername());
        updateUser.setEmail(users.getEmail());
        updateUser.setPassword(users.getPassword());
        return usersRepository.save(updateUser);
    }

    @Override
    public String deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
        return "Delete user id " + userId + " has been successful!";
    }

    @Cacheable(value = "getAllUsers")
    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
}