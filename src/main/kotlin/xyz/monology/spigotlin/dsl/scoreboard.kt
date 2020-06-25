package xyz.monology.spigotlin.dsl

import org.bukkit.Bukkit
import org.bukkit.scoreboard.*
import org.bukkit.scoreboard.Team.OptionStatus

class ScoreboardDSL {
    val scoreboard = Bukkit.getServer().scoreboardManager!!.newScoreboard

    fun resetScores(string: String) = scoreboard.resetScores(string)

    fun add(
        name: String,
        criteria: String,
        displayName: String,
        renderType: RenderType
    ): Objective? {
        return scoreboard.registerNewObjective(name, criteria, displayName, renderType)
    }

    fun getDisplaySlot(displaySlot: DisplaySlot): Objective? {
        return scoreboard.getObjective(displaySlot)
    }

    fun getName(name: String): Objective? {
        return scoreboard.getObjective(name)
    }

    fun getCriteria(criteria: String): Set<Objective> {
        return scoreboard.getObjectivesByCriteria(criteria)
    }

    val objectives: Set<Objective> = scoreboard.objectives

    fun getScores(entry: String): Set<Score> {
        return scoreboard.getScores(entry)
    }

    fun getTeam(entry: String): Team? {
        return scoreboard.getEntryTeam(entry)
    }

    val teams: Set<Team> get() = scoreboard.teams

    val entries: Set<String> get() = scoreboard.entries

    inner class TeamDSL(val name: String) {
        private val team = scoreboard.registerNewTeam(name)

        var displayName
            get() = team.displayName
            set(value) {
                team.displayName = value
            }

        var prefix
            get() = team.prefix
            set(value) {
                team.prefix = value
            }

        var suffix
            get() = team.suffix
            set(value) {
                team.suffix = value
            }

        var color
            get() = team.color
            set(value) {
                team.color = value
            }

        var isFriendlyFireEnabled
            get() = team.allowFriendlyFire()
            set(value) {
                team.setAllowFriendlyFire(value)
            }

        var canSeeInvisibleTeammates
            get() = team.canSeeFriendlyInvisibles()
            set(value) {
                team.setCanSeeFriendlyInvisibles(value)
            }

        inner class Entries(private val team: Team) : MutableSet<String> {
            override fun add(element: String): Boolean {
                if (contains(element)) return false
                team.addEntry(element)
                return true
            }

            override fun addAll(elements: Collection<String>): Boolean {
                var ret = true
                elements.forEach {
                    if (!add(it)) ret = false
                }
                return ret
            }

            override fun clear() {
                team.entries.forEach {
                    team.removeEntry(it)
                }
            }

            override fun iterator(): MutableIterator<String> {
                return team.entries.iterator()
            }

            override fun remove(element: String): Boolean {
                return team.removeEntry(element)
            }

            override fun removeAll(elements: Collection<String>): Boolean {
                var ret = true
                elements.forEach {
                    if (!remove(it)) ret = false
                }
                return ret
            }

            override fun retainAll(elements: Collection<String>): Boolean {
                elements.filter(this::contains).apply {
                    if (size == 0) return false
                    forEach {
                        this@Entries.remove(it)
                    }
                }
                return true
            }

            override val size get() = team.entries.size

            override fun contains(element: String): Boolean {
                return team.hasEntry(element)
            }

            override fun containsAll(elements: Collection<String>): Boolean {
                elements.forEach {
                    if (!contains(it)) return false
                }
                return true
            }

            override fun isEmpty(): Boolean {
                return size == 0
            }

            operator fun get(option: Team.Option): OptionStatus {
                return team.getOption(option)
            }

            operator fun set(option: Team.Option, status: OptionStatus) {
                team.setOption(option, status)
            }
        }

        val entries = Entries(team)
    }

    fun team(name: String, block: TeamDSL.() -> Unit) = TeamDSL(name).block()
}

fun scoreboard(block: ScoreboardDSL.() -> Unit): Scoreboard {
    return ScoreboardDSL().apply(block).scoreboard
}