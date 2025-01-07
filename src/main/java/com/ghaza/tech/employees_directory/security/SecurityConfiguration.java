package com.ghaza.tech.employees_directory.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        var omar = User.builder()
                .username("omar")
                .password("{noop}password")
                .roles("USER", "MANAGER", "ADMIN")
                .build();

        var mariam = User.builder()
                .username("mariam")
                .password("{noop}password")
                .roles("USER", "MANAGER")
                .build();

        var yosuf = User.builder()
                .username("yosuf")
                .password("{noop}password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(omar, mariam, yosuf);
    }
}
