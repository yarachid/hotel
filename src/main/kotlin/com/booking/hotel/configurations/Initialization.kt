package com.booking.hotel.configurations

import com.booking.hotel.model.Hotel
import com.booking.hotel.repositories.IHotelRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalTime

@Configuration
class Initialization(val hotelRepo: IHotelRepository) {

    val initialHotels = listOf(
            Hotel( null,"Hilton", LocalTime.of(7,30)),
            Hotel( null,"Trump", LocalTime.of(10,3)),
            Hotel( null,"Marriott", LocalTime.of(12,30)),
            Hotel( null,"Express Hotel", LocalTime.of(15,0))
    )

    @Bean
    fun init(): CommandLineRunner = CommandLineRunner {
        this.hotelRepo.saveAll(this.initialHotels).subscribe()
    }


}