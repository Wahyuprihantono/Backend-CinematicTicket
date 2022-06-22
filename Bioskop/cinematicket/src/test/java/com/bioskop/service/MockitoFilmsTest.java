//package com.bioskop.service;
//
//import com.bioskop.enumeration.ERole;
//import com.bioskop.model.Films;
//import com.bioskop.model.Roles;
//import com.bioskop.model.Users;
//import com.bioskop.repository.FilmsRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@ExtendWith(MockitoExtension.class) // untuk menunjukkan test memiliki @Mock, maka di extend
//class MockitoFilmsTest {
//
//    // @Mock sama seperti @Autowired di springboot, namun jika di unit-test menggunakan @Mock
//    @Mock
//    private FilmsRepository filmsRepository;
//
//    private FilmsService filmsService;
//
//    @BeforeEach
//    void init() {
//        MockitoAnnotations.openMocks(this); // inisialisasi mockito agar bisa mock
//        this.filmsService = new FilmsServiceImpl(this.filmsRepository);
//    }
//
//    @Test
//    @DisplayName("Test Add Film")
//    void testAddFilm() {
//        Films films = new Films();
//        films.setFilmId(2);
//        films.setFilmCode("KKN");
//        films.setFilmName("Kuliah Kerja Nyata");
//        films.setIsShow(true);
//
//        assertThat(films.getFilmId()).isEqualTo(2);
//        assertThat(films.getFilmCode()).isEqualTo("KKN");
//        assertThat(films.getFilmName()).isEqualTo("Kuliah Kerja Nyata");
//        assertThat(films.getIsShow()).isEqualTo(true);
//
//        filmsService.addFilm(films);
//        Mockito.verify(filmsRepository).save(films);
//    }
//
//    @Test
//    @DisplayName("Test Delete Film")
//    void testDeleteFilm() {
//        Films films = new Films();
//        films.setFilmId(2);
//
//        filmsService.deleteFilm(films.getFilmId());
//        Mockito.verify(filmsRepository).deleteById(films.getFilmId());
//    }
//
//    @Test
//    @DisplayName("Test Get All Films with Stub")
//    void stubGetAllFilms() {
//        FilmsService filmsService1 = Mockito.spy(new FilmsServiceImpl(this.filmsRepository));
//        List<Films> films = new ArrayList<>();
//        Mockito.when(filmsService1.getAllFilms()).thenReturn(films);
//        System.out.println(filmsService1.getAllFilms());
//    }
//}
