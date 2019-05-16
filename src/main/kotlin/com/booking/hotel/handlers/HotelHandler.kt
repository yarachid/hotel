package com.booking.hotel.handlers

import com.booking.hotel.model.Hotel
import com.booking.hotel.model.ResponseMessage
import com.booking.hotel.repositories.IHotelRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.badRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono
import java.lang.Exception
import java.time.LocalTime

@Component
class HotelHandler(private val repo: IHotelRepository) : IHotelHandler {

    override fun search(req: ServerRequest): Mono<ServerResponse> {

        val param: String = req.queryParams()["time"]?.get(0) ?:
        return badRequest().body(
                Mono.just(ResponseMessage("No time have been provided")),
                ResponseMessage::class.java
        )

        return try {

            val time = LocalTime.parse(param)
            val start = time.minusHours(5) ?: LocalTime.MIN
            val end = time.plusHours(5) ?: LocalTime.MAX
            val hotels = this.repo.findByCheckInBetween(start, end)
            ok().body(hotels, Hotel::class.java)

        } catch(e: Exception) {
            badRequest().body(
                    Mono.just(ResponseMessage("ISO time is required (EX: 17:15:00)")),
                    ResponseMessage::class.java
            )
        }
    }



}