package compose.calory.tracker.navigation

import androidx.navigation.NavController
import compose.calory.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}
