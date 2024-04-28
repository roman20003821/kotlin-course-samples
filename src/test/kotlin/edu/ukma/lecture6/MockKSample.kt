package edu.ukma.lecture6

import edu.ukma.lecture6.domain.*
import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.test.assertEquals

@ExtendWith(MockKExtension::class)
class MockKSample {
    @Test
    fun `mock sample`(@MockK car: Car) {
        every { car.drive(Direction.NORTH) } returns Outcome.OK

        car.drive(Direction.NORTH) // returns OK

        verify { car.drive(Direction.NORTH) }
    }

    @Test
    fun `should fill order`() {
        val snickers = "snickers"
        val order = Order(snickers, 10)
        val warehouse = spyk<Warehouse>().apply {
            add(snickers, 10)
        }
        order.fill(warehouse)
        verifyOrder {
            warehouse.hasInventory(snickers, 10)
            warehouse.remove(snickers, 10)
        }
    }

    @Test
    fun `object mock sample`() {
        mockkObject(ProductsLibrary)
        every { ProductsLibrary.getProducts() } returns listOf("orange", "lemon")
        assertEquals(listOf("orange", "lemon"), ProductsLibrary.getProducts())
    }
}
