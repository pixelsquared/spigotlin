package xyz.monology.spigotlin.dsl

import org.bukkit.plugin.Plugin
import xyz.monology.spigotlin.config.Config
import java.io.File

class ConfigDSL(plugin: Plugin?, file: File) {
    val config = Config(file, plugin)

    inner class ConfigListDSL {
        internal val list = mutableListOf<Any>()

        operator fun Any.unaryPlus() {
            list.add(this)
        }

        operator fun get(index: Int): Any? {
            return list[index]
        }
    }

    fun list(block: ConfigListDSL.() -> Unit): Any {
        return ConfigListDSL().apply(block).list
    }

    inner class ConfigMapDSL {
        internal val map = mutableMapOf<String, Any>()

        operator fun set(key: String, value: Any) {
            map[key] = value
        }

        operator fun get(key: String): Any? {
            return map[key]
        }
    }

    operator fun set(key: String, value: Any) {
        config[key] = value
    }

    fun map(block: ConfigMapDSL.() -> Unit): Any {
        return ConfigMapDSL().apply(block).map
    }
}

inline fun config(file: File, plugin: Plugin? = null, block: ConfigDSL.() -> Unit): Config {
    return ConfigDSL(plugin, file).apply(block).config
}

inline fun config(plugin: Plugin, name: String, block: ConfigDSL.() -> Unit): Config {
    return ConfigDSL(plugin, File(plugin.dataFolder, "$name.yml")).apply(block).config
}