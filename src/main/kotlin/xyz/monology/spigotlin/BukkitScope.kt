package xyz.monology.spigotlin

import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin
import org.bukkit.scheduler.BukkitTask
import java.util.function.Consumer

object BukkitScope {
    inline fun launch(plugin: Plugin, delay: Long = 0, async: Boolean = false, crossinline block: BukkitTask.() -> Unit) {
        val func: (Plugin, Consumer<BukkitTask>, Long) -> Unit = if (async) Bukkit.getScheduler()::runTaskLaterAsynchronously else Bukkit.getScheduler()::runTaskLater
        func.invoke(plugin, Consumer { block(it) }, delay)
    }

    inline fun launchTimer(plugin: Plugin, period: Long, delay: Long = 0, async: Boolean = false, crossinline block: BukkitTask.() -> Unit) {
        val func: (Plugin, Consumer<BukkitTask>, Long, Long) -> Unit = if (async) Bukkit.getScheduler()::runTaskTimerAsynchronously else Bukkit.getScheduler()::runTaskTimer
        func(plugin, Consumer { block(it) }, delay, period)
    }
}