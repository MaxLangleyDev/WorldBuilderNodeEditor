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
    val titles : List<String> = emptyList(),
    val currentTitle : String = "",
    val coordinates : Pair<Int, Int> = Pair(0, 0),

    val stats : CharacterStats = CharacterStats(),

    val inventory : List<String> = emptyList(),
    val equippedItems : List<String> = emptyList(),
)
