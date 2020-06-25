package xyz.monology.spigotlin.gui

import org.bukkit.Bukkit
import org.bukkit.inventory.ItemStack

data class GUI(val title: String, val rows: Byte) {
    val spigot = Bukkit.createInventory(null, rows * 9, title)
    internal val onClick = mutableMapOf<Int, OnClickEvent.() -> Unit>()

    val items: Array<ItemStack> get() = spigot.contents
    val size = rows * 9

    init {
        directory.add(this)
    }

    companion object {
        internal val directory = mutableListOf<GUI>()
    }
}