package model

import kotlinx.serialization.Serializable

@Serializable
data class GameCharacter(
    val id : Int = 0,
    val name : String = "",
    val description : String = "",
    val image : String = "",
    val gender : String = "",
    val rpgClass : String = "",
)
