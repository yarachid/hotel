package com.booking.hotel.configurations

import com.booking.hotel.handlers.IHotelHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class Routes {

    @Bean
    fun router(hotelHandler: IHotelHandler) = router {
        accept(MediaType.APPLICATION_JSON).nest {
            GET("/hotels", hotelHandler::search)
        }
    }
}