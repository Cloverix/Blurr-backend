package com.example.Blurr.config

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.core.annotation.Order

@Configuration
@EnableWebSecurity
class WebSecurityConfig {

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    @Order(0)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        println(">>> SecurityFilterChain is being applied!") // проверка
        http
            .csrf { it.disable() }
            .authorizeHttpRequests { auth ->
                auth.anyRequest().permitAll() // все запросы разрешены
            }
            .formLogin { it.disable() }
            .httpBasic { it.disable() }
            .headers { it.frameOptions { frame -> frame.disable() } }
        return http.build()
    }
}