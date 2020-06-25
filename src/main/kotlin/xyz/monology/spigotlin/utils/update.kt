package xyz.monology.spigotlin.utils

import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin
import xyz.monology.spigotlin.BukkitScope
import java.io.IOException
import java.net.URL
import java.util.Scanner

fun checkForUpdates(plugin: Plugin, id: Int, message: String, permission: String? = null) {
    checkForUpdates(plugin, id) {
        if (it) {
            onlinePlayers.filter { player ->
                if (permission != null) player.isOp || player.hasPermission(permission) else player.isOp
            }.forEach { player ->
                player.sendMessage(message)
            }
        }
    }
}

inline fun checkForUpdates(plugin: Plugin, id: Int, crossinline predicate: (Boolean) -> Unit) {
    BukkitScope.launch(plugin, async = true) {
        try {
            URL("https://api.spigotmc.org/legacy/update.php?resource=$id").openStream()
                .use {
                    Scanner(it).use { scanner ->
                        predicate(scanner.hasNext())
                    }
                }
        } catch (exception: IOException) {
            Bukkit.getServer().logger.warning("There was an error retrieving the update-status of a plugin: ${plugin.name}")
        }
    }
}