package xyz.monology.spigotlin.utils

val Byte.ordinal: String
    get() = if (this in 10..20) toString() + "th" else (this % 10).run {
        this@ordinal.toString() + when (this) {
            1 -> "st"
            2 -> "nd"
            3 -> "rd"
            else -> "th"
        }
    }

val Short.ordinal: String
    get() = if (this in 10..20) toString() + "th" else (this % 10).run {
        this@ordinal.toString() + when (this) {
            1 -> "st"
            2 -> "nd"
            3 -> "rd"
            else -> "th"
        }
    }

val Int.ordinal: String
    get() = if (this in 10..20) toString() + "th" else (this % 10).run {
        this@ordinal.toString() + when (this) {
            1 -> "st"
            2 -> "nd"
            3 -> "rd"
            else -> "th"
        }
    }

val Long.ordinal: String
    get() = if (this in 10..20) toString() + "th" else (this % 10).run {
        this@ordinal.toString() + when (this) {
            1L -> "st"
            2L -> "nd"
            3L -> "rd"
            else -> "th"
        }
    }

fun String.plural(num: Int, plural: String = (if (this.endsWith("s")) this + "es" else this + "s")): String {
    return if (num == 1) this else plural
}

val Long.seconds get() = this * 20
val Long.minutes get() = seconds * 60
val Long.hours get() = minutes * 60
val Long.days get() = hours * 24
val Long.weeks get() = days * 7
val Long.months get() = days * 30
val Long.years get() = days * 365

val Int.seconds get() = this * 20L
val Int.minutes get() = seconds * 60L
val Int.hours get() = minutes * 60L
val Int.days get() = hours * 24L
val Int.weeks get() = days * 7L
val Int.months get() = days * 30L
val Int.years get() = days * 365L
