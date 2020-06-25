package xyz.monology.spigotlin.utils

import org.bukkit.ChatColor

operator fun ChatColor.plus(other: String) = this.toString() + other

operator fun ChatColor.plus(other: ChatColor) = this.toString() + other.toString()

inline val String.colored get() = ChatColor.translateAlternateColorCodes('&', this)