package com.bioskop.controller;

import com.bioskop.model.Films;
import com.bioskop.service.FilmsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name="Films", description = "API for film using the Films entity in the Bioskop database.")
@RestController
@RequestMapping("/films")
@Controller
public class FilmsController {

    @Autowired
    private FilmsService filmsService;

    // Get Film by film name
    @Operation(summary = "This API method function to read existing film information by inputting the film name.")
    @GetMapping(value = "/public/get-film/{filmName}")
    public ResponseEntity<RestTemplate> getFilmByFilmName(@Schema(example = "Fill in film name") @PathVariable String filmName) {
        Films films = filmsService.getFilmByFilmName(filmName);

        Map<String, Object> respBody = new HashMap<>();
        respBody.put("Film ID", films.getFilmId());
        respBody.put("Film Code", films.getFilmCode());
        respBody.put("Film Name", films.getFilmName());
        respBody.put("On Show", films.getIsShow());
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    // Custom response to add film
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully added a new film!",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(example = "{" +
                                    "\"filmId\":\"1\","+
                                    "\"filmCode\":\"AVG\","+
                                    "\"filmName\":\"Avengers\"," +
                                    "\"isShow\":\"true\"}"))
            }),
            @ApiResponse(responseCode = "400", description = "Failed to add new film.",
                    content = { @Content})})
    @Operation(summary = "This API method function to add a film by inputting a film code, film name, on show and will be stored in the Films entity.")

    // Add Film
    @PostMapping("/admin/add-film")
    public ResponseEntity<RestTemplate> addFilm(@Schema(example = "{" + "\"filmId\":\"1\","+
            "\"filmCode\":\"AVG\","+
            "\"filmName\":\"Avengers\"," +
            "\"isShow\":\"true\"}") @RequestBody Films films) {
        filmsService.addFilm(films);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Update Film
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully update film!",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(example = "{" + "\"filmId\":\"1\","+
                                    "\"filmCode\":\"AVG\","+
                                    "\"filmName\":\"Avengers\"," +
                                    "\"isShow\":\"true\"}"))
                    }),
            @ApiResponse(responseCode = "400", description = "Failed to update film.",
                    content = { @Content})})
    @Operation(summary = "This API method function to update the film that has been inputted by re-entering the film code, film name, and on show that you want to update.")
    @PutMapping("/admin/update-film")
    public ResponseEntity<RestTemplate> updateFilm(@Schema(example = "{" +
            "\"filmId\":\"1\","+
            "\"filmCode\":\"AVG\","+
            "\"filmName\":\"Avengers\"," +
            "\"isShow\":\"true\"}") @RequestBody Films films) {
        filmsService.updateFilm(films);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    // Delete Film
    @Operation(summary = "This API method function to delete the film you want by inputting the film id.")
    @DeleteMapping("/admin/delete-film/{filmId}")
    public ResponseEntity<RestTemplate> deleteFilm(@Schema(example = "Fill in film id") @PathVariable Integer filmId) {
        filmsService.deleteFilm(filmId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    // Get Film tayang
    @Operation(summary = "This API method function to read existing film on show information.")
    @GetMapping("/public/get-film-tayang")
    public ResponseEntity<RestTemplate> getFilmTayang() {
        List<Films> listFilms = filmsService.getFilmTayang();
        return new ResponseEntity<>(HttpStatus.FOUND);
    }
}