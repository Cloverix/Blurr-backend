package com.example.Blurr

import org.h2.tools.Server
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import jakarta.annotation.PreDestroy

@SpringBootApplication
class DemoApplication {

    private lateinit var h2Server: Server

    @Bean
    fun startH2Server(): Server {
        h2Server = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082")
        h2Server.start()
        return h2Server
    }

    @PreDestroy
    fun stopH2Server() {
        if (::h2Server.isInitialized) {
            h2Server.stop()
        }
    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}