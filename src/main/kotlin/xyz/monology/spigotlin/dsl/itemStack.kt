package xyz.monology.spigotlin.dsl

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack


class ItemDsl {
    var material = Material.DIRT
    var title = "Item"
    var count = 1
    var isUnbreakable = false
    val enchantments = mutableListOf<Triple<Enchantment, Int, Boolean>>()

    inner class EnchantmentDSL {
        operator fun Triple<Enchantment, Int, Boolean>.unaryPlus() {
            enchantments.add(this)
        }
    }

    fun enchantments(block: (EnchantmentDSL) -> Unit) {
        EnchantmentDSL().apply(block)
    }

    fun toItemStack(): ItemStack {
        return ItemStack(material, count).apply {
            val meta = itemMeta ?: Bukkit.getItemFactory().getItemMeta(type) ?: return@apply
            meta.setDisplayName(title)
            meta.isUnbreakable = isUnbreakable
            this@ItemDsl.enchantments.forEach {
                meta.addEnchant(it.first, it.second, it.third)
            }
        }
    }

    infix fun Pair<Enchantment, Int>.to(third: Boolean): Triple<Enchantment, Int, Boolean> {
        return Triple(first, second, third)
    }
}

inline fun item(block: ItemDsl.() -> Unit): ItemStack {
    return ItemDsl().apply(block).toItemStack()
}

infix fun Pair<Enchantment, Int>.to(third: Boolean): Triple<Enchantment, Int, Boolean> {
    return Triple(first, second, third)
}

fun item(title: String = "Item", material: Material = Material.DIRT, isUnbreakable: Boolean = false, count: Int = 1, vararg enchantments: Triple<Enchantment, Int, Boolean>): ItemStack {
    return item {
        this.title = title
        this.material = material
        this.isUnbreakable = isUnbreakable
        this.count = count
        this.enchantments.addAll(enchantments)
    }
}