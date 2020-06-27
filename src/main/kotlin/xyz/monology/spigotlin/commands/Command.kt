package xyz.monology.spigotlin.commands

import org.bukkit.command.CommandSender

data class Command<T : Arguments, C : CommandSender>(
    val label: String,
    val description: String,
    val permission: String?,
    val usage: String,
    val tabCompleter: ((CommandSender, List<String>) -> List<String>)?,
    val execute: CommandContext<T, C>.() -> Unit
)