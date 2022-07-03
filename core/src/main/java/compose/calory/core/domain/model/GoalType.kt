package compose.calory.core.domain.model

sealed class GoalType(val goal: String) {
    object LoseWeight: GoalType(goal = "lose_weight")
    object KeepWeight: GoalType(goal = "keep_weight")
    object GainWeight: GoalType(goal = "gain_weight")

    companion object {
        fun fromString(goal: String): GoalType {
            return when(goal) {
                "lose_weight" -> LoseWeight
                "keep_weight" -> KeepWeight
                "gain_weight" -> GainWeight
                else -> KeepWeight
            }
        }
    }
}
