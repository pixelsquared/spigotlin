package xyz.monology.spigotlin.commands

import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import kotlin.reflect.KClass

object Argument {
    fun Array<String>.dropOrNull(count: Int) = try {
        drop(count)
    } catch (e: Exception) {
        null
    }

    var showNumberArgumentRanges = false

    var argumentNames = mutableMapOf(
        "Long" to "a whole number" + (if (showNumberArgumentRanges) " between ${Long.MIN_VALUE} and ${Long.MAX_VALUE}" else ""),
        "Int" to "a whole number" + (if (showNumberArgumentRanges) " between ${Int.MIN_VALUE} and ${Int.MAX_VALUE}" else ""),
        "Short" to "a whole number" + (if (showNumberArgumentRanges) " between ${Short.MIN_VALUE} and ${Short.MAX_VALUE}" else ""),
        "Byte" to "a whole number" + (if (showNumberArgumentRanges) " between ${Byte.MIN_VALUE} and ${Byte.MAX_VALUE}" else ""),
        "Double" to "a decimal number" + (if (showNumberArgumentRanges) " between ${Double.MIN_VALUE} and ${Double.MAX_VALUE}" else ""),
        "Float" to "a decimal number" + (if (showNumberArgumentRanges) " between ${Float.MIN_VALUE} and ${Float.MAX_VALUE}" else ""),
        "String" to "a sentence",
        "Word" to "a word",
        "Player" to "an online player's name"
    )

    inline fun <reified T> name() = argumentNames[T::class.simpleName]
        ?: throw IllegalArgumentException("Invalid argument type: " + T::class.simpleName)

    var customArguments = mutableMapOf<KClass<*>, (String, Int, Array<String>, CommandSender) -> Any?>()

    inline fun <reified T> verify(message: String, index: Int, allArgs: Array<String>, commandSender: CommandSender): T? {
        return when (val c = T::class) {
            Long::class -> message.toLongOrNull() as T?
            Int::class -> message.toIntOrNull() as T?
            Short::class -> message.toShortOrNull() as T?
            Byte::class -> message.toByteOrNull() as T?
            Double::class -> message.toDoubleOrNull() as T?
            Float::class -> message.toFloatOrNull() as T?
            String::class -> allArgs.dropOrNull(index + 1)?.joinToString(" ") as T?
            Word::class -> if (message.split(" ").size != 1) null else Word(message) as T
            Player::class -> (Bukkit.getPlayer(message) as T?).apply {
                if (this == null) CommandIntrinsics.playerIsNotOnline(commandSender, message)
            }
            else -> (customArguments[c] ?: throw IllegalArgumentException("Unsupported argument type: ${T::class.qualifiedName}"))(message, index, allArgs, commandSender) as T?
        }
    }
}