//package com.bioskop.service;
//
//import com.bioskop.enumeration.ERole;
//import com.bioskop.model.Roles;
//import com.bioskop.model.Users;
//import com.bioskop.repository.UsersRepository;
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
//class MockitoUsersTest {
//
//    // @Mock sama seperti @Autowired di springboot, namun jika di unit-test menggunakan @Mock
//    @Mock
//    private UsersRepository usersRepository;
//
//    private UsersService usersService;
//
//    @BeforeEach
//    void init() {
//        MockitoAnnotations.openMocks(this); // inisialisasi mockito agar bisa mock
//        this.usersService = new UsersServiceImpl(this.usersRepository);
//    }
//
//    @Test
//    void testGetAllUsers() {
//        usersService.getAllUsers(); // getAllUsers akan dibandingkan dengan mockito verify
//        Mockito.verify(usersRepository).findAll(); // verify untuk memastikan method terpanggil atau tidak
//    }
//
//    @Test
//    void testGetUser() {
//        Users users = new Users();
//        users.setUsername("Ivan");
//        assertThat(users.getUsername()).isEqualTo("Ivan");
//    }
//
//    @Test
//    @DisplayName("Test Add User")
//    void testAddUser() {
//       Users users = new Users();
//       users.setUserId(3);
//       users.setUsername("Ivan");
//       users.setEmail("vantelkom@email.com");
//       users.setPassword("passIvan");
//       Set<Roles> roles = new HashSet<>();
//       roles.add(new Roles(1, ERole.CUSTOMER));
//       users.setRoles(roles);
//
//        assertThat(users.getUsername()).isEqualTo("Ivan");
//        assertThat(users.getEmail()).isEqualTo("vantelkom@email.com");
//        assertThat(users.getPassword()).isEqualTo("passIvan");
//        assertThat(users.getRoles()).isEqualTo(users.getRoles());
//
//        usersService.addUser(users);
//        Mockito.verify(usersRepository).save(users);
//    }
//
//    @Test
//    @DisplayName("Test Delete User")
//    void testDeleteUser() {
//        Integer userId = 1;
//
//        usersService.deleteUser(userId);
//        Mockito.verify(usersRepository).deleteById(userId);
//    }
//
//    @Test
//    @DisplayName("Test Update User")
//    void testUpdateUsers() {
//    }
//
//    @Test
//    void testMock() {
//        Users expected = new Users();
//        expected.setUsername("admin");
//        Users users = usersRepository.findByUsername("admin");
//    }
//
//    @Test
//    @DisplayName("Test Get All Users with Stub")
//    void stubGetAllUsers() {
//        UsersService usersService1 = Mockito.spy(new UsersServiceImpl(this.usersRepository));
//        List<Users> users = new ArrayList<>();
//        Mockito.when(usersService1.getAllUsers()).thenReturn(users);
//        System.out.println(usersService1.getAllUsers());
//    }
//}
