package com.bioskop.controller;

import com.bioskop.model.Users;
import com.bioskop.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Tag(name="Users", description = "API for users using the Users entity in the Bioskop database.")
@RestController
@RequestMapping("/users")
@Controller
public class UsersController {

    private static final Logger LOG = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UsersService usersService;

    // Get User by username, customer access
    @Operation(summary = "This API method function to read existing user information by inputting the username.")
    @GetMapping("/customer/get-username/{username}")
    public ResponseEntity<RestTemplate> getUserByUsername(@Schema(example = "Fill in name") @PathVariable String username) {
        Users users = usersService.getUserByUsername(username);

        LOG.info("Get username : {}", users.getUsername());

        Map<String, Object> respBody = new HashMap<>();
        respBody.put("ID User", users.getUserId());
        respBody.put("Nama Lengkap", users.getUsername());
        respBody.put("Email", users.getEmail());
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    // Get User by email, coba public access
    @Operation(summary = "This API method function to read existing user information by inputting the email.")
    @GetMapping("/public/get-email/{email}")
    public ResponseEntity<RestTemplate> getUserByEmail(@Schema(example = "Fill in email")@PathVariable String email) {
        Users users = usersService.getUserByEmail(email);

        Map<String, Object> respBody = new HashMap<>();
        respBody.put("ID User", users.getUserId());
        respBody.put("Nama Lengkap", users.getUsername());
        respBody.put("Email", users.getEmail());
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    // Custom response to update user
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully update user!",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(example = "{" +
                                    "\"userId\":\"1\","+
                                    "\"username\":\"Ivan\","+
                                    "\"password\":\"passIvan\"," +
                                    "\"email\":\"ivan@email.com\"}"))
                    }),
            @ApiResponse(responseCode = "400", description = "Failed to update user.",
                    content = { @Content})})
    @Operation(summary = "This API method function to update the user that has been inputted by re-entering the userId, username, password, and email that you want to update.")

    // Update User, customer access
    @PutMapping("/customer/update-user")
    public ResponseEntity<RestTemplate> updateUser(@Schema(example = "{" +
            "\"userId\":\"1\","+
            "\"username\":\"Ivan\","+
            "\"password\":\"passIvan\"," +
            "\"email\":\"ivan@email.com\"}") @RequestBody Users users) {
        usersService.updateUserById(users);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    // Delete User, customer access
    @Operation(summary = "This API method function to delete the user you want by inputting the user id.")
    @DeleteMapping("/customer/delete-user/{userId}")
    public ResponseEntity<RestTemplate> deleteUser(@Schema(example = "Fill in user id") @PathVariable Integer userId) {
        usersService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}

/** Custom response to add user
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully added a new user!",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(example = "{" +
                                    "\"userId\":\"1\","+
                                    "\"username\":\"Ivan\","+
                                    "\"password\":\"passIvan\"," +
                                    "\"email\":\"ivan@email.com\"}"))
                    }),
            @ApiResponse(responseCode = "400", description = "Failed to add new user.",
                    content = { @Content})})
    @Operation(summary = "This API method function to add a user by inputting a username, email, password and will be stored in the Users entity.")

    // Add User, public access
    @PostMapping("/public/add-user")
    public ResponseEntity addUser(@Schema(example = "{" +
            "\"userId\":\"1\","+
            "\"username\":\"Ivan\","+
            "\"password\":\"passIvan\"," +
            "\"email\":\"ivan@email.com\"}")@RequestBody Users users) {
        usersService.addUser(users);
        return new ResponseEntity(users, HttpStatus.CREATED);
    } */