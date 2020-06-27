import org.bukkit.Material
import org.bukkit.event.player.PlayerJoinEvent
import xyz.monology.spigotlin.KotlinPlugin
import xyz.monology.spigotlin.dsl.event
import xyz.monology.spigotlin.dsl.gui
import xyz.monology.spigotlin.dsl.item
import xyz.monology.spigotlin.dsl.rowRange
import xyz.monology.spigotlin.utils.colored
import xyz.monology.spigotlin.utils.openGui

class MyPlugin : KotlinPlugin() {
    override fun enable() {
        event<PlayerJoinEvent> {
            player.openGui(gui("Welcome!", 3) {
                // GUI slots start at 1, not 0!
                this[2, 5] = item("Leave", Material.BARRIER).onClick {
                    player.kickPlayer("&bWell, you asked to leave!".colored)
                }

                fill(item("&8Please select a button.", Material.GRAY_STAINED_GLASS_PANE))

                this[rowRange(3, 1, 9)] = item("Close the menu.").onClick {
                    player.closeInventory()
                }
            })
        }
    }
}