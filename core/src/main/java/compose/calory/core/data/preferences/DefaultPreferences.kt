package compose.calory.core.data.preferences

import android.content.SharedPreferences
import compose.calory.core.domain.model.ActivityLevel
import compose.calory.core.domain.model.Gender
import compose.calory.core.domain.model.GoalType
import compose.calory.core.domain.model.UserInfo
import compose.calory.core.domain.preferences.Preferences

class DefaultPreferences(
    private val sharedPrefs: SharedPreferences
): Preferences {
    override fun saveGender(gender: Gender) {
        sharedPrefs.edit()
            .putString(Preferences.KEY_GENDER, gender.name)
            .apply()
    }

    override fun saveAge(age: Int) {
        sharedPrefs.edit()
            .putInt(Preferences.KEY_AGE, age)
            .apply()
    }

    override fun saveWeight(weight: Float) {
        sharedPrefs.edit()
            .putFloat(Preferences.KEY_WEIGHT, weight)
            .apply()
    }

    override fun saveHeight(height: Int) {
        sharedPrefs.edit()
            .putInt(Preferences.KEY_HEIGHT, height)
            .apply()
    }

    override fun saveActivityLevel(activityLevel: ActivityLevel) {
        sharedPrefs.edit()
            .putString(Preferences.KEY_ACTIVITY_LEVEL, activityLevel.activity)
            .apply()
    }

    override fun saveGoalType(goalType: GoalType) {
        sharedPrefs.edit()
            .putString(Preferences.KEY_GOAL_TYPE, goalType.goal)
            .apply()
    }

    override fun saveCarbRatio(carbRatio: Float) {
        sharedPrefs.edit()
            .putFloat(Preferences.KEY_CARB_RATIO, carbRatio)
            .apply()
    }

    override fun saveProteinRatio(proteinRatio: Float) {
        sharedPrefs.edit()
            .putFloat(Preferences.KEY_PROTEIN_RATIO, proteinRatio)
            .apply()
    }

    override fun saveFatRatio(fatRatio: Float) {
        sharedPrefs.edit()
            .putFloat(Preferences.KEY_FAT_RATIO, fatRatio)
            .apply()
    }

    override fun loadUserInfo(): UserInfo {
        return UserInfo(
            gender = Gender.fromString(
                name = sharedPrefs.getString(Preferences.KEY_GENDER, null) ?: "male"
            ),
            age = sharedPrefs.getInt(Preferences.KEY_AGE, -1),
            weight = sharedPrefs.getFloat(Preferences.KEY_WEIGHT, 0.0f),
            height = sharedPrefs.getInt(Preferences.KEY_HEIGHT, -1),
            activityLevel = ActivityLevel.fromString(
                activity = sharedPrefs.getString(Preferences.KEY_ACTIVITY_LEVEL, null) ?: "medium"
            ),
            goalType = GoalType.fromString(
                goal = sharedPrefs.getString(Preferences.KEY_GOAL_TYPE, null) ?: "keep_weight"
            ),
            carbRatio = sharedPrefs.getFloat(Preferences.KEY_CARB_RATIO, 0.0f),
            proteinRatio = sharedPrefs.getFloat(Preferences.KEY_PROTEIN_RATIO, 0.0f),
            fatRatio = sharedPrefs.getFloat(Preferences.KEY_FAT_RATIO, 0.0f)
        )
    }
}
