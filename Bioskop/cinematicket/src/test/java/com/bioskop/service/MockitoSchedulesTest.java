//package com.bioskop.service;
//
//import com.bioskop.enumeration.ERole;
//import com.bioskop.model.Films;
//import com.bioskop.model.Roles;
//import com.bioskop.model.Schedules;
//import com.bioskop.model.Users;
//import com.bioskop.repository.SchedulesRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@ExtendWith(MockitoExtension.class) // untuk menunjukkan test memiliki @Mock, maka di extend
//public class MockitoSchedulesTest {
//
//    // @Mock sama seperti @Autowired di springboot, namun jika di unit-test menggunakan @Mock
//    @Mock
//    private SchedulesRepository schedulesRepository;
//
//    private SchedulesService schedulesService;
//
//    @BeforeEach
//    void init() {
//        MockitoAnnotations.openMocks(this); // inisialisasi mockito agar bisa mock
//        this.schedulesService = new SchedulesServiceImpl(this.schedulesRepository);
//    }
//
//    @Test
//    @DisplayName("Test Add Schedules")
//    void testAddSchedules() {
//        Schedules schedules = new Schedules();
//        schedules.setSchedulesId(2);
//        schedules.setTanggalTayang("2022-05-27");
//        schedules.setJamMulai("20:00:00");
//        schedules.setJamSelesai("22:50:00");
//        schedules.setHargaTiket(3500);
//        Films films = new Films();
//        films.setFilmId(1);
//
////        schedulesService.addSchedule("2");
////        Mockito.verify(schedulesRepository).save(schedules);
//    }
//}
