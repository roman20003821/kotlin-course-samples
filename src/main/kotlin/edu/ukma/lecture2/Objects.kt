package edu.ukma.lecture2

interface DataProvider {
    fun getData(): String

    fun saveData(value: String)
}

object DataProviderManager {
    val allDataProviders: List<DataProvider>
        get() = mutableAllDataProviders
    private val mutableAllDataProviders = ArrayList<DataProvider>()

    init {
        println("Initializing DataProviderManager")
    }

    fun registerDataProvider(provider: DataProvider) {
        mutableAllDataProviders.add(provider)
    }
}

class Connection private constructor() {
    companion object {
        fun open(): Connection {
            return Connection()
        }
    }
}

fun main() {
    DataProviderManager.registerDataProvider(
        object : DataProvider {
            private var data: String = ""

            override fun getData(): String {
                return data
            }

            override fun saveData(value: String) {
                data = value
            }
        },
    )
}
