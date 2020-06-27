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
                return emptyList()
            }
            return commands.map { it.label }
        }

        init {
            this.description = description
            usage = "/$name <args>"
        }
    }
}