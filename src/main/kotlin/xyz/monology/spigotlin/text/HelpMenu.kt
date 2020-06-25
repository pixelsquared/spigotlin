package xyz.monology.spigotlin.text

import xyz.monology.spigotlin.commands.Command
import xyz.monology.spigotlin.commands.KotlinCommand
import xyz.monology.spigotlin.KotlinPlugin
import xyz.monology.spigotlin.utils.colored
import xyz.monology.spigotlin.utils.plural

object HelpMenu {
    fun generate(plugin: KotlinPlugin) = StringBuilder(header(plugin)).apply {
        plugin.commands.forEach {
            this.append(command(plugin, it))
        }
    }.toString()

    var header = { plugin: KotlinPlugin -> "&bHelp menu for &c${plugin.name}&b: &6${plugin.commands.size} available ${"command".plural(plugin.commands.size)}\n".colored }

    var namespaceHeader = { name: String, size: Int -> "&bHelp menu for &c${name}&b: &6${size} available ${"command".plural(size)}\n".colored }

    var command = { _: KotlinPlugin, command: Command<*, *> -> ("&b${command.usage} &c${command.description}" + (if (command.permission != null) " &6Requires: ${command.permission}" else "") + "\n").colored }

    var namespaceCommand = { base: String, command: KotlinCommand<*, *> -> ("&b/$base ${if (command.usage.startsWith("/")) command.usage.drop(1) else command.usage} &c${command.description}" + (if (command.permission != null) " &6Requires: ${command.permission}" else "") + "\n").colored }
}