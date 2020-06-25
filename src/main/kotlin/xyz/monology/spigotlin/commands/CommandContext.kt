package xyz.monology.spigotlin.commands

import org.bukkit.command.CommandSender
import xyz.monology.spigotlin.utils.colored

class CommandContext<T : Arguments, C : CommandSender>(val sender: C, val args: T) {
    fun respond(any: Any?) {
        sender.sendMessage(any.toString().colored)
    }
}