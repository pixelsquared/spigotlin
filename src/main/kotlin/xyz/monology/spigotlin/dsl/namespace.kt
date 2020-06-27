package xyz.monology.spigotlin.dsl

import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import xyz.monology.spigotlin.commands.*
import xyz.monology.spigotlin.text.HelpMenu
import xyz.monology.spigotlin.utils.toKotlinCommand

class NamespaceDSL(val name: String) {
    var execute: CommandContext<Arguments.None, CommandSender>.() -> Unit = {}
    var permission: String? = null
    val commands = mutableListOf<KotlinCommand<*, out CommandSender>>()
    
    fun execute(block: CommandContext<Arguments.None, CommandSender>.() -> Unit) {
        execute = block
    }

    inline fun fallbackCommand(label: String, description: String = "A command.", usage: String? = null, permission: String? = null, noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null, crossinline block: CommandContext<Arguments.None, CommandSender>.() -> Unit) =
        FallbackCommand(Command(label, description, permission, usage ?: "/$label", onTab) { block() })

    operator fun FallbackCommand.unaryPlus() {
        commands.add(command.toKotlinCommand())
        execute(command.execute)
    }

    operator fun Command<Arguments.None, CommandSender>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("unaryPlus1")
    inline operator fun <reified A> Command<Arguments.One<A>, CommandSender>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("unaryPlus2")
    inline operator fun <reified A, reified B> Command<Arguments.Two<A, B>, CommandSender>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("unaryPlus3")
    inline operator fun <reified A, reified B, reified C> Command<Arguments.Three<A, B, C>, CommandSender>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("unaryPlus4")
    inline operator fun <reified A, reified B, reified C, reified D> Command<Arguments.Four<A, B, C, D>, CommandSender>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("unaryPlus5")
    inline operator fun <reified A, reified B, reified C, reified D, reified E> Command<Arguments.Five<A, B, C, D, E>, CommandSender>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("unaryPlus6")
    inline operator fun <reified A, reified B, reified C, reified D, reified E, reified F> Command<Arguments.Six<A, B, C, D, E, F>, CommandSender>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("unaryPlus7")
    inline operator fun <reified A, reified B, reified C, reified D, reified E, reified F, reified G> Command<Arguments.Seven<A, B, C, D, E, F, G>, CommandSender>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("unaryPlus8")
    inline operator fun <reified A, reified B, reified C, reified D, reified E, reified F, reified G, reified H> Command<Arguments.Eight<A, B, C, D, E, F, G, H>, CommandSender>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("playerUnaryPlus")
    operator fun Command<Arguments.None, Player>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("playerUnaryPlus1")
    inline operator fun <reified A> Command<Arguments.One<A>, Player>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("playerUnaryPlus2")
    inline operator fun <reified A, reified B> Command<Arguments.Two<A, B>, Player>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("playerUnaryPlus3")
    inline operator fun <reified A, reified B, reified C> Command<Arguments.Three<A, B, C>, Player>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("playerUnaryPlus4")
    inline operator fun <reified A, reified B, reified C, reified D> Command<Arguments.Four<A, B, C, D>, Player>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("playerUnaryPlus5")
    inline operator fun <reified A, reified B, reified C, reified D, reified E> Command<Arguments.Five<A, B, C, D, E>, Player>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("playerUnaryPlus6")
    inline operator fun <reified A, reified B, reified C, reified D, reified E, reified F> Command<Arguments.Six<A, B, C, D, E, F>, Player>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("playerUnaryPlus7")
    inline operator fun <reified A, reified B, reified C, reified D, reified E, reified F, reified G> Command<Arguments.Seven<A, B, C, D, E, F, G>, Player>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("playerUnaryPlus8")
    inline operator fun <reified A, reified B, reified C, reified D, reified E, reified F, reified G, reified H> Command<Arguments.Eight<A, B, C, D, E, F, G, H>, Player>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("consoleUnaryPlus")
    operator fun Command<Arguments.None, ConsoleCommandSender>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("consoleUnaryPlus1")
    inline operator fun <reified A> Command<Arguments.One<A>, ConsoleCommandSender>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("consoleUnaryPlus2")
    inline operator fun <reified A, reified B> Command<Arguments.Two<A, B>, ConsoleCommandSender>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("consoleUnaryPlus3")
    inline operator fun <reified A, reified B, reified C> Command<Arguments.Three<A, B, C>, ConsoleCommandSender>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("consoleUnaryPlus4")
    inline operator fun <reified A, reified B, reified C, reified D> Command<Arguments.Four<A, B, C, D>, ConsoleCommandSender>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("consoleUnaryPlus5")
    inline operator fun <reified A, reified B, reified C, reified D, reified E> Command<Arguments.Five<A, B, C, D, E>, ConsoleCommandSender>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("consoleUnaryPlus6")
    inline operator fun <reified A, reified B, reified C, reified D, reified E, reified F> Command<Arguments.Six<A, B, C, D, E, F>, ConsoleCommandSender>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("consoleUnaryPlus7")
    inline operator fun <reified A, reified B, reified C, reified D, reified E, reified F, reified G> Command<Arguments.Seven<A, B, C, D, E, F, G>, ConsoleCommandSender>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    @JvmName("consoleUnaryPlus8")
    inline operator fun <reified A, reified B, reified C, reified D, reified E, reified F, reified G, reified H> Command<Arguments.Eight<A, B, C, D, E, F, G, H>, ConsoleCommandSender>.unaryPlus() {
        commands.add(toKotlinCommand())
    }

    fun HelpMenu.generate() = StringBuilder(namespaceHeader("", commands.size)).apply {
        commands.forEach {
            this.append(namespaceCommand(name, it))
        }
    }
}

inline fun namespace(label: String, description: String = "A command.", block: NamespaceDSL.() -> Unit) = NamespaceDSL(label).apply(block).run {
    Namespace(label, description, execute, commands, permission)
}