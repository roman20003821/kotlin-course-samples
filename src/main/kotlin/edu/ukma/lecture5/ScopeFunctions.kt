package edu.ukma.lecture5

import java.io.InputStream
import kotlin.random.Random

// #region apply
class ServerConfiguration {
    var port: Int = 0
    var sslEnabled: Boolean = false
    var safetyModeEnabled: Boolean = false
}

fun getServerConfigurationOldWay(): ServerConfiguration {
    val serverConfiguration = ServerConfiguration()
    serverConfiguration.port = 8080
    serverConfiguration.sslEnabled = true
    serverConfiguration.safetyModeEnabled = true
    return serverConfiguration
}

fun getServerConfiguration(): ServerConfiguration {
    return ServerConfiguration().apply {
        port = 8080
        sslEnabled = true
        safetyModeEnabled = true
    }
}

//endregion

// #region also

fun getRandomInt(): Int {
    return Random.nextInt(100).also { value ->
        println("getRandomInt() generated value $value")
    }
}

//endregion

fun letSample() {
}

private fun getSoftwareVersion(): String {
    return getResourceAsStreamOrNull("BuildConfig.properties")?.let { stream ->
        ResourceProperties(stream)["version"]?.toString()
    } ?: "Unknown"
}

class ResourceProperties(stream: InputStream) {
    operator fun get(value: String): Any? {
        return ""
    }
}

private fun getResourceAsStreamOrNull(resourceName: String): InputStream? = null
