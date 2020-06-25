package xyz.monology.spigotlin.dsl

import org.bukkit.event.Event
import org.bukkit.event.EventPriority

inline fun <reified T : Event> event(
    priority: EventPriority = EventPriority.NORMAL,
    crossinline block: T.() -> Unit
) = Pair<EventPriority, T.() -> Unit>(priority) {
    block()
}