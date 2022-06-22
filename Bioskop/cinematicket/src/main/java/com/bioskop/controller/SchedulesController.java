package com.bioskop.controller;

import com.bioskop.service.SchedulesService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Tag(name="Schedules", description = "API for schedule using the Schedules entity in the Bioskop database.")
@RestController
@RequestMapping("/schedules")
@Controller
public class SchedulesController {

    @Autowired
    private SchedulesService schedulesService;

    // Custom response to add schedule
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully added a new schedule!",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(example = "{" +
                                    "\"filmId\":\"1\","+
                                    "\"tanggalTayang\":\"2022-03-18\","+
                                    "\"jamMulai\":\"15:00:00\"," +
                                    "\"jamSelesai\":\"17:50:00\"," +
                                    "\"hargaTiket\":\"25000\"}"))
                    }),
            @ApiResponse(responseCode = "400", description = "Failed to add new schedule.",
                    content = { @Content})})
    @Operation(summary = "This API method function to add a schedule by inputting a film id in the Films entity, show date, start time, end time, ticket price and will be stored in the Schedules entity.")

    // Add Schedule
    @PostMapping("/admin/add-schedule")
    public ResponseEntity<RestTemplate> addSchedule(@Schema(example = "{" +
            "\"filmId\":\"1\","+
            "\"tanggalTayang\":\"2022-03-18\","+
            "\"jamMulai\":\"15:00:00\"," +
            "\"jamSelesai\":\"17:50:00\"," +
            "\"hargaTiket\":\"25000\"}") @RequestBody Map<String, Object> schedules) {
        schedulesService.addSchedule(
                schedules.get("filmId").toString(),
                schedules.get("tanggalTayang").toString(),
                schedules.get("jamMulai").toString(),
                schedules.get("jamSelesai").toString(),
                schedules.get("hargaTiket").toString());

                Map<String, Object> respBody = new HashMap<>();
                respBody.put("Tanggal Tayang", schedules.get("tanggalTayang"));
                respBody.put("Jam Mulai", schedules.get("jamMulai"));
                respBody.put("Jam Selesai", schedules.get("jamSelesai"));
                respBody.put("Harga Tiket", schedules.get("hargaTiket"));
                return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
