package xyz.monology.spigotlin.utils

import org.bukkit.entity.Player
import xyz.monology.spigotlin.commands.CommandContext

val CommandContext<*, Player>.player get() = sender