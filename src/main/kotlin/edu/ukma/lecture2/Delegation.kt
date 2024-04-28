package edu.ukma.lecture2

import kotlin.properties.Delegates

interface View {
    fun draw()

    fun invalidate()
}

class ViewWrapper(private val child: View) : View by child {
    override fun invalidate() {
        println("Invalidating")
        child.invalidate()
    }
}

class UserStorage {
    val users by lazy {
        fetchFromDatabase()
    }

    private fun fetchFromDatabase(): List<String> {
        return emptyList()
    }
}

class Phone {
    var name: String by Delegates.observable(initialValue = "<no name>") { prop, old, new ->
        println("$old -> $new")
    }
}
