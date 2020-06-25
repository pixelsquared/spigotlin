package xyz.monology.spigotlin

import org.bukkit.Bukkit
import org.bukkit.command.CommandMap
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitTask
import xyz.monology.spigotlin.commands.*
import xyz.monology.spigotlin.config.Config
import xyz.monology.spigotlin.dsl.ConfigDSL
import xyz.monology.spigotlin.dsl.config
import xyz.monology.spigotlin.dsl.event
import xyz.monology.spigotlin.gui.GUI
import xyz.monology.spigotlin.gui.OnClickEvent
import xyz.monology.spigotlin.text.HelpMenu
import xyz.monology.spigotlin.utils.toKotlinCommand
import java.io.File

open class KotlinPlugin : JavaPlugin() {
    fun HelpMenu.generate() = generate(this@KotlinPlugin)

    inline fun BukkitScope.launch(delay: Long = 0, async: Boolean = false, crossinline block: BukkitTask.() -> Unit) {
        launch(this@KotlinPlugin, delay, async, block)
    }

    inline fun BukkitScope.launchTimer(period: Long, delay: Long = 0, async: Boolean = false, crossinline block: BukkitTask.() -> Unit) {
        launchTimer(this@KotlinPlugin, period, delay, async, block)
    }


    inline fun config(file: File, block: ConfigDSL.() -> Unit): Config {
        return ConfigDSL(this, file).apply(block).config
    }

    inline fun config(name: String, block: ConfigDSL.() -> Unit): Config {
        return ConfigDSL(this, File(dataFolder, "$name.yml")).apply(block).config
    }

    final override fun onEnable() {
        enable()
        register(listener)
    }

    final override fun onDisable() {
        disable()
    }

    final override fun onLoad() {
        load()
    }

    open fun enable() {}

    open fun disable() {}

    open fun load() {}

    fun checkForUpdates(id: Int, message: String, permission: String? = null) {
        xyz.monology.spigotlin.utils.checkForUpdates(this, id, message, permission)
    }

    inline fun checkForUpdates(id: Int, crossinline predicate: (Boolean) -> Unit) {
        xyz.monology.spigotlin.utils.checkForUpdates(this, id) { predicate(it) }
    }

    inline fun <reified T : Event> register(pair: Pair<EventPriority, T.() -> Unit>) {
        server.pluginManager.registerEvent(
            T::class.java,
            object : Listener {},
            pair.first,
            { _, it -> if (it is T) pair.second(it) },
            this
        )
    }

    @PublishedApi
    internal val commands = mutableListOf<Command<*, *>>()

    fun register(namespace: Namespace) {
        Bukkit.getServer().javaClass.getDeclaredField("commandMap").apply {
            isAccessible = true

            (get(Bukkit.getServer()) as CommandMap).register(namespace.name, namespace.command)
        }
    }

    fun register(command: Command<Arguments.None, CommandSender>) {
        command.toKotlinCommand().register()
    }

    @JvmName("register1")
    inline fun <reified A> register(command: Command<Arguments.One<A>, CommandSender>) {
        command.toKotlinCommand().register()
    }

    @JvmName("register2")
    inline fun <reified A, reified B> register(command: Command<Arguments.Two<A, B>, CommandSender>) {
        command.toKotlinCommand().register()
    }

    @JvmName("register3")
    inline fun <reified A, reified B, reified C> register(command: Command<Arguments.Three<A, B, C>, CommandSender>) {
        command.toKotlinCommand().register()
    }

    @JvmName("register4")
    inline fun <reified A, reified B, reified C, reified D> register(command: Command<Arguments.Four<A, B, C, D>, CommandSender>) {
        command.toKotlinCommand().register()
    }

    @JvmName("register5")
    inline fun <reified A, reified B, reified C, reified D, reified E> register(command: Command<Arguments.Five<A, B, C, D, E>, CommandSender>) {
        command.toKotlinCommand().register()
    }

    @JvmName("register6")
    inline fun <reified A, reified B, reified C, reified D, reified E, reified F> register(command: Command<Arguments.Six<A, B, C, D, E, F>, CommandSender>) {
        command.toKotlinCommand().register()
    }

    @JvmName("register7")
    inline fun <reified A, reified B, reified C, reified D, reified E, reified F, reified G> register(command: Command<Arguments.Seven<A, B, C, D, E, F, G>, CommandSender>) {
        command.toKotlinCommand().register()
    }

    @JvmName("register8")
    inline fun <reified A, reified B, reified C, reified D, reified E, reified F, reified G, reified H> register(command: Command<Arguments.Eight<A, B, C, D, E, F, G, H>, CommandSender>) {
        command.toKotlinCommand().register()
    }

    @JvmName("playerRegister")
    fun register(command: Command<Arguments.None, Player>) {
        command.toKotlinCommand().register()
    }

    @JvmName("playerRegister1")
    inline fun <reified A> register(command: Command<Arguments.One<A>, Player>) {
        command.toKotlinCommand().register()
    }

    @JvmName("playerRegister2")
    inline fun <reified A, reified B> register(command: Command<Arguments.Two<A, B>, Player>) {
        command.toKotlinCommand().register()
    }

    @JvmName("playerRegister3")
    inline fun <reified A, reified B, reified C> register(command: Command<Arguments.Three<A, B, C>, Player>) {
        command.toKotlinCommand().register()
    }

    @JvmName("playerRegister4")
    inline fun <reified A, reified B, reified C, reified D> register(command: Command<Arguments.Four<A, B, C, D>, Player>) {
        command.toKotlinCommand().register()
    }

    @JvmName("playerRegister5")
    inline fun <reified A, reified B, reified C, reified D, reified E> register(command: Command<Arguments.Five<A, B, C, D, E>, Player>) {
        command.toKotlinCommand().register()
    }

    @JvmName("playerRegister6")
    inline fun <reified A, reified B, reified C, reified D, reified E, reified F> register(command: Command<Arguments.Six<A, B, C, D, E, F>, Player>) {
        command.toKotlinCommand().register()
    }

    @JvmName("playerRegister7")
    inline fun <reified A, reified B, reified C, reified D, reified E, reified F, reified G> register(command: Command<Arguments.Seven<A, B, C, D, E, F, G>, Player>) {
        command.toKotlinCommand().register()
    }

    @JvmName("playerRegister8")
    inline fun <reified A, reified B, reified C, reified D, reified E, reified F, reified G, reified H> register(command: Command<Arguments.Eight<A, B, C, D, E, F, G, H>, Player>) {
        command.toKotlinCommand().register()
    }


    @JvmName("consoleRegister")
    fun register(command: Command<Arguments.None, ConsoleCommandSender>) {
        command.toKotlinCommand().register()
    }

    @JvmName("consoleRegister1")
    inline fun <reified A> register(command: Command<Arguments.One<A>, ConsoleCommandSender>) {
        command.toKotlinCommand().register()
    }

    @JvmName("consoleRegister2")
    inline fun <reified A, reified B> register(command: Command<Arguments.Two<A, B>, ConsoleCommandSender>) {
        command.toKotlinCommand().register()
    }

    @JvmName("consoleRegister3")
    inline fun <reified A, reified B, reified C> register(command: Command<Arguments.Three<A, B, C>, ConsoleCommandSender>) {
        command.toKotlinCommand().register()
    }

    @JvmName("consoleRegister4")
    inline fun <reified A, reified B, reified C, reified D> register(command: Command<Arguments.Four<A, B, C, D>, ConsoleCommandSender>) {
        command.toKotlinCommand().register()
    }

    @JvmName("consoleRegister5")
    inline fun <reified A, reified B, reified C, reified D, reified E> register(command: Command<Arguments.Five<A, B, C, D, E>, ConsoleCommandSender>) {
        command.toKotlinCommand().register()
    }

    @JvmName("consoleRegister6")
    inline fun <reified A, reified B, reified C, reified D, reified E, reified F> register(command: Command<Arguments.Six<A, B, C, D, E, F>, ConsoleCommandSender>) {
        command.toKotlinCommand().register()
    }

    @JvmName("consoleRegister7")
    inline fun <reified A, reified B, reified C, reified D, reified E, reified F, reified G> register(command: Command<Arguments.Seven<A, B, C, D, E, F, G>, ConsoleCommandSender>) {
        command.toKotlinCommand().register()
    }

    @JvmName("consoleRegister8")
    inline fun <reified A, reified B, reified C, reified D, reified E, reified F, reified G, reified H> register(command: Command<Arguments.Eight<A, B, C, D, E, F, G, H>, ConsoleCommandSender>) {
        command.toKotlinCommand().register()
    }

    companion object {
        val listener = event<InventoryClickEvent> {
            GUI.directory.forEach {
                if (it.spigot == clickedInventory) {
                    it.onClick.forEach { entry ->
                        if (slot == entry.key) {
                            isCancelled = true
                            entry.value(OnClickEvent(click, whoClicked as Player))
                        }
                    }
                }
            }
        }
    }
}