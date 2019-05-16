package com.booking.hotel.model

import org.springframework.data.annotation.Id
import java.time.LocalTime

data class Hotel (
        @Id val id: String? = null,
        val name: String,
        val checkIn: LocalTime
)