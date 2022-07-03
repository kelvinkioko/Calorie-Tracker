package compose.calory.core.domain.model

sealed class ActivityLevel(val activity: String) {
    object Low: ActivityLevel(activity = "low")
    object Medium: ActivityLevel(activity = "medium")
    object High: ActivityLevel(activity = "high")

    companion object {
        fun fromString(activity: String): ActivityLevel {
            return when(activity) {
                "low" -> Low
                "medium" -> Medium
                "high" -> High
                else -> Medium
            }
        }
    }
}
