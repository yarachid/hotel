package com.booking.hotel.model


import org.junit.Test
import org.junit.Assert.*
import java.time.LocalTime


class HotelTest {

    @Test
    fun `Should Construct the object`() {
        val name = "My Hotel"
        val time = LocalTime.of(17,35)
        val hotel = Hotel(name = name, checkIn = time)
        assertEquals(hotel.name, name)
        assertEquals(hotel.checkIn, time)
    }

}
