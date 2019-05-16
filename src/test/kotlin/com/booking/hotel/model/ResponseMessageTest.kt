package com.booking.hotel.model


import org.junit.Test
import org.junit.Assert.*


class ResponseMessageTest {

    @Test
    fun `Should Construct Message Pojo`() {
        val msg = "This is a message"
        val msgPojo = ResponseMessage(msg)
        assertEquals(msgPojo.message, msg)
    }

}
