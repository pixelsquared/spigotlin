package xyz.monology.spigotlin.dsl

import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import xyz.monology.spigotlin.commands.Argument
import xyz.monology.spigotlin.commands.Arguments
import xyz.monology.spigotlin.commands.Command
import xyz.monology.spigotlin.commands.CommandContext

inline fun command(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.None, CommandSender>.() -> Unit
): Command<Arguments.None, CommandSender> {
    return Command(label, description, permission, usage ?: "/$label", onTab) { block() }
}

@JvmName("command1")
inline fun <reified P1> command(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.One<P1>, CommandSender>.() -> Unit
): Command<Arguments.One<P1>, CommandSender> {
    return Command(label, description, permission, usage ?: "/$label <${Argument.name<P1>()}>", onTab) { block() }
}

@JvmName("command2")
inline fun <reified P1, reified P2> command(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.Two<P1, P2>, CommandSender>.() -> Unit
): Command<Arguments.Two<P1, P2>, CommandSender> {
    return Command(
        label,
        description,
        permission,
        usage ?: "/$label <${Argument.name<P1>()}> <${Argument.name<P2>()}>",
        onTab
    ) { block() }
}

@JvmName("command3")
inline fun <reified P1, reified P2, reified P3> command(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.Three<P1, P2, P3>, CommandSender>.() -> Unit
): Command<Arguments.Three<P1, P2, P3>, CommandSender> {
    return Command(
        label,
        description,
        permission,
        usage ?: "/$label <${Argument.name<P1>()}> <${Argument.name<P2>()}> <${Argument.name<P3>()}>",
        onTab
    ) { block() }
}

@JvmName("command4")
inline fun <reified P1, reified P2, reified P3, reified P4> command(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.Four<P1, P2, P3, P4>, CommandSender>.() -> Unit
): Command<Arguments.Four<P1, P2, P3, P4>, CommandSender> {
    return Command(
        label,
        description,
        permission,
        usage
            ?: "/$label <${Argument.name<P1>()}> <${Argument.name<P2>()}> <${Argument.name<P3>()}> <${Argument.name<P4>()}>",
        onTab
    ) { block() }
}

@JvmName("command5")
inline fun <reified P1, reified P2, reified P3, reified P4, reified P5> command(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.Five<P1, P2, P3, P4, P5>, CommandSender>.() -> Unit
): Command<Arguments.Five<P1, P2, P3, P4, P5>, CommandSender> {
    return Command(
        label,
        description,
        permission,
        usage
            ?: "/$label <${Argument.name<P1>()}> <${Argument.name<P2>()}> <${Argument.name<P3>()}> <${Argument.name<P4>()}> <${Argument.name<P5>()}>",
        onTab
    ) { block() }
}

@JvmName("command6")
inline fun <reified P1, reified P2, reified P3, reified P4, reified P5, reified P6> command(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.Six<P1, P2, P3, P4, P5, P6>, CommandSender>.() -> Unit
): Command<Arguments.Six<P1, P2, P3, P4, P5, P6>, CommandSender> {
    return Command(
        label,
        description,
        permission,
        usage ?: "/$label <${Argument.name<P1>()}> <${Argument.name<P2>()}> <${Argument.name<P3>()}> <${Argument.name<P4>()}> <${Argument.name<P5>()}> <${Argument.name<P6>()}>",
        onTab
    ) { block() }
}

@JvmName("command7")
inline fun <reified P1, reified P2, reified P3, reified P4, reified P5, reified P6, reified P7> command(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.Seven<P1, P2, P3, P4, P5, P6, P7>, CommandSender>.() -> Unit
): Command<Arguments.Seven<P1, P2, P3, P4, P5, P6, P7>, CommandSender> {
    return Command(
        label,
        description,
        permission,
        usage
            ?: "/$label <${Argument.name<P1>()}> <${Argument.name<P2>()}> <${Argument.name<P3>()}> <${Argument.name<P4>()}> <${Argument.name<P5>()}> <${Argument.name<P6>()}> <${Argument.name<P7>()}>",
        onTab
    ) { block() }
}

@JvmName("command8")
inline fun <reified P1, reified P2, reified P3, reified P4, reified P5, reified P6, reified P7, reified P8> command(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.Eight<P1, P2, P3, P4, P5, P6, P7, P8>, CommandSender>.() -> Unit
): Command<Arguments.Eight<P1, P2, P3, P4, P5, P6, P7, P8>, CommandSender> {
    return Command(
        label,
        description,
        permission,
        usage
            ?: "/$label <${Argument.name<P1>()}> <${Argument.name<P2>()}> <${Argument.name<P3>()}> <${Argument.name<P4>()}> <${Argument.name<P5>()}> <${Argument.name<P6>()}> <${Argument.name<P7>()}> <${Argument.name<P8>()}>",
        onTab
    ) { block() }
}

inline fun playerCommand(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.None, Player>.() -> Unit
): Command<Arguments.None, Player> {
    return Command(label, description, permission, usage ?: "/$label", onTab) { block() }
}

@JvmName("playerCommand1")
inline fun <reified P1> playerCommand(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.One<P1>, Player>.() -> Unit
): Command<Arguments.One<P1>, Player> {
    return Command(label, description, permission, usage ?: "/$label <${Argument.name<P1>()}>", onTab) { block() }
}

@JvmName("playerCommand2")
inline fun <reified P1, reified P2> playerCommand(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.Two<P1, P2>, Player>.() -> Unit
): Command<Arguments.Two<P1, P2>, Player> {
    return Command(
        label,
        description,
        permission,
        usage ?: "/$label <${Argument.name<P1>()}> <${Argument.name<P2>()}>",
        onTab
    ) { block() }
}

@JvmName("playerCommand3")
inline fun <reified P1, reified P2, reified P3> playerCommand(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.Three<P1, P2, P3>, Player>.() -> Unit
): Command<Arguments.Three<P1, P2, P3>, Player> {
    return Command(
        label,
        description,
        permission,
        usage ?: "/$label <${Argument.name<P1>()}> <${Argument.name<P2>()}> <${Argument.name<P3>()}>",
        onTab
    ) { block() }
}

@JvmName("playerCommand4")
inline fun <reified P1, reified P2, reified P3, reified P4> playerCommand(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.Four<P1, P2, P3, P4>, Player>.() -> Unit
): Command<Arguments.Four<P1, P2, P3, P4>, Player> {
    return Command(
        label,
        description,
        permission,
        usage
            ?: "/$label <${Argument.name<P1>()}> <${Argument.name<P2>()}> <${Argument.name<P3>()}> <${Argument.name<P4>()}>",
        onTab
    ) { block() }
}

@JvmName("playerCommand5")
inline fun <reified P1, reified P2, reified P3, reified P4, reified P5> playerCommand(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.Five<P1, P2, P3, P4, P5>, Player>.() -> Unit
): Command<Arguments.Five<P1, P2, P3, P4, P5>, Player> {
    return Command(
        label,
        description,
        permission,
        usage
            ?: "/$label <${Argument.name<P1>()}> <${Argument.name<P2>()}> <${Argument.name<P3>()}> <${Argument.name<P4>()}> <${Argument.name<P5>()}>",
        onTab
    ) { block() }
}

@JvmName("playerCommand6")
inline fun <reified P1, reified P2, reified P3, reified P4, reified P5, reified P6> playerCommand(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.Six<P1, P2, P3, P4, P5, P6>, Player>.() -> Unit
): Command<Arguments.Six<P1, P2, P3, P4, P5, P6>, Player> {
    return Command(
        label,
        description,
        permission,
        usage
            ?: "/$label <${Argument.name<P1>()}> <${Argument.name<P2>()}> <${Argument.name<P3>()}> <${Argument.name<P4>()}> <${Argument.name<P5>()}> <${Argument.name<P6>()}>",
        onTab
    ) { block() }
}

@JvmName("playerCommand7")
inline fun <reified P1, reified P2, reified P3, reified P4, reified P5, reified P6, reified P7> playerCommand(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.Seven<P1, P2, P3, P4, P5, P6, P7>, Player>.() -> Unit
): Command<Arguments.Seven<P1, P2, P3, P4, P5, P6, P7>, Player> {
    return Command(
        label,
        description,
        permission,
        usage
            ?: "/$label <${Argument.name<P1>()}> <${Argument.name<P2>()}> <${Argument.name<P3>()}> <${Argument.name<P4>()}> <${Argument.name<P5>()}> <${Argument.name<P6>()}> <${Argument.name<P7>()}>",
        onTab
    ) { block() }
}

@JvmName("playerCommand8")
inline fun <reified P1, reified P2, reified P3, reified P4, reified P5, reified P6, reified P7, reified P8> playerCommand(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.Eight<P1, P2, P3, P4, P5, P6, P7, P8>, Player>.() -> Unit
): Command<Arguments.Eight<P1, P2, P3, P4, P5, P6, P7, P8>, Player> {
    return Command(
        label,
        description,
        permission,
        usage
            ?: "/$label <${Argument.name<P1>()}> <${Argument.name<P2>()}> <${Argument.name<P3>()}> <${Argument.name<P4>()}> <${Argument.name<P5>()}> <${Argument.name<P6>()}> <${Argument.name<P7>()}> <${Argument.name<P8>()}>",
        onTab
    ) { block() }
}

inline fun consoleCommand(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.None, ConsoleCommandSender>.() -> Unit
): Command<Arguments.None, ConsoleCommandSender> {
    return Command(label, description, permission, usage ?: "/$label", onTab) { block() }
}

@JvmName("consoleCommand1")
inline fun <reified P1> consoleCommand(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.One<P1>, ConsoleCommandSender>.() -> Unit
): Command<Arguments.One<P1>, ConsoleCommandSender> {
    return Command(label, description, permission, usage ?: "/$label <${Argument.name<P1>()}>", onTab) { block() }
}

@JvmName("consoleCommand2")
inline fun <reified P1, reified P2> consoleCommand(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.Two<P1, P2>, ConsoleCommandSender>.() -> Unit
): Command<Arguments.Two<P1, P2>, ConsoleCommandSender> {
    return Command(
        label,
        description,
        permission,
        usage ?: "/$label <${Argument.name<P1>()}> <${Argument.name<P2>()}>",
        onTab
    ) { block() }
}

@JvmName("consoleCommand3")
inline fun <reified P1, reified P2, reified P3> consoleCommand(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.Three<P1, P2, P3>, ConsoleCommandSender>.() -> Unit
): Command<Arguments.Three<P1, P2, P3>, ConsoleCommandSender> {
    return Command(
        label,
        description,
        permission,
        usage ?: "/$label <${Argument.name<P1>()}> <${Argument.name<P2>()}> <${Argument.name<P3>()}>",
        onTab
    ) { block() }
}

@JvmName("consoleCommand4")
inline fun <reified P1, reified P2, reified P3, reified P4> consoleCommand(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.Four<P1, P2, P3, P4>, ConsoleCommandSender>.() -> Unit
): Command<Arguments.Four<P1, P2, P3, P4>, ConsoleCommandSender> {
    return Command(
        label,
        description,
        permission,
        usage
            ?: "/$label <${Argument.name<P1>()}> <${Argument.name<P2>()}> <${Argument.name<P3>()}> <${Argument.name<P4>()}>",
        onTab
    ) { block() }
}

@JvmName("consoleCommand5")
inline fun <reified P1, reified P2, reified P3, reified P4, reified P5> consoleCommand(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.Five<P1, P2, P3, P4, P5>, ConsoleCommandSender>.() -> Unit
): Command<Arguments.Five<P1, P2, P3, P4, P5>, ConsoleCommandSender> {
    return Command(
        label,
        description,
        permission,
        usage
            ?: "/$label <${Argument.name<P1>()}> <${Argument.name<P2>()}> <${Argument.name<P3>()}> <${Argument.name<P4>()}> <${Argument.name<P5>()}>",
        onTab
    ) { block() }
}

@JvmName("consoleCommand6")
inline fun <reified P1, reified P2, reified P3, reified P4, reified P5, reified P6> consoleCommand(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.Six<P1, P2, P3, P4, P5, P6>, ConsoleCommandSender>.() -> Unit
): Command<Arguments.Six<P1, P2, P3, P4, P5, P6>, ConsoleCommandSender> {
    return Command(
        label,
        description,
        permission,
        usage
            ?: "/$label <${Argument.name<P1>()}> <${Argument.name<P2>()}> <${Argument.name<P3>()}> <${Argument.name<P4>()}> <${Argument.name<P5>()}> <${Argument.name<P6>()}>",
        onTab
    ) { block() }
}

@JvmName("consoleCommand7")
inline fun <reified P1, reified P2, reified P3, reified P4, reified P5, reified P6, reified P7> consoleCommand(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.Seven<P1, P2, P3, P4, P5, P6, P7>, ConsoleCommandSender>.() -> Unit
): Command<Arguments.Seven<P1, P2, P3, P4, P5, P6, P7>, ConsoleCommandSender> {
    return Command(
        label,
        description,
        permission,
        usage
            ?: "/$label <${Argument.name<P1>()}> <${Argument.name<P2>()}> <${Argument.name<P3>()}> <${Argument.name<P4>()}> <${Argument.name<P5>()}> <${Argument.name<P6>()}> <${Argument.name<P7>()}>",
        onTab
    ) { block() }
}

@JvmName("consoleCommand8")
inline fun <reified P1, reified P2, reified P3, reified P4, reified P5, reified P6, reified P7, reified P8> consoleCommand(
    label: String,
    description: String = "A command.",
    usage: String? = null,
    permission: String? = null,
    noinline onTab: ((CommandSender, List<String>) -> List<String>)? = null,
    crossinline block: CommandContext<Arguments.Eight<P1, P2, P3, P4, P5, P6, P7, P8>, ConsoleCommandSender>.() -> Unit
): Command<Arguments.Eight<P1, P2, P3, P4, P5, P6, P7, P8>, ConsoleCommandSender> {
    return Command(
        label,
        description,
        permission,
        usage
            ?: "/$label <${Argument.name<P1>()}> <${Argument.name<P2>()}> <${Argument.name<P3>()}> <${Argument.name<P4>()}> <${Argument.name<P5>()}> <${Argument.name<P6>()}> <${Argument.name<P7>()}> <${Argument.name<P8>()}>",
        onTab
    ) { block() }
}