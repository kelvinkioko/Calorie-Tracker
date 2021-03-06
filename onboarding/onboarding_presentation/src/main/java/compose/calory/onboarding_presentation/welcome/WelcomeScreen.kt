package compose.calory.onboarding_presentation.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import compose.calory.core.navigation.Route
import compose.calory.core.util.UiEvent
import compose.calory.core_ui.localSpacing
import compose.calory.onboarding_presentation.components.ActionButton
import compose.calory.core.R as coreRes

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    // TODO: Add screen for preview
}

@Composable
fun WelcomeScreen(
    onNavigate: (UiEvent.Navigate) -> Unit?
) {
    val spacing = localSpacing.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceMedium),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = coreRes.string.welcome_text),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h1
        )
        Spacer(
            modifier = Modifier.height(spacing.spaceMedium)
        )
        ActionButton(
            text = stringResource(id = coreRes.string.next),
            onClick = { onNavigate(UiEvent.Navigate(Route.GENDER)) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}
