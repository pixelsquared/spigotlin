package xyz.monology.spigotlin.config

import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.Plugin
import java.io.File

class Config(val file: File, val plugin: Plugin?) {
    val config = if (file.exists()) YamlConfiguration.loadConfiguration(file) else plugin?.getResource(file.name)?.reader().run {
        if (this != null) YamlConfiguration.loadConfiguration(this) else null
    } ?: YamlConfiguration()

    operator fun set(name: String, any: Any) {
        when (any) {
            is List<*>, is Map<*, *>, is String, is Byte, is Short, is Int, is Long, is Float, is Double, is Char, is Boolean -> {}
            else -> throw IllegalArgumentException("Invalid argument type: " + any::class.simpleName)
        }
        config[name] = any
    }

    operator fun <T : Any> get(name: String): T? {
        return config[name] as T?
    }

    fun save() {
        config.save(file)
    }
}