import org.bukkit.Material
import org.bukkit.event.player.PlayerJoinEvent
import xyz.monology.spigotlin.KotlinPlugin
import xyz.monology.spigotlin.dsl.event
import xyz.monology.spigotlin.dsl.gui
import xyz.monology.spigotlin.dsl.item
import xyz.monology.spigotlin.utils.openGui

class MyPlugin : KotlinPlugin() {
    override fun enable() {
        event<PlayerJoinEvent> {
            player.openGui(gui("Welcome!", 3) {
                // GUI slots start at 1, not 0!
                this[2, 5] = item("Leave", Material.BARRIER)
            })
        }
    }
}