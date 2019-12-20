package com.breakingbad.Model

import java.io.Serializable

data class Character(val id: Int, val name: String, val birthday: String, val img: String,
                     val status: String, val nickname: String, val portrayed: String,
                     val occupation: Array<String>, val appearance: Array<String>) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Character

        if (!occupation.contentEquals(other.occupation)) return false
        if (!appearance.contentEquals(other.appearance)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = occupation.contentHashCode()
        result = 31 * result + appearance.contentHashCode()
        return result
    }
}