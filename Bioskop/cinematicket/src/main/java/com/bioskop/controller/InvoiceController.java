package com.bioskop.controller;

import com.bioskop.model.*;
import com.bioskop.service.FilmsService;
import com.bioskop.service.SchedulesService;
import com.bioskop.service.SeatsService;
import com.bioskop.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name="Invoice", description = "API to generate ticket reservation file containing user name, schedule, seat, and studio in PDF format.")
@RestController
@RequestMapping("/invoice")
@Controller
public class InvoiceController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private FilmsService filmsService;

    @Autowired
    private SchedulesService schedulesService;

    @Autowired
    private SeatsService seatsService;

    // Custom response to read invoice
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully read invoice!",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(example = "http://localhost:8080/invoice/get-tiket"))
                    }),
            @ApiResponse(responseCode = "400", description = "Failed to read invoice.",
                    content = { @Content})})
    @Operation(summary = "this API method function to generate files into PDF form, this method can only read those already stored in the Bioskop database.")

    // Get invoice
    @GetMapping("/customer/get-tiket")
    public void getTiketBioskop(HttpServletResponse response) throws IOException, JRException {
        JasperReport sourceFileName = JasperCompileManager
                .compileReport(ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX
                + "tiketbioskop.jrxml").getAbsolutePath());

        List<Map<String, String>> dataList = new ArrayList<>();
        Map<String, String> data = new HashMap<>();
        Users users = usersService.getUserByUsername("Vina");
        data.put("username", users.getUsername());
        data.put("email", users.getEmail());

        Films films = filmsService.getFilmByFilmId(1);
        data.put("filmName", films.getFilmName());

        Schedules schedules = schedulesService.getSchedulesByScheduleId(1);
        data.put("tanggalTayang", schedules.getTanggalTayang());
        data.put("jamMulai", schedules.getJamMulai());
        data.put("hargaTiket", schedules.getHargaTiket().toString());

        Seats seats = seatsService.getSeat("1");
        data.put("studioName", seats.getStudioName().toString());
        data.put("seatsCode", seats.getSeatsCode());
        dataList.add(data);

        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(dataList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("Author", "Ivan Aditya Maulana");
        JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName, parameters, beanCollectionDataSource);

        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename=tiketbioskop.pdf");

        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }
}
