package xyz.monology.spigotlin.commands

import org.bukkit.Bukkit
import org.bukkit.command.CommandMap
import org.bukkit.command.CommandSender
import org.bukkit.command.defaults.BukkitCommand

class KotlinCommand<T : Arguments, C : CommandSender>(command: Command<T, C>, private val tabCompleter: ((CommandSender, List<String>) -> List<String>)?, val block: (CommandSender, Array<String>) -> Unit) : BukkitCommand(command.label) {
    override fun execute(sender: CommandSender, commandLabel: String, args: Array<String>): Boolean {
        if (permission != null) {
            if (!sender.hasPermission(permission!!)) {
                CommandIntrinsics.noPermission(sender, permission!!, label)
                return true
            }
        }

        block(sender, args)
        return true
    }

    override fun tabComplete(sender: CommandSender, alias: String, args: Array<String>): List<String> {
        return tabCompleter?.invoke(sender, args.toList()) ?: super.tabComplete(sender, alias, args)
    }

    fun register() {
        Bukkit.getServer().javaClass.getDeclaredField("commandMap").apply {
            isAccessible = true

            (get(Bukkit.getServer()) as CommandMap).register(label, this@KotlinCommand)
        }
    }

    init {
        this.description = command.description
        this.usage = command.usage
        this.permission = command.permission
    }
}