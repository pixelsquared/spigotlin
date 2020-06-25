package xyz.monology.spigotlin.commands

class Word(private val string: String) : CharSequence {
    override val length = string.length

    override fun get(index: Int): Char {
        return string[index]
    }

    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
        return string.subSequence(startIndex, endIndex)
    }

    override fun toString(): String {
        return string
    }
}