package com.rvr.dbperf


import com.rvr.dbperf.user.UserHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.coRouter

@Configuration
@EnableR2dbcRepositories
class AppConfiguration {
    @Bean
    fun userRoute(userHandler: UserHandler) = coRouter {
        accept(APPLICATION_JSON).nest {
            GET("/users", userHandler::findAll)
            GET("/users/search", userHandler::search)
            GET("/users/{id}", userHandler::findUser)
            POST("/users", userHandler::addUser)
            PUT("/users/{id}", userHandler::updateUser)
            DELETE("/users/{id}", userHandler::deleteUser)
        }
    }
}