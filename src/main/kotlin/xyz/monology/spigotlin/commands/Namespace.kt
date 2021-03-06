package xyz.monology.spigotlin.commands

import org.bukkit.command.CommandSender
import org.bukkit.command.defaults.BukkitCommand

class Namespace(
    val name: String,
    description: String,
    baseCommand: CommandContext<Arguments.None, CommandSender>.() -> Unit,
    commands: List<KotlinCommand<*, out CommandSender>>,
    permission: String?
) {
    val command = object : BukkitCommand(name) {
        override fun execute(sender: CommandSender, commandLabel: String, args: Array<out String>): Boolean {
            if (permission != null) {
                if (!sender.hasPermission(permission)) {
                    CommandIntrinsics.noPermission(sender, label, permission)
                }
            }

            if (args.isEmpty()) {
                baseCommand(CommandContext(sender, Arguments.None))
                return true
            }

            val subLabel = args[0]
            val args = args.drop(0).toTypedArray()
            if (!commands.any {
                    if (it.label == subLabel) {
                        return it.execute(sender, subLabel, args)
                    }
                    it.label == subLabel
                }) {
                CommandIntrinsics.unknownCommand(sender, label, subLabel)
            }

            return true
        }

        override fun tabComplete(sender: CommandSender, alias: String, args: Array<out String>): List<String> {
            if (permission != null) {
                if (!sender.hasPermission(permission)) {
                    return emptyList()
                }
            }
            if (args.size > 1) {
                val filter = commands.filter { it.label == args[0] }
                if (filter.size == 1) {
                    val slicedArgs = args.slice(1 until args.size)
                    return filter[0].tabComplete(sender, alias, slicedArgs.toTypedArray())
                }
                return emptyList()
            }
            val filteredCommands = if (args[0].isBlank()) commands else commands.filter { it.label.startsWith(args[0], true) }
            return filteredCommands.map { it.label }
        }

        init {
            this.description = description
            usage = "/$name <args>"
        }
    }
}