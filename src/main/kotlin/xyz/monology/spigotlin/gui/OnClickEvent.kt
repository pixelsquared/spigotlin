package xyz.monology.spigotlin.gui

import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType

class OnClickEvent(
    val clickType: ClickType,
    val player: Player
)