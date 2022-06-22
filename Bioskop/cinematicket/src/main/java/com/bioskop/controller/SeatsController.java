package com.bioskop.controller;

import com.bioskop.model.Seats;
import com.bioskop.service.SeatsService;
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

@Tag(name="Seats", description = "API for seat using the Seats entity in the Bioskop database.")
@RestController
@RequestMapping("/seats")
@Controller
public class SeatsController {

    @Autowired
    private SeatsService seatsService;

    // Custom response to add seat
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully added a new seat!",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(example = "{" +
                                    "\"studioName\":\"A\","+
                                    "\"seatsCode\":\"2\"}"))
                    }),
            @ApiResponse(responseCode = "400", description = "Failed to add new seat.",
                    content = { @Content})})
    @Operation(summary = "This API method function to add a seat by inputting a studio name, seat code and will be stored in the Seats entity.")

    // Add Seat
    @PostMapping("/admin/add-seat")
    public ResponseEntity<RestTemplate> addSeat(@Schema(example = "{" +
            "\"studioName\":\"A\","+
            "\"seatsCode\":\"2\"}") @RequestBody Seats seats) {
        seatsService.addSeat(seats);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
