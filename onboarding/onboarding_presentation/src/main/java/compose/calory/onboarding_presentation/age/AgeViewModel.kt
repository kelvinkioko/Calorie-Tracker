package compose.calory.onboarding_presentation.age

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import compose.calory.core.domain.preferences.Preferences
import compose.calory.core.domain.use_case.FilterOutDigits
import compose.calory.core.navigation.Route
import compose.calory.core.util.UiEvent
import compose.calory.core.util.UiText
import compose.calory.core.R as coreRes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AgeViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigits
): ViewModel() {

    var age by mutableStateOf("20")
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onAgeEntered(age: String) {
        if (age.length <= 3)
            this.age = filterOutDigits(text = age)
    }

    fun onNextClick() {
        viewModelScope.launch {
            val ageNumber = age.toIntOrNull() ?: kotlin.run {
                _uiEvent.send(
                    UiEvent.ShowSnackBar(
                        message = UiText.StringResource(coreRes.string.error_age_cant_be_empty)
                    )
                )
                return@launch
            }
            preferences.saveAge(age = ageNumber)
            _uiEvent.send(UiEvent.Navigate(route = Route.HEIGHT))
        }
    }
}
