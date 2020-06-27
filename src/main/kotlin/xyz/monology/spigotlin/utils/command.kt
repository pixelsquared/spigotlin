package xyz.monology.spigotlin.utils

import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import xyz.monology.spigotlin.commands.*

inline fun <reified T> args(args: Array<String>, index: Int, sender: CommandSender): T? = args[index].run {
    Argument.verify<T>(this, index, args, sender) ?: run {
        CommandIntrinsics.invalidArgumentType(sender, index + 1, Argument.name<T>(), this)
        return null
    }
}

fun Command<Arguments.None, CommandSender>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, _ ->
        this.execute(CommandContext(sender, Arguments.None))
    }

@JvmName("toKotlinCommand1")
inline fun <reified A> Command<Arguments.One<A>, CommandSender>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.isEmpty()) {
            CommandIntrinsics.invalidArgumentAmount(sender, 0, 1)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.One(
                    args<A>(args, 0, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("toKotlinCommand2")
inline fun <reified A, reified B> Command<Arguments.Two<A, B>, CommandSender>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.size > 2) {
            CommandIntrinsics.invalidArgumentAmount(sender, args.size, 2)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.Two(
                    args<A>(args, 0, sender) ?: return@KotlinCommand,
                    args<B>(args, 1, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("toKotlinCommand3")
inline fun <reified A, reified B, reified C> Command<Arguments.Three<A, B, C>, CommandSender>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.size > 3) {
            CommandIntrinsics.invalidArgumentAmount(sender, args.size, 3)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.Three(
                    args<A>(args, 0, sender) ?: return@KotlinCommand,
                    args<B>(args, 1, sender) ?: return@KotlinCommand,
                    args<C>(args, 2, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("toKotlinCommand4")
inline fun <reified A, reified B, reified C, reified D> Command<Arguments.Four<A, B, C, D>, CommandSender>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.size > 4) {
            CommandIntrinsics.invalidArgumentAmount(sender, args.size, 3)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.Four(
                    args<A>(args, 0, sender) ?: return@KotlinCommand,
                    args<B>(args, 1, sender) ?: return@KotlinCommand,
                    args<C>(args, 2, sender) ?: return@KotlinCommand,
                    args<D>(args, 3, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("toKotlinCommand5")
inline fun <reified A, reified B, reified C, reified D, reified E> Command<Arguments.Five<A, B, C, D, E>, CommandSender>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.size > 5) {
            CommandIntrinsics.invalidArgumentAmount(sender, args.size, 3)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.Five(
                    args<A>(args, 0, sender) ?: return@KotlinCommand,
                    args<B>(args, 1, sender) ?: return@KotlinCommand,
                    args<C>(args, 2, sender) ?: return@KotlinCommand,
                    args<D>(args, 3, sender) ?: return@KotlinCommand,
                    args<E>(args, 4, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("toKotlinCommand6")
inline fun <reified A, reified B, reified C, reified D, reified E, reified F> Command<Arguments.Six<A, B, C, D, E, F>, CommandSender>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.size > 5) {
            CommandIntrinsics.invalidArgumentAmount(sender, args.size, 3)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.Six(
                    args<A>(args, 0, sender) ?: return@KotlinCommand,
                    args<B>(args, 1, sender) ?: return@KotlinCommand,
                    args<C>(args, 2, sender) ?: return@KotlinCommand,
                    args<D>(args, 3, sender) ?: return@KotlinCommand,
                    args<E>(args, 4, sender) ?: return@KotlinCommand,
                    args<F>(args, 5, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("toKotlinCommand7")
inline fun <reified A, reified B, reified C, reified D, reified E, reified F, reified G> Command<Arguments.Seven<A, B, C, D, E, F, G>, CommandSender>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.size > 5) {
            CommandIntrinsics.invalidArgumentAmount(sender, args.size, 3)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.Seven(
                    args<A>(args, 0, sender) ?: return@KotlinCommand,
                    args<B>(args, 1, sender) ?: return@KotlinCommand,
                    args<C>(args, 2, sender) ?: return@KotlinCommand,
                    args<D>(args, 3, sender) ?: return@KotlinCommand,
                    args<E>(args, 4, sender) ?: return@KotlinCommand,
                    args<F>(args, 5, sender) ?: return@KotlinCommand,
                    args<G>(args, 6, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("toKotlinCommand8")
inline fun <reified A, reified B, reified C, reified D, reified E, reified F, reified G, reified H> Command<Arguments.Eight<A, B, C, D, E, F, G, H>, CommandSender>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.size > 5) {
            CommandIntrinsics.invalidArgumentAmount(sender, args.size, 3)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.Eight(
                    args<A>(args, 0, sender) ?: return@KotlinCommand,
                    args<B>(args, 1, sender) ?: return@KotlinCommand,
                    args<C>(args, 2, sender) ?: return@KotlinCommand,
                    args<D>(args, 3, sender) ?: return@KotlinCommand,
                    args<E>(args, 4, sender) ?: return@KotlinCommand,
                    args<F>(args, 5, sender) ?: return@KotlinCommand,
                    args<G>(args, 6, sender) ?: return@KotlinCommand,
                    args<H>(args, 7, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("playerToKotlinCommand")
fun Command<Arguments.None, Player>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, _ ->
        if (sender !is Player) {
            CommandIntrinsics.requiresPlayer(sender)
            return@KotlinCommand
        }

        this.execute(CommandContext(sender, Arguments.None))
    }

@JvmName("playerToKotlinCommand1")
inline fun <reified A> Command<Arguments.One<A>, Player>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.isEmpty()) {
            CommandIntrinsics.invalidArgumentAmount(sender, 0, 1)
            return@KotlinCommand
        }

        if (sender !is Player) {
            CommandIntrinsics.requiresPlayer(sender)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.One(
                    args<A>(args, 0, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("playerToKotlinCommand2")
inline fun <reified A, reified B> Command<Arguments.Two<A, B>, Player>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.size > 2) {
            CommandIntrinsics.invalidArgumentAmount(sender, args.size, 2)
            return@KotlinCommand
        }

        if (sender !is Player) {
            CommandIntrinsics.requiresPlayer(sender)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.Two(
                    args<A>(args, 0, sender) ?: return@KotlinCommand,
                    args<B>(args, 1, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("playerToKotlinCommand3")
inline fun <reified A, reified B, reified C> Command<Arguments.Three<A, B, C>, Player>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.size > 3) {
            CommandIntrinsics.invalidArgumentAmount(sender, args.size, 3)
            return@KotlinCommand
        }

        if (sender !is Player) {
            CommandIntrinsics.requiresPlayer(sender)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.Three(
                    args<A>(args, 0, sender) ?: return@KotlinCommand,
                    args<B>(args, 1, sender) ?: return@KotlinCommand,
                    args<C>(args, 2, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("playerToKotlinCommand4")
inline fun <reified A, reified B, reified C, reified D> Command<Arguments.Four<A, B, C, D>, Player>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.size > 4) {
            CommandIntrinsics.invalidArgumentAmount(sender, args.size, 3)
            return@KotlinCommand
        }

        if (sender !is Player) {
            CommandIntrinsics.requiresPlayer(sender)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.Four(
                    args<A>(args, 0, sender) ?: return@KotlinCommand,
                    args<B>(args, 1, sender) ?: return@KotlinCommand,
                    args<C>(args, 2, sender) ?: return@KotlinCommand,
                    args<D>(args, 3, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("playerToKotlinCommand5")
inline fun <reified A, reified B, reified C, reified D, reified E> Command<Arguments.Five<A, B, C, D, E>, Player>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.size > 5) {
            CommandIntrinsics.invalidArgumentAmount(sender, args.size, 3)
            return@KotlinCommand
        }

        if (sender !is Player) {
            CommandIntrinsics.requiresPlayer(sender)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.Five(
                    args<A>(args, 0, sender) ?: return@KotlinCommand,
                    args<B>(args, 1, sender) ?: return@KotlinCommand,
                    args<C>(args, 2, sender) ?: return@KotlinCommand,
                    args<D>(args, 3, sender) ?: return@KotlinCommand,
                    args<E>(args, 4, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("playerToKotlinCommand6")
inline fun <reified A, reified B, reified C, reified D, reified E, reified F> Command<Arguments.Six<A, B, C, D, E, F>, Player>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.size > 5) {
            CommandIntrinsics.invalidArgumentAmount(sender, args.size, 3)
            return@KotlinCommand
        }

        if (sender !is Player) {
            CommandIntrinsics.requiresPlayer(sender)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.Six(
                    args<A>(args, 0, sender) ?: return@KotlinCommand,
                    args<B>(args, 1, sender) ?: return@KotlinCommand,
                    args<C>(args, 2, sender) ?: return@KotlinCommand,
                    args<D>(args, 3, sender) ?: return@KotlinCommand,
                    args<E>(args, 4, sender) ?: return@KotlinCommand,
                    args<F>(args, 5, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("playerToKotlinCommand7")
inline fun <reified A, reified B, reified C, reified D, reified E, reified F, reified G> Command<Arguments.Seven<A, B, C, D, E, F, G>, Player>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.size > 5) {
            CommandIntrinsics.invalidArgumentAmount(sender, args.size, 3)
            return@KotlinCommand
        }

        if (sender !is Player) {
            CommandIntrinsics.requiresPlayer(sender)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.Seven(
                    args<A>(args, 0, sender) ?: return@KotlinCommand,
                    args<B>(args, 1, sender) ?: return@KotlinCommand,
                    args<C>(args, 2, sender) ?: return@KotlinCommand,
                    args<D>(args, 3, sender) ?: return@KotlinCommand,
                    args<E>(args, 4, sender) ?: return@KotlinCommand,
                    args<F>(args, 5, sender) ?: return@KotlinCommand,
                    args<G>(args, 6, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("playerToKotlinCommand8")
inline fun <reified A, reified B, reified C, reified D, reified E, reified F, reified G, reified H> Command<Arguments.Eight<A, B, C, D, E, F, G, H>, Player>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.size > 5) {
            CommandIntrinsics.invalidArgumentAmount(sender, args.size, 3)
            return@KotlinCommand
        }

        if (sender !is Player) {
            CommandIntrinsics.requiresPlayer(sender)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.Eight(
                    args<A>(args, 0, sender) ?: return@KotlinCommand,
                    args<B>(args, 1, sender) ?: return@KotlinCommand,
                    args<C>(args, 2, sender) ?: return@KotlinCommand,
                    args<D>(args, 3, sender) ?: return@KotlinCommand,
                    args<E>(args, 4, sender) ?: return@KotlinCommand,
                    args<F>(args, 5, sender) ?: return@KotlinCommand,
                    args<G>(args, 6, sender) ?: return@KotlinCommand,
                    args<H>(args, 7, sender) ?: return@KotlinCommand
                )
            )
        )
    }


@JvmName("consoleToKotlinCommand")
fun Command<Arguments.None, ConsoleCommandSender>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, _ ->
        if (sender !is ConsoleCommandSender) {
            CommandIntrinsics.requiresConsole(sender)
            return@KotlinCommand
        }

        this.execute(CommandContext(sender, Arguments.None))
    }

@JvmName("consoleToKotlinCommand1")
inline fun <reified A> Command<Arguments.One<A>, ConsoleCommandSender>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.isEmpty()) {
            CommandIntrinsics.invalidArgumentAmount(sender, 0, 1)
            return@KotlinCommand
        }

        if (sender !is ConsoleCommandSender) {
            CommandIntrinsics.requiresConsole(sender)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.One(
                    args<A>(args, 0, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("consoleToKotlinCommand2")
inline fun <reified A, reified B> Command<Arguments.Two<A, B>, ConsoleCommandSender>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.size > 2) {
            CommandIntrinsics.invalidArgumentAmount(sender, args.size, 2)
            return@KotlinCommand
        }

        if (sender !is ConsoleCommandSender) {
            CommandIntrinsics.requiresConsole(sender)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.Two(
                    args<A>(args, 0, sender) ?: return@KotlinCommand,
                    args<B>(args, 1, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("consoleToKotlinCommand3")
inline fun <reified A, reified B, reified C> Command<Arguments.Three<A, B, C>, ConsoleCommandSender>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.size > 3) {
            CommandIntrinsics.invalidArgumentAmount(sender, args.size, 3)
            return@KotlinCommand
        }

        if (sender !is ConsoleCommandSender) {
            CommandIntrinsics.requiresConsole(sender)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.Three(
                    args<A>(args, 0, sender) ?: return@KotlinCommand,
                    args<B>(args, 1, sender) ?: return@KotlinCommand,
                    args<C>(args, 2, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("consoleToKotlinCommand4")
inline fun <reified A, reified B, reified C, reified D> Command<Arguments.Four<A, B, C, D>, ConsoleCommandSender>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.size > 4) {
            CommandIntrinsics.invalidArgumentAmount(sender, args.size, 3)
            return@KotlinCommand
        }

        if (sender !is ConsoleCommandSender) {
            CommandIntrinsics.requiresConsole(sender)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.Four(
                    args<A>(args, 0, sender) ?: return@KotlinCommand,
                    args<B>(args, 1, sender) ?: return@KotlinCommand,
                    args<C>(args, 2, sender) ?: return@KotlinCommand,
                    args<D>(args, 3, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("consoleToKotlinCommand5")
inline fun <reified A, reified B, reified C, reified D, reified E> Command<Arguments.Five<A, B, C, D, E>, ConsoleCommandSender>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.size > 5) {
            CommandIntrinsics.invalidArgumentAmount(sender, args.size, 3)
            return@KotlinCommand
        }

        if (sender !is ConsoleCommandSender) {
            CommandIntrinsics.requiresConsole(sender)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.Five(
                    args<A>(args, 0, sender) ?: return@KotlinCommand,
                    args<B>(args, 1, sender) ?: return@KotlinCommand,
                    args<C>(args, 2, sender) ?: return@KotlinCommand,
                    args<D>(args, 3, sender) ?: return@KotlinCommand,
                    args<E>(args, 4, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("consoleToKotlinCommand6")
inline fun <reified A, reified B, reified C, reified D, reified E, reified F> Command<Arguments.Six<A, B, C, D, E, F>, ConsoleCommandSender>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.size > 5) {
            CommandIntrinsics.invalidArgumentAmount(sender, args.size, 3)
            return@KotlinCommand
        }

        if (sender !is ConsoleCommandSender) {
            CommandIntrinsics.requiresConsole(sender)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.Six(
                    args<A>(args, 0, sender) ?: return@KotlinCommand,
                    args<B>(args, 1, sender) ?: return@KotlinCommand,
                    args<C>(args, 2, sender) ?: return@KotlinCommand,
                    args<D>(args, 3, sender) ?: return@KotlinCommand,
                    args<E>(args, 4, sender) ?: return@KotlinCommand,
                    args<F>(args, 5, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("consoleToKotlinCommand7")
inline fun <reified A, reified B, reified C, reified D, reified E, reified F, reified G> Command<Arguments.Seven<A, B, C, D, E, F, G>, ConsoleCommandSender>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.size > 5) {
            CommandIntrinsics.invalidArgumentAmount(sender, args.size, 3)
            return@KotlinCommand
        }

        if (sender !is ConsoleCommandSender) {
            CommandIntrinsics.requiresConsole(sender)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.Seven(
                    args<A>(args, 0, sender) ?: return@KotlinCommand,
                    args<B>(args, 1, sender) ?: return@KotlinCommand,
                    args<C>(args, 2, sender) ?: return@KotlinCommand,
                    args<D>(args, 3, sender) ?: return@KotlinCommand,
                    args<E>(args, 4, sender) ?: return@KotlinCommand,
                    args<F>(args, 5, sender) ?: return@KotlinCommand,
                    args<G>(args, 6, sender) ?: return@KotlinCommand
                )
            )
        )
    }

@JvmName("consoleToKotlinCommand8")
inline fun <reified A, reified B, reified C, reified D, reified E, reified F, reified G, reified H> Command<Arguments.Eight<A, B, C, D, E, F, G, H>, ConsoleCommandSender>.toKotlinCommand() =
    KotlinCommand(this, tabCompleter) { sender, args ->
        if (args.size > 5) {
            CommandIntrinsics.invalidArgumentAmount(sender, args.size, 3)
            return@KotlinCommand
        }

        if (sender !is ConsoleCommandSender) {
            CommandIntrinsics.requiresConsole(sender)
            return@KotlinCommand
        }

        this.execute(
            CommandContext(
                sender, Arguments.Eight(
                    args<A>(args, 0, sender) ?: return@KotlinCommand,
                    args<B>(args, 1, sender) ?: return@KotlinCommand,
                    args<C>(args, 2, sender) ?: return@KotlinCommand,
                    args<D>(args, 3, sender) ?: return@KotlinCommand,
                    args<E>(args, 4, sender) ?: return@KotlinCommand,
                    args<F>(args, 5, sender) ?: return@KotlinCommand,
                    args<G>(args, 6, sender) ?: return@KotlinCommand,
                    args<H>(args, 7, sender) ?: return@KotlinCommand
                )
            )
        )
    }