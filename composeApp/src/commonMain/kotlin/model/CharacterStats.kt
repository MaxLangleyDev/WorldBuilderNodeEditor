package model

import kotlinx.serialization.Serializable

@Serializable
data class CharacterStats(
    val health: Int = 0,
    val mana: Int = 0,
    val stamina: Int = 0,
    val strength: Int = 0,
    val dexterity: Int = 0,
    val intelligence: Int = 0,
    val wisdom: Int = 0,
)