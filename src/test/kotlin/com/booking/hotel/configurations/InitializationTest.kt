package com.booking.hotel.configurations

import com.booking.hotel.repositories.IHotelRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.mockito.Mockito
import reactor.core.publisher.Flux


class InitializationTest {


    private val repo = Mockito.mock(IHotelRepository::class.java)

    @Test
    fun `Should save All initial hotels`() {

        val initialization = Initialization(this.repo)

        Mockito.`when`(repo.saveAll(initialization.initialHotels))
                .thenReturn(Flux.fromIterable(initialization.initialHotels))

        initialization.init().run()

        Mockito.verify(repo, Mockito.times(1)).saveAll(initialization.initialHotels)
    }

}
