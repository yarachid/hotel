package com.booking.hotel.repositories

import com.booking.hotel.model.Hotel
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import java.time.LocalTime

interface IHotelRepository : ReactiveMongoRepository<Hotel,String> {
    fun findByCheckInBetween(start: LocalTime, end: LocalTime): Flux<Hotel>
}