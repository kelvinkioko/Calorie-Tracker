package compose.calory.core.util

sealed class UiEvent {
    data class Navigate(val route: String): UiEvent()
    object NavigateUp: UiEvent()
}
