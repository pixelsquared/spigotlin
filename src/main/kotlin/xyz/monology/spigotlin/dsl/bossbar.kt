package xyz.monology.spigotlin.dsl

import org.bukkit.Bukkit
import org.bukkit.boss.BarColor
import org.bukkit.boss.BarFlag
import org.bukkit.boss.BarStyle
import org.bukkit.boss.BossBar

class BossBarDSL(val title: String?) {
    var color = BarColor.WHITE
    var style = BarStyle.SEGMENTED_10
    val flags = mutableListOf<BarFlag>()

    fun BarFlag.unaryPlus() {
        flags.add(this)
    }

    fun toBossBar(): BossBar {
        return Bukkit.createBossBar(title, color, style, *flags.toTypedArray())
    }
}

fun bossBar(title: String? = null, block: BossBarDSL.() -> Unit): BossBar {
    return BossBarDSL(title).apply(block).toBossBar()
}