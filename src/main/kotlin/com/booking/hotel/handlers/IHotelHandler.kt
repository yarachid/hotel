package com.booking.hotel.handlers

import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

interface IHotelHandler {
    fun search(req: ServerRequest): Mono<ServerResponse>
}