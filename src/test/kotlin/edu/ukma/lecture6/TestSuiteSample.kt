package edu.ukma.lecture6

import edu.ukma.lecture6.domain.Warehouse
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class TestSuiteSample {
    private lateinit var warehouse: Warehouse

    @BeforeEach
    fun setUp() {
        warehouse = Warehouse()
    }

    @AfterEach
    fun cleanUp() {
        // Очищення сховища, стану...
    }

    @Test
    fun `should have steal inventory`() {
        val steal = "steal"
        warehouse.add(steal, 10)
        assert(warehouse.hasInventory(steal, 10))
    }

    companion object {
        @JvmStatic
        @BeforeAll
        fun setUpDatabase() {
            // Налаштування бази даних, докер контейнера...
        }

        @JvmStatic
        @AfterAll
        fun shutDownDatabase() {
        }
    }
}
