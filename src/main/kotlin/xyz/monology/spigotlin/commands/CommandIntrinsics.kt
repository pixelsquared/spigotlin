package xyz.monology.spigotlin.commands

import org.bukkit.command.CommandSender
import xyz.monology.spigotlin.utils.colored
import xyz.monology.spigotlin.utils.ordinal
import xyz.monology.spigotlin.utils.plural

object CommandIntrinsics {
    var playerIsNotOnline = { receiver: CommandSender, name: String ->
        receiver.sendMessage("&cThe player $name is not online or does not exist.".colored)
    }

    var invalidArgumentType = { receiver: CommandSender, argumentNum: Int, requiredArgument: String, givenMessage: String ->
        receiver.sendMessage("&cInvalid arguments. This command requires $requiredArgument as its ${argumentNum.ordinal} argument. You input \"${givenMessage}\".".colored)
    }

    var requiresPlayer = { receiver: CommandSender ->
        receiver.sendMessage("&cYou must be a player to execute this command.".colored)
    }

    var requiresConsole = { receiver: CommandSender ->
        receiver.sendMessage("&cYou must be on the server console to execute this command.".colored)
    }

    var invalidArgumentAmount = { receiver: CommandSender, givenArguments: Int, requiredArguments: Int ->
        receiver.sendMessage("&cThis command requires $requiredArguments ${"argument".plural(requiredArguments)}, but you put in $givenArguments ${"argument".plural(givenArguments)}.".colored)
    }

    /**
     * @param receiver the person who doesn't have permission
     * @param command the label of the command which they do not have access to
     * @param permission the permission required
     */
    var noPermission = { receiver: CommandSender, _: String, _: String ->
        receiver.sendMessage("&cYou don't have permission to execute this command.".colored)
    }

    var unknownCommand = { receiver: CommandSender, base: String, command: String ->
        receiver.sendMessage("&cUnknown sub command. \"/$base $command\"".colored)
    }
}