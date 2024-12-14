package com.demo.jewelry_store;

import com.demo.jewelry_store.controllers.UserController;
import com.demo.jewelry_store.controllers.impl.user.DefaultUserController;
import com.demo.jewelry_store.repositories.PostgreSQLJDBC;
import com.demo.jewelry_store.repositories.UserRepository;
import com.demo.jewelry_store.repositories.impl.DefaultUserRepository;
import com.demo.jewelry_store.services.UserService;
import com.demo.jewelry_store.services.impl.user.DefaultUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    PostgreSQLJDBC postgreSQLJDBC() {
        return new PostgreSQLJDBC();
    }

    @Bean
    UserRepository userRepository() {
        return new DefaultUserRepository(postgreSQLJDBC());
    }

    @Bean
    UserService userService() {
        return new DefaultUserService(userRepository());
    }
}
