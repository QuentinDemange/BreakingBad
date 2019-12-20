package com.breakingbad.Model

import java.io.Serializable

data class Character(val id: Int, val name: String, val birthday: String, val img: String,
                     val status: String, val nickname: String, val portrayed: String,
                     val occupation: Array<String>, val appearance: Array<String>) : Serializable