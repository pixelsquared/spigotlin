package xyz.monology.spigotlin.utils

import org.bukkit.*
import org.bukkit.advancement.Advancement
import org.bukkit.attribute.Attribute
import org.bukkit.block.data.BlockData
import org.bukkit.conversations.Conversation
import org.bukkit.conversations.ConversationAbandonedEvent
import org.bukkit.entity.*
import org.bukkit.entity.memory.MemoryKey
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.player.PlayerTeleportEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryView
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.Merchant
import org.bukkit.map.MapView
import org.bukkit.metadata.MetadataValue
import org.bukkit.permissions.Permission
import org.bukkit.permissions.PermissionAttachment
import org.bukkit.plugin.Plugin
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scoreboard.Scoreboard
import org.bukkit.util.Vector
import xyz.monology.spigotlin.gui.GUI

fun Player.openGui(gui: GUI) = openInventory(gui.spigot)

fun OnlinePlayers.openGui(gui: GUI) = openInventory(gui.spigot)

fun Player.msg(any: Any?) = sendMessage(any.toString())

fun OnlinePlayers.msg(any: Any?) = sendMessage(any.toString())

fun Player.msg(any: Array<Any?>?) {
    if (any == null) sendMessage(any.toString()) else any.forEach {
        sendMessage(it.toString())
    }
}

fun OnlinePlayers.msg(any: Array<Any?>?) {
    if (any == null) sendMessage(any.toString()) else any.forEach {
        sendMessage(it.toString())
    }
}

val onlinePlayers: Collection<Player> get() = Bukkit.getOnlinePlayers()

object OnlinePlayers {
    fun setFireTicks(ticks: Int) = onlinePlayers.forEach {
        it.fireTicks = ticks
    }

    fun setTotalExperience(exp: Int) = onlinePlayers.forEach {
        it.totalExperience = exp
    }

    fun getLastDamage() = onlinePlayers.map {
        it to it.lastDamage
    }.toMap()

    fun performCommand(command: String) = onlinePlayers.map {
        it to it.performCommand(command)
    }.toMap()

    fun setPassenger(passenger: Entity) = onlinePlayers.map {
        it to it.setPassenger(passenger)
    }.toMap()

    fun getClientViewDistance() = onlinePlayers.map {
        it to it.clientViewDistance
    }.toMap()

    fun chat(msg: String) = onlinePlayers.forEach {
        it.chat(msg)
    }

    fun getMetadata(metadataKey: String) = onlinePlayers.map {
        it to it.getMetadata(metadataKey)
    }.toMap()

    fun hasPotionEffect(type: PotionEffectType) = onlinePlayers.map {
        it to it.hasPotionEffect(type)
    }.toMap()

    fun openMerchant(trader: Villager, force: Boolean) = onlinePlayers.map {
        it to it.openMerchant(trader, force)
    }.toMap()

    fun openMerchant(merchant: Merchant, force: Boolean) = onlinePlayers.map {
        it to it.openMerchant(merchant, force)
    }.toMap()

    fun getBedLocation() = onlinePlayers.map {
        it to it.bedLocation
    }.toMap()

    fun getListeningPluginChannels() = onlinePlayers.map {
        it to it.listeningPluginChannels
    }.toMap()

    fun setAllowFlight(flight: Boolean) = onlinePlayers.forEach {
        it.allowFlight = flight
    }

    fun abandonConversation(conversation: Conversation) = onlinePlayers.forEach {
        it.abandonConversation(conversation)
    }

    fun abandonConversation(conversation: Conversation, details: ConversationAbandonedEvent) = onlinePlayers.forEach {
        it.abandonConversation(conversation, details)
    }

    fun getVehicle() = onlinePlayers.map {
        it to it.vehicle
    }.toMap()

    fun stopSound(sound: Sound) = onlinePlayers.forEach {
        it.stopSound(sound)
    }

    fun stopSound(sound: String) = onlinePlayers.forEach {
        it.stopSound(sound)
    }

    fun stopSound(sound: Sound, category: SoundCategory?) = onlinePlayers.forEach {
        it.stopSound(sound, category)
    }

    fun stopSound(sound: String, category: SoundCategory?) = onlinePlayers.forEach {
        it.stopSound(sound, category)
    }

    fun updateInventory() = onlinePlayers.forEach {
        it.updateInventory()
    }

    fun spigot() = onlinePlayers.map {
        it to it.spigot()
    }.toMap()

    fun getLocation() = onlinePlayers.map {
        it to it.location
    }.toMap()

    fun getLocation(loc: Location?) = onlinePlayers.map {
        it to it.getLocation(loc)
    }.toMap()

    fun getEnderChest() = onlinePlayers.map {
        it to it.enderChest
    }.toMap()

    fun getHeight() = onlinePlayers.map {
        it to it.height
    }.toMap()

    fun isBlocking() = onlinePlayers.map {
        it to it.isBlocking
    }.toMap()

    fun undiscoverRecipes(recipes: MutableCollection<NamespacedKey>) = onlinePlayers.map {
        it to it.undiscoverRecipes(recipes)
    }.toMap()

    fun setMetadata(metadataKey: String, newMetadataValue: MetadataValue) = onlinePlayers.forEach {
        it.setMetadata(metadataKey, newMetadataValue)
    }

    fun isSleepingIgnored() = onlinePlayers.map {
        it to it.isSleepingIgnored
    }.toMap()

    fun isSleeping() = onlinePlayers.map {
        it to it.isSleeping
    }.toMap()

    fun resetMaxHealth() = onlinePlayers.forEach {
        it.resetMaxHealth()
    }

    fun getWalkSpeed() = onlinePlayers.map {
        it to it.walkSpeed
    }.toMap()

    fun showPlayer(player: Player) = onlinePlayers.forEach {
        it.showPlayer(player)
    }

    fun showPlayer(plugin: Plugin, player: Player) = onlinePlayers.forEach {
        it.showPlayer(plugin, player)
    }

    fun isGliding() = onlinePlayers.map {
        it to it.isGliding
    }.toMap()

    fun getStatistic(statistic: Statistic) = onlinePlayers.map {
        it to it.getStatistic(statistic)
    }.toMap()

    fun getStatistic(statistic: Statistic, material: Material) = onlinePlayers.map {
        it to it.getStatistic(statistic, material)
    }.toMap()

    fun getStatistic(statistic: Statistic, entityType: EntityType) = onlinePlayers.map {
        it to it.getStatistic(statistic, entityType)
    }.toMap()

    fun getCanPickupItems() = onlinePlayers.map {
        it to it.canPickupItems
    }.toMap()

    fun wakeup(setSpawnLocation: Boolean) = onlinePlayers.forEach {
        it.wakeup(setSpawnLocation)
    }

    fun setDisplayName(name: String?) = onlinePlayers.forEach {
        it.setDisplayName(name)
    }

    fun getCustomName() = onlinePlayers.map {
        it to it.customName
    }.toMap()

    fun getEyeHeight() = onlinePlayers.map {
        it to it.eyeHeight
    }.toMap()

    fun getEyeHeight(ignorePose: Boolean) = onlinePlayers.map {
        it to it.getEyeHeight(ignorePose)
    }.toMap()

    fun setItemInHand(item: ItemStack?) = onlinePlayers.forEach {
        it.setItemInHand(item)
    }

    fun getFlySpeed() = onlinePlayers.map {
        it to it.flySpeed
    }.toMap()

    fun setSwimming(swimming: Boolean) = onlinePlayers.forEach {
        it.isSwimming = swimming
    }

    fun hasCooldown(material: Material) = onlinePlayers.map {
        it to it.hasCooldown(material)
    }.toMap()

    fun discoverRecipe(recipe: NamespacedKey) = onlinePlayers.map {
        it to it.discoverRecipe(recipe)
    }.toMap()

    fun setSpectatorTarget(entity: Entity?) = onlinePlayers.forEach {
        it.spectatorTarget = entity
    }

    fun setRemainingAir(ticks: Int) = onlinePlayers.forEach {
        it.remainingAir = ticks
    }

    fun hasPlayedBefore() = onlinePlayers.map {
        it to it.hasPlayedBefore()
    }.toMap()

    fun sendTitle(title: String?, subtitle: String?) = onlinePlayers.forEach {
        it.sendTitle(title, subtitle)
    }

    fun sendTitle(title: String?, subtitle: String?, fadeIn: Int, stay: Int, fadeOut: Int) = onlinePlayers.forEach {
        it.sendTitle(title, subtitle, fadeIn, stay, fadeOut)
    }

    fun setAbsorptionAmount(amount: Double) = onlinePlayers.forEach {
        it.absorptionAmount = amount
    }

    fun openEnchanting(location: Location?, force: Boolean) = onlinePlayers.map {
        it to it.openEnchanting(location, force)
    }.toMap()

    fun sleep(location: Location, force: Boolean) = onlinePlayers.map {
        it to it.sleep(location, force)
    }.toMap()

    fun getLastPlayed() = onlinePlayers.map {
        it to it.lastPlayed
    }.toMap()

    fun isValid() = onlinePlayers.map {
        it to it.isValid
    }.toMap()

    fun giveExpLevels(amount: Int) = onlinePlayers.forEach {
        it.giveExpLevels(amount)
    }

    fun playNote(loc: Location, instrument: Byte, note: Byte) = onlinePlayers.forEach {
        it.playNote(loc, instrument, note)
    }

    fun playNote(loc: Location, instrument: Instrument, note: Note) = onlinePlayers.forEach {
        it.playNote(loc, instrument, note)
    }

    fun setPlayerTime(time: Long, relative: Boolean) = onlinePlayers.forEach {
        it.setPlayerTime(time, relative)
    }

    fun getAttackCooldown() = onlinePlayers.map {
        it to it.attackCooldown
    }.toMap()

    fun getItemOnCursor() = onlinePlayers.map {
        it to it.itemOnCursor
    }.toMap()

    fun isPersistent() = onlinePlayers.map {
        it to it.isPersistent
    }.toMap()

    fun setShoulderEntityLeft(entity: Entity) = onlinePlayers.forEach {
        it.setShoulderEntityLeft(entity)
    }

    fun setPlayerListHeader(header: String?) = onlinePlayers.forEach {
        it.playerListHeader = header
    }

    fun setWalkSpeed(value: Float) = onlinePlayers.forEach {
        it.walkSpeed = value
    }

    fun setExhaustion(value: Float) = onlinePlayers.forEach {
        it.exhaustion = value
    }

    fun setHealthScaled(scale: Boolean) = onlinePlayers.forEach {
        it.isHealthScaled = scale
    }

    fun setSilent(flag: Boolean) = onlinePlayers.forEach {
        it.isSilent = flag
    }

    fun setStatistic(statistic: Statistic, newValue: Int) = onlinePlayers.forEach {
        it.setStatistic(statistic, newValue)
    }

    fun setStatistic(statistic: Statistic, material: Material, newValue: Int) = onlinePlayers.forEach {
        it.setStatistic(statistic, material, newValue)
    }

    fun setStatistic(statistic: Statistic, entityType: EntityType, newValue: Int) = onlinePlayers.forEach {
        it.setStatistic(statistic, entityType, newValue)
    }

    fun setWindowProperty(prop: InventoryView.Property, value: Int) = onlinePlayers.map {
        it to it.setWindowProperty(prop, value)
    }.toMap()

    fun getFallDistance() = onlinePlayers.map {
        it to it.fallDistance
    }.toMap()

    fun setFlySpeed(value: Float) = onlinePlayers.forEach {
        it.flySpeed = value
    }

    fun setOp(value: Boolean) = onlinePlayers.forEach {
        it.isOp = value
    }

    fun setRemoveWhenFarAway(remove: Boolean) = onlinePlayers.forEach {
        it.removeWhenFarAway = remove
    }

    fun setSneaking(sneak: Boolean) = onlinePlayers.forEach {
        it.isSneaking = sneak
    }

    fun setScoreboard(scoreboard: Scoreboard) = onlinePlayers.forEach {
        it.scoreboard = scoreboard
    }

    fun teleport(location: Location) = onlinePlayers.map {
        it to it.teleport(location)
    }.toMap()

    fun teleport(location: Location, cause: PlayerTeleportEvent.TeleportCause) = onlinePlayers.map {
        it to it.teleport(location, cause)
    }.toMap()

    fun teleport(destination: Entity) = onlinePlayers.map {
        it to it.teleport(destination)
    }.toMap()

    fun teleport(destination: Entity, cause: PlayerTeleportEvent.TeleportCause) = onlinePlayers.map {
        it to it.teleport(destination, cause)
    }.toMap()

    fun setLeashHolder(holder: Entity?) = onlinePlayers.map {
        it to it.setLeashHolder(holder)
    }.toMap()

    fun getExp() = onlinePlayers.map {
        it to it.exp
    }.toMap()

    fun acceptConversationInput(input: String) = onlinePlayers.forEach {
        it.acceptConversationInput(input)
    }

    fun getNoDamageTicks() = onlinePlayers.map {
        it to it.noDamageTicks
    }.toMap()

    fun <T : Any?> getMemory(memoryKey: MemoryKey<T>) = onlinePlayers.map {
        it to it.getMemory(memoryKey)
    }.toMap()

    fun setFallDistance(distance: Float) = onlinePlayers.forEach {
        it.fallDistance = distance
    }

    fun setNoDamageTicks(ticks: Int) = onlinePlayers.forEach {
        it.noDamageTicks = ticks
    }

    fun sendRawMessage(message: String) = onlinePlayers.forEach {
        it.sendRawMessage(message)
    }

    fun setWhitelisted(value: Boolean) = onlinePlayers.forEach {
        it.setWhitelisted(value)
    }

    fun isFlying() = onlinePlayers.map {
        it to it.isFlying
    }.toMap()

    fun sendChunkChange(loc: Location, sx: Int, sy: Int, sz: Int, data: ByteArray) = onlinePlayers.map {
        it to it.sendChunkChange(loc, sx, sy, sz, data)
    }.toMap()

    fun setGlowing(flag: Boolean) = onlinePlayers.forEach {
        it.isGlowing = flag
    }

    fun recalculatePermissions() = onlinePlayers.forEach {
        it.recalculatePermissions()
    }

    fun openBook(book: ItemStack) = onlinePlayers.forEach {
        it.openBook(book)
    }

    fun hasPermission(name: String) = onlinePlayers.map {
        it to it.hasPermission(name)
    }.toMap()

    fun hasPermission(perm: Permission) = onlinePlayers.map {
        it to it.hasPermission(perm)
    }.toMap()

    fun isOnline() = onlinePlayers.map {
        it to it.isOnline
    }.toMap()

    fun isCustomNameVisible() = onlinePlayers.map {
        it to it.isCustomNameVisible
    }.toMap()

    fun setPlayerWeather(type: WeatherType) = onlinePlayers.forEach {
        it.setPlayerWeather(type)
    }

    fun isEmpty() = onlinePlayers.map {
        it to it.isEmpty
    }.toMap()

    fun getSleepTicks() = onlinePlayers.map {
        it to it.sleepTicks
    }.toMap()

    fun getUniqueId() = onlinePlayers.map {
        it to it.uniqueId
    }.toMap()

    fun getInventory() = onlinePlayers.map {
        it to it.inventory
    }.toMap()

    fun getTicksLived() = onlinePlayers.map {
        it to it.ticksLived
    }.toMap()

    fun setFlying(value: Boolean) = onlinePlayers.forEach {
        it.isFlying = value
    }

    fun getEffectivePermissions() = onlinePlayers.map {
        it to it.effectivePermissions
    }.toMap()

    fun getOpenInventory() = onlinePlayers.map {
        it to it.openInventory
    }.toMap()

    fun getMaxHealth() = onlinePlayers.map {
        it to it.maxHealth
    }.toMap()

    fun getAttribute(attribute: Attribute) = onlinePlayers.map {
        it to it.getAttribute(attribute)
    }.toMap()

    fun getPlayerWeather() = onlinePlayers.map {
        it to it.playerWeather
    }.toMap()

    fun removeAttachment(attachment: PermissionAttachment) = onlinePlayers.forEach {
        it.removeAttachment(attachment)
    }

    fun isInvulnerable() = onlinePlayers.map {
        it to it.isInvulnerable
    }.toMap()

    fun spawnParticle(particle: Particle, location: Location, count: Int) = onlinePlayers.forEach {
        it.spawnParticle(particle, location, count)
    }

    fun spawnParticle(particle: Particle, x: Double, y: Double, z: Double, count: Int) = onlinePlayers.forEach {
        it.spawnParticle(particle, x, y, z, count)
    }

    fun <T : Any?> spawnParticle(particle: Particle, location: Location, count: Int, data: T?) = onlinePlayers.forEach {
        it.spawnParticle(particle, location, count, data)
    }

    fun <T : Any?> spawnParticle(particle: Particle, x: Double, y: Double, z: Double, count: Int, data: T?) =
        onlinePlayers.forEach {
            it.spawnParticle(particle, x, y, z, count, data)
        }

    fun spawnParticle(
        particle: Particle,
        location: Location,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double
    ) = onlinePlayers.forEach {
        it.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ)
    }

    fun spawnParticle(
        particle: Particle,
        x: Double,
        y: Double,
        z: Double,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double
    ) = onlinePlayers.forEach {
        it.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ)
    }

    fun <T : Any?> spawnParticle(
        particle: Particle,
        location: Location,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double,
        data: T?
    ) = onlinePlayers.forEach {
        it.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, data)
    }

    fun <T : Any?> spawnParticle(
        particle: Particle,
        x: Double,
        y: Double,
        z: Double,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double,
        data: T?
    ) = onlinePlayers.forEach {
        it.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, data)
    }

    fun spawnParticle(
        particle: Particle,
        location: Location,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double,
        extra: Double
    ) = onlinePlayers.forEach {
        it.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, extra)
    }

    fun spawnParticle(
        particle: Particle,
        x: Double,
        y: Double,
        z: Double,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double,
        extra: Double
    ) = onlinePlayers.forEach {
        it.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, extra)
    }

    fun <T : Any?> spawnParticle(
        particle: Particle,
        location: Location,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double,
        extra: Double,
        data: T?
    ) = onlinePlayers.forEach {
        it.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, extra, data)
    }

    fun <T : Any?> spawnParticle(
        particle: Particle,
        x: Double,
        y: Double,
        z: Double,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double,
        extra: Double,
        data: T?
    ) = onlinePlayers.forEach {
        it.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, extra, data)
    }

    fun closeInventory() = onlinePlayers.forEach {
        it.closeInventory()
    }

    fun sendSignChange(loc: Location, lines: Array<out String>?) = onlinePlayers.forEach {
        it.sendSignChange(loc, lines)
    }

    fun sendSignChange(loc: Location, lines: Array<out String>?, dyeColor: DyeColor) = onlinePlayers.forEach {
        it.sendSignChange(loc, lines, dyeColor)
    }

    fun undiscoverRecipe(recipe: NamespacedKey) = onlinePlayers.map {
        it to it.undiscoverRecipe(recipe)
    }.toMap()

    fun getExpToLevel() = onlinePlayers.map {
        it to it.expToLevel
    }.toMap()

    fun getSaturation() = onlinePlayers.map {
        it to it.saturation
    }.toMap()

    fun setHealth(health: Double) = onlinePlayers.forEach {
        it.health = health
    }

    fun getShoulderEntityLeft() = onlinePlayers.map {
        it to it.shoulderEntityLeft
    }.toMap()

    fun removeMetadata(metadataKey: String, owningPlugin: Plugin) = onlinePlayers.forEach {
        it.removeMetadata(metadataKey, owningPlugin)
    }

    fun getLastDamageCause() = onlinePlayers.map {
        it to it.lastDamageCause
    }.toMap()

    fun getPortalCooldown() = onlinePlayers.map {
        it to it.portalCooldown
    }.toMap()

    fun isConversing() = onlinePlayers.map {
        it to it.isConversing
    }.toMap()

    fun setMaximumAir(ticks: Int) = onlinePlayers.forEach {
        it.maximumAir = ticks
    }

    fun getLevel() = onlinePlayers.map {
        it to it.level
    }.toMap()

    fun setBedSpawnLocation(location: Location?) = onlinePlayers.forEach {
        it.bedSpawnLocation = location
    }

    fun setBedSpawnLocation(location: Location?, force: Boolean) = onlinePlayers.forEach {
        it.setBedSpawnLocation(location, force)
    }

    fun isPermissionSet(name: String) = onlinePlayers.map {
        it to it.isPermissionSet(name)
    }.toMap()

    fun isPermissionSet(perm: Permission) = onlinePlayers.map {
        it to it.isPermissionSet(perm)
    }.toMap()

    fun getPassenger() = onlinePlayers.map {
        it to it.passenger
    }.toMap()

    fun remove() = onlinePlayers.forEach {
        it.remove()
    }

    fun setMaxHealth(health: Double) = onlinePlayers.forEach {
        it.maxHealth = health
    }

    fun setTexturePack(url: String) = onlinePlayers.forEach {
        it.setTexturePack(url)
    }

    fun setTicksLived(value: Int) = onlinePlayers.forEach {
        it.ticksLived = value
    }

    fun hasMetadata(metadataKey: String) = onlinePlayers.map {
        it to it.hasMetadata(metadataKey)
    }.toMap()

    fun getVelocity() = onlinePlayers.map {
        it to it.velocity
    }.toMap()

    fun getScoreboard() = onlinePlayers.map {
        it to it.scoreboard
    }.toMap()

    fun playEffect(loc: Location, effect: Effect, data: Int) = onlinePlayers.forEach {
        it.playEffect(loc, effect, data)
    }

    fun <T> playEffect(loc: Location, effect: Effect, data: T?) = onlinePlayers.forEach {
        it.playEffect(loc, effect, data)
    }

    fun playEffect(type: EntityEffect) = onlinePlayers.forEach {
        it.playEffect(type)
    }

    fun setSaturation(value: Float) = onlinePlayers.forEach {
        it.saturation = value
    }

    fun resetPlayerTime() = onlinePlayers.forEach {
        it.resetPlayerTime()
    }

    fun getServer() = onlinePlayers.map {
        it to it.server
    }.toMap()

    fun hasAI() = onlinePlayers.map {
        it to it.hasAI()
    }.toMap()

    fun hidePlayer(player: Player) = onlinePlayers.forEach {
        it.hidePlayer(player)
    }

    fun hidePlayer(plugin: Plugin, player: Player) = onlinePlayers.forEach {
        it.hidePlayer(plugin, player)
    }

    fun getPlayerListHeader() = onlinePlayers.map {
        it to it.playerListHeader
    }.toMap()

    fun getEyeLocation() = onlinePlayers.map {
        it to it.eyeLocation
    }.toMap()

    fun kickPlayer(message: String?) = onlinePlayers.forEach {
        it.kickPlayer(message)
    }

    fun addPotionEffects(effects: MutableCollection<PotionEffect>) = onlinePlayers.map {
        it to it.addPotionEffects(effects)
    }.toMap()

    fun attack(target: Entity) = onlinePlayers.forEach {
        it.attack(target)
    }

    fun isCollidable() = onlinePlayers.map {
        it to it.isCollidable
    }.toMap()

    fun getAbsorptionAmount() = onlinePlayers.map {
        it to it.absorptionAmount
    }.toMap()

    fun discoverRecipes(recipes: MutableCollection<NamespacedKey>) = onlinePlayers.map {
        it to it.discoverRecipes(recipes)
    }.toMap()

    fun isWhitelisted() = onlinePlayers.map {
        it to it.isWhitelisted
    }.toMap()

    fun setCompassTarget(loc: Location) = onlinePlayers.forEach {
        it.compassTarget = loc
    }

    fun getCompassTarget() = onlinePlayers.map {
        it to it.compassTarget
    }.toMap()

    fun getPlayerTimeOffset() = onlinePlayers.map {
        it to it.playerTimeOffset
    }.toMap()

    fun isOnGround() = onlinePlayers.map {
        it to it.isOnGround
    }.toMap()

    fun eject() = onlinePlayers.map {
        it to it.eject()
    }.toMap()

    fun getTotalExperience() = onlinePlayers.map {
        it to it.totalExperience
    }.toMap()

    fun openInventory(inventory: Inventory) = onlinePlayers.map {
        it to it.openInventory(inventory)
    }.toMap()

    fun openInventory(inventory: InventoryView) = onlinePlayers.forEach {
        it.openInventory(inventory)
    }

    fun isSprinting() = onlinePlayers.map {
        it to it.isSprinting
    }.toMap()

    fun setLastDamage(damage: Double) = onlinePlayers.forEach {
        it.lastDamage = damage
    }

    fun getPotionEffect(type: PotionEffectType) = onlinePlayers.map {
        it to it.getPotionEffect(type)
    }.toMap()

    fun isRiptiding() = onlinePlayers.map {
        it to it.isRiptiding
    }.toMap()

    fun isInsideVehicle() = onlinePlayers.map {
        it to it.isInsideVehicle
    }.toMap()

    fun setPortalCooldown(cooldown: Int) = onlinePlayers.forEach {
        it.portalCooldown = cooldown
    }

    fun setGravity(gravity: Boolean) = onlinePlayers.forEach {
        it.setGravity(gravity)
    }

    fun setCooldown(material: Material, ticks: Int) = onlinePlayers.forEach {
        it.setCooldown(material, ticks)
    }

    fun getNearbyEntities(x: Double, y: Double, z: Double): Map<Player, List<Entity>> = onlinePlayers.map {
        it to it.getNearbyEntities(x, y, z)
    }.toMap()

    fun loadData() = onlinePlayers.forEach {
        it.loadData()
    }

    fun sendMessage(message: String) = onlinePlayers.forEach {
        it.sendMessage(message)
    }

    fun sendMessage(messages: Array<out String>) = onlinePlayers.forEach {
        it.sendMessage(messages)
    }

    fun sendBlockChange(loc: Location, material: Material, data: Byte) = onlinePlayers.forEach {
        it.sendBlockChange(loc, material, data)
    }

    fun sendBlockChange(loc: Location, block: BlockData) = onlinePlayers.forEach {
        it.sendBlockChange(loc, block)
    }

    fun setSleepingIgnored(isSleeping: Boolean) = onlinePlayers.forEach {
        it.isSleepingIgnored = isSleeping
    }

    fun sendExperienceChange(progress: Float) = onlinePlayers.forEach {
        it.sendExperienceChange(progress)
    }

    fun sendExperienceChange(progress: Float, level: Int) = onlinePlayers.forEach {
        it.sendExperienceChange(progress, level)
    }

    fun addAttachment(plugin: Plugin, name: String, value: Boolean) = onlinePlayers.map {
        it to it.addAttachment(plugin, name, value)
    }.toMap()

    fun addAttachment(plugin: Plugin) = onlinePlayers.map {
        it to it.addAttachment(plugin)
    }.toMap()

    fun addAttachment(plugin: Plugin, name: String, value: Boolean, ticks: Int) = onlinePlayers.map {
        it to it.addAttachment(plugin, name, value, ticks)
    }.toMap()

    fun addAttachment(plugin: Plugin, ticks: Int) = onlinePlayers.map {
        it to it.addAttachment(plugin, ticks)
    }.toMap()

    fun getPose() = onlinePlayers.map {
        it to it.pose
    }.toMap()

    fun getBedSpawnLocation() = onlinePlayers.map {
        it to it.bedSpawnLocation
    }.toMap()

    fun resetPlayerWeather() = onlinePlayers.forEach {
        it.resetPlayerWeather()
    }

    fun giveExp(amount: Int) = onlinePlayers.forEach {
        it.giveExp(amount)
    }

    fun setSprinting(sprinting: Boolean) = onlinePlayers.forEach {
        it.isSprinting = sprinting
    }

    fun updateCommands() = onlinePlayers.forEach {
        it.updateCommands()
    }

    fun isGlowing() = onlinePlayers.map {
        it to it.isGlowing
    }.toMap()

    fun getGameMode() = onlinePlayers.map {
        it to it.gameMode
    }.toMap()

    fun setShoulderEntityRight(entity: Entity) = onlinePlayers.forEach {
        it.shoulderEntityRight = entity
    }

    fun isHealthScaled() = onlinePlayers.map {
        it to it.isHealthScaled
    }.toMap()

    fun setAI(ai: Boolean) = onlinePlayers.forEach {
        it.setAI(ai)
    }

    fun decrementStatistic(statistic: Statistic) = onlinePlayers.forEach {
        it.decrementStatistic(statistic)
    }

    fun decrementStatistic(statistic: Statistic, amount: Int) = onlinePlayers.forEach {
        it.decrementStatistic(statistic, amount)
    }

    fun decrementStatistic(statistic: Statistic, material: Material) = onlinePlayers.forEach {
        it.decrementStatistic(statistic, material)
    }

    fun decrementStatistic(statistic: Statistic, material: Material, amount: Int) = onlinePlayers.forEach {
        it.decrementStatistic(statistic, material, amount)
    }

    fun decrementStatistic(statistic: Statistic, entityType: EntityType) = onlinePlayers.forEach {
        it.decrementStatistic(statistic, entityType)
    }

    fun decrementStatistic(statistic: Statistic, entityType: EntityType, amount: Int) = onlinePlayers.forEach {
        it.decrementStatistic(statistic, entityType, amount)
    }

    fun getAddress() = onlinePlayers.map {
        it to it.address
    }.toMap()

    fun getPersistentDataContainer() = onlinePlayers.map {
        it to it.persistentDataContainer
    }.toMap()

    fun getAllowFlight() = onlinePlayers.map {
        it to it.allowFlight
    }.toMap()

    fun getBoundingBox() = onlinePlayers.map {
        it to it.boundingBox
    }.toMap()

    fun getHealthScale() = onlinePlayers.map {
        it to it.healthScale
    }.toMap()

    fun canSee(player: Player) = onlinePlayers.map {
        it to it.canSee(player)
    }.toMap()

    fun playSound(location: Location, sound: Sound, volume: Float, pitch: Float) = onlinePlayers.forEach {
        it.playSound(location, sound, volume, pitch)
    }

    fun playSound(location: Location, sound: String, volume: Float, pitch: Float) = onlinePlayers.forEach {
        it.playSound(location, sound, volume, pitch)
    }

    fun playSound(location: Location, sound: Sound, category: SoundCategory, volume: Float, pitch: Float) = onlinePlayers.forEach {
        it.playSound(location, sound, category, volume, pitch)
    }

    fun playSound(location: Location, sound: String, category: SoundCategory, volume: Float, pitch: Float) = onlinePlayers.forEach {
        it.playSound(location, sound, category, volume, pitch)
    }

    fun getEquipment() = onlinePlayers.map {
        it to it.equipment
    }.toMap()

    fun getTargetBlock(transparent: MutableSet<Material>?, maxDistance: Int) = onlinePlayers.map {
        it to it.getTargetBlock(transparent, maxDistance)
    }.toMap()

    fun setItemOnCursor(item: ItemStack?) = onlinePlayers.forEach {
        it.setItemOnCursor(item)
    }

    fun setCustomNameVisible(flag: Boolean) = onlinePlayers.forEach {
        it.isCustomNameVisible = flag
    }

    fun <T : Projectile?> launchProjectile(projectile: Class<out T>) = onlinePlayers.map {
        it to it.launchProjectile(projectile)
    }.toMap()

    fun <T : Projectile?> launchProjectile(projectile: Class<out T>, velocity: Vector?) = onlinePlayers.map {
        it to it.launchProjectile(projectile, velocity)
    }.toMap()

    fun isBanned() = onlinePlayers.map {
        it to it.isBanned
    }.toMap()

    fun sendPluginMessage(source: Plugin, channel: String, message: ByteArray) = onlinePlayers.forEach {
        it.sendPluginMessage(source, channel, message)
    }

    fun isSneaking() = onlinePlayers.map {
        it to it.isSneaking
    }.toMap()

    fun getMaximumAir() = onlinePlayers.map {
        it to it.maximumAir
    }.toMap()

    fun isOp() = onlinePlayers.map {
        it to it.isOp
    }.toMap()

    fun getLocale() = onlinePlayers.map {
        it to it.locale
    }.toMap()

    fun setRotation(yaw: Float, pitch: Float) = onlinePlayers.forEach {
        it.setRotation(yaw, pitch)
    }

    fun getPistonMoveReaction() = onlinePlayers.map {
        it to it.pistonMoveReaction
    }.toMap()

    fun addPassenger(passenger: Entity) = onlinePlayers.map {
        it to it.addPassenger(passenger)
    }.toMap()

    fun getExhaustion() = onlinePlayers.map {
        it to it.exhaustion
    }.toMap()

    fun setExp(exp: Float) = onlinePlayers.forEach {
        it.exp = exp
    }

    fun getLineOfSight(transparent: MutableSet<Material>?, maxDistance: Int) = onlinePlayers.map {
        it to it.getLineOfSight(transparent, maxDistance)
    }.toMap()

    fun setPlayerListHeaderFooter(header: String?, footer: String?) = onlinePlayers.forEach {
        it.setPlayerListHeaderFooter(header, footer)
    }

    fun getPlayerTime() = onlinePlayers.map {
        it to it.playerTime
    }.toMap()

    fun getLeashHolder() = onlinePlayers.map {
        it to it.leashHolder
    }.toMap()

    fun isHandRaised() = onlinePlayers.map {
        it to it.isHandRaised
    }.toMap()

    fun getCooldown(material: Material) = onlinePlayers.map {
        it to it.getCooldown(material)
    }.toMap()

    fun getSpectatorTarget() = onlinePlayers.map {
        it to it.spectatorTarget
    }.toMap()

    fun getType() = onlinePlayers.map {
        it to it.type
    }.toMap()

    fun getPlayer() = onlinePlayers.map {
        it to it.player
    }.toMap()

    fun getScoreboardTags() = onlinePlayers.map {
        it to it.scoreboardTags
    }.toMap()

    fun saveData() = onlinePlayers.forEach {
        it.saveData()
    }

    fun setCustomName(name: String?) = onlinePlayers.forEach {
        it.customName = name
    }

    fun incrementStatistic(statistic: Statistic) = onlinePlayers.forEach {
        it.incrementStatistic(statistic)
    }

    fun incrementStatistic(statistic: Statistic, amount: Int) = onlinePlayers.forEach {
        it.incrementStatistic(statistic, amount)
    }

    fun incrementStatistic(statistic: Statistic, material: Material) = onlinePlayers.forEach {
        it.incrementStatistic(statistic, material)
    }

    fun incrementStatistic(statistic: Statistic, material: Material, amount: Int) = onlinePlayers.forEach {
        it.incrementStatistic(statistic, amount)
    }

    fun incrementStatistic(statistic: Statistic, entityType: EntityType) = onlinePlayers.forEach {
        it.incrementStatistic(statistic, entityType)
    }

    fun incrementStatistic(statistic: Statistic, entityType: EntityType, amount: Int) = onlinePlayers.forEach {
        it.incrementStatistic(statistic, amount)
    }

    fun isPlayerTimeRelative() = onlinePlayers.map {
        it to it.isPlayerTimeRelative
    }.toMap()

    fun removeScoreboardTag(tag: String) = onlinePlayers.map {
        it to it.removeScoreboardTag(tag)
    }.toMap()

    fun getActivePotionEffects() = onlinePlayers.map {
        it to it.activePotionEffects
    }.toMap()

    fun getLastTwoTargetBlocks(transparent: MutableSet<Material>?, maxDistance: Int) = onlinePlayers.map {
        it to it.getLastTwoTargetBlocks(transparent, maxDistance)
    }.toMap()

    fun serialize() = onlinePlayers.map {
        it to it.serialize()
    }.toMap()

    fun hasLineOfSight(other: Entity) = onlinePlayers.map {
        it to it.hasLineOfSight(other)
    }.toMap()

    fun setMaximumNoDamageTicks(ticks: Int) = onlinePlayers.forEach {
        it.maximumNoDamageTicks = ticks
    }

    fun setPlayerListFooter(footer: String?) = onlinePlayers.forEach {
        it.playerListFooter = footer
    }

    fun getFacing() = onlinePlayers.map {
        it to it.facing
    }.toMap()

    fun hasGravity() = onlinePlayers.map {
        it to it.hasGravity()
    }.toMap()

    fun setCollidable(collidable: Boolean) = onlinePlayers.forEach {
        it.isCollidable = collidable
    }

    fun setCanPickupItems(pickup: Boolean) = onlinePlayers.forEach {
        it.canPickupItems = pickup
    }

    fun isDead() = onlinePlayers.map {
        it to it.isDead
    }.toMap()

    fun setGliding(gliding: Boolean) = onlinePlayers.forEach {
        it.isGliding = gliding
    }

    fun <T : Any?> setMemory(memoryKey: MemoryKey<T>, memoryValue: T?) = onlinePlayers.forEach {
        it.setMemory(memoryKey, memoryValue)
    }

    fun getRemainingAir() = onlinePlayers.map {
        it to it.remainingAir
    }.toMap()

    fun getAdvancementProgress(advancement: Advancement) = onlinePlayers.map {
        it to it.getAdvancementProgress(advancement)
    }.toMap()

    fun isLeashed() = onlinePlayers.map {
        it to it.isLeashed
    }.toMap()

    fun sendMap(map: MapView) = onlinePlayers.forEach {
        it.sendMap(map)
    }

    fun rayTraceBlocks(maxDistance: Double) = onlinePlayers.map {
        it to it.rayTraceBlocks(maxDistance)
    }.toMap()

    fun rayTraceBlocks(maxDistance: Double, fluidCollisionMode: FluidCollisionMode) = onlinePlayers.map {
        it to it.rayTraceBlocks(maxDistance, fluidCollisionMode)
    }.toMap()

    fun setLevel(level: Int) = onlinePlayers.forEach {
        it.level = level
    }

    fun setFoodLevel(value: Int) = onlinePlayers.forEach {
        it.foodLevel = value
    }

    fun getRemoveWhenFarAway() = onlinePlayers.map {
        it to it.removeWhenFarAway
    }.toMap()

    fun beginConversation(conversation: Conversation) = onlinePlayers.map {
        it to it.beginConversation(conversation)
    }.toMap()

    fun removePassenger(passenger: Entity) = onlinePlayers.map {
        it to it.removePassenger(passenger)
    }.toMap()

    fun setPersistent(persistent: Boolean) = onlinePlayers.forEach {
        it.isPersistent = persistent
    }

    fun getMainHand() = onlinePlayers.map {
        it to it.mainHand
    }.toMap()

    fun getShoulderEntityRight() = onlinePlayers.map {
        it to it.shoulderEntityRight
    }.toMap()

    fun swingMainHand() = onlinePlayers.forEach {
        it.swingMainHand()
    }

    fun getPlayerListFooter() = onlinePlayers.map {
        it to it.playerListFooter
    }.toMap()

    fun getPlayerListName() = onlinePlayers.map {
        it to it.playerListName
    }.toMap()

    fun setGameMode(mode: GameMode) = onlinePlayers.forEach {
        it.gameMode = mode
    }

    fun getName() = onlinePlayers.map {
        it to it.name
    }.toMap()

    fun getKiller() = onlinePlayers.map {
        it to it.killer
    }.toMap()

    fun getItemInHand() = onlinePlayers.map {
        it to it.itemInHand
    }.toMap()

    fun getFoodLevel() = onlinePlayers.map {
        it to it.foodLevel
    }.toMap()

    fun getTargetBlockExact(maxDistance: Int) = onlinePlayers.map {
        it to it.getTargetBlockExact(maxDistance)
    }.toMap()

    fun getTargetBlockExact(maxDistance: Int, fluidCollisionMode: FluidCollisionMode) = onlinePlayers.map {
        it to it.getTargetBlockExact(maxDistance, fluidCollisionMode)
    }.toMap()

    fun getMaxFireTicks() = onlinePlayers.map {
        it to it.maxFireTicks
    }.toMap()

    fun setVelocity(velocity: Vector) = onlinePlayers.forEach {
        it.velocity = velocity
    }

    fun getPassengers() = onlinePlayers.map {
        it to it.passengers
    }.toMap()

    fun damage(amount: Double) = onlinePlayers.forEach {
        it.damage(amount)
    }

    fun damage(amount: Double, source: Entity?) = onlinePlayers.forEach {
        it.damage(amount, source)
    }

    fun setHealthScale(scale: Double) = onlinePlayers.forEach {
        it.healthScale = scale
    }

    fun getHealth() = onlinePlayers.map {
        it to it.health
    }.toMap()

    fun resetTitle() = onlinePlayers.forEach {
        it.resetTitle()
    }

    fun getWorld() = onlinePlayers.map {
        it to it.world
    }.toMap()

    fun swingOffHand() = onlinePlayers.forEach {
        it.swingOffHand()
    }

    fun setLastDamageCause(event: EntityDamageEvent?) = onlinePlayers.forEach {
        it.lastDamageCause = event
    }

    fun addScoreboardTag(tag: String) = onlinePlayers.map {
        it to it.addScoreboardTag(tag)
    }.toMap()

    fun getMaximumNoDamageTicks() = onlinePlayers.map {
        it to it.maximumNoDamageTicks
    }.toMap()

    fun setPlayerListName(name: String?) = onlinePlayers.forEach {
        it.setPlayerListName(name)
    }

    fun getEntityId() = onlinePlayers.map {
        it to it.entityId
    }.toMap()

    fun getFireTicks() = onlinePlayers.map {
        it to it.fireTicks
    }.toMap()

    fun getDisplayName() = onlinePlayers.map {
        it to it.displayName
    }.toMap()

    fun setResourcePack(url: String) = onlinePlayers.forEach {
        it.setResourcePack(url)
    }

    fun setResourcePack(url: String, hash: ByteArray) = onlinePlayers.forEach {
        it.setResourcePack(url, hash)
    }

    fun removePotionEffect(type: PotionEffectType) = onlinePlayers.forEach {
        it.removePotionEffect(type)
    }

    fun leaveVehicle() = onlinePlayers.map {
        it to it.leaveVehicle()
    }.toMap()

    fun isSilent() = onlinePlayers.map {
        it to it.isSilent
    }.toMap()

    fun getWidth() = onlinePlayers.map {
        it to it.width
    }.toMap()

    fun openWorkbench(location: Location?, force: Boolean) = onlinePlayers.map {
        it to it.openWorkbench(location, force)
    }.toMap()

    fun setInvulnerable(flag: Boolean) = onlinePlayers.forEach {
        it.isInvulnerable = flag
    }

    fun addPotionEffect(effect: PotionEffect) = onlinePlayers.map {
        it to it.addPotionEffect(effect)
    }.toMap()

    fun addPotionEffect(effect: PotionEffect, force: Boolean) = onlinePlayers.map {
        it to it.addPotionEffect(effect, force)
    }.toMap()

    fun getFirstPlayed() = onlinePlayers.map {
        it to it.firstPlayed
    }.toMap()

    fun isSwimming() = onlinePlayers.map {
        it to it.isSwimming
    }.toMap()

}