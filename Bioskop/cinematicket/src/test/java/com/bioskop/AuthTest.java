//package com.bioskop;
//
//import com.bioskop.controller.AuthController;
//import com.bioskop.enumeration.ERole;
//import com.bioskop.config.JwtUtils;
//import com.bioskop.model.Roles;
//import com.bioskop.model.SignupRequest;
//import com.bioskop.repository.RoleRepository;
//import com.bioskop.repository.UsersRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.Spy;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
//@ExtendWith(MockitoExtension.class)
//class AuthTest {
//    private AuthController authController;
//
//    @Mock
//    private UsersRepository usersRepository;
//
//    @Mock
//    private RoleRepository roleRepository;
//
//    @Mock
//    private PasswordEncoder passwordEncoder;
//
//    @Mock
//    private JwtUtils jwtUtils;
//
//    @Mock
//    Authentication authentication;
//
//    @Spy
//    private AuthenticationManager authenticationManager;
//
//    @BeforeEach
//    void init() {
//        MockitoAnnotations.openMocks(this);
//        authController = new AuthController(this.authenticationManager, this.usersRepository, this.jwtUtils,
//                this.roleRepository, this.passwordEncoder);
//    }
//    @Test
//    void testSignup() {
//        Set<String> roles = new HashSet<>();
//        roles.add("ADMIN");
//        SignupRequest signupRequest = new SignupRequest();
//        signupRequest.setUsername("admin");
//        signupRequest.setPassword("admin");
//        signupRequest.setEmail("admin@gmail.com");
//        signupRequest.setRole(roles);
//        Mockito.when(usersRepository.existsByUsername("admin")).thenReturn(Boolean.FALSE);
//        Mockito.when(usersRepository.existsByEmail("admin@gmail.com")).thenReturn(Boolean.FALSE);
//        Mockito.when(roleRepository.findByName(ERole.ADMIN))
//                .thenReturn(Optional.of(new Roles(2, ERole.ADMIN)));
//        Assertions.assertEquals("User registered successfully",
//                authController.registerUser(signupRequest).getBody().getMessage());
//    }
//}