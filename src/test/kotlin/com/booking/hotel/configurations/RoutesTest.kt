package com.booking.hotel.configurations

import com.booking.hotel.handlers.IHotelHandler
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito.mock

class RoutesTest {

    private val repo = mock(IHotelHandler::class.java)

    @Test
    fun `Should construct the router`() {
        val builtRouter = Routes().router(this.repo)
        assertNotNull(builtRouter)
    }


}
