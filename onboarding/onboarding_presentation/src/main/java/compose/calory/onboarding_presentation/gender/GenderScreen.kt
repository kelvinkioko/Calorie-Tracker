package compose.calory.onboarding_presentation.gender

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import compose.calory.core.domain.model.Gender
import compose.calory.core.util.UiEvent
import compose.calory.core_ui.localSpacing
import compose.calory.onboarding_presentation.components.ActionButton
import compose.calory.onboarding_presentation.components.SelectableButton
import compose.calory.core.R as coreRes

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    // TODO: Add screen for preview
}

@Composable
fun GenderScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: GenderViewModel = hiltViewModel()
) {
    val spacing = localSpacing.current
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
                else -> Unit
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = coreRes.string.whats_your_gender),
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Row {
                SelectableButton(
                    text = stringResource(id = coreRes.string.male),
                    isSelected = viewModel.selectedGender is Gender.Male,
                    color = MaterialTheme.colors.primaryVariant,
                    selectedTextColor = Color.White,
                    onClick = {
                        viewModel.onGenderClick(gender = Gender.Male)
                    },
                    textStyle = MaterialTheme.typography.button.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = coreRes.string.female),
                    isSelected = viewModel.selectedGender is Gender.Female,
                    color = MaterialTheme.colors.primaryVariant,
                    selectedTextColor = Color.White,
                    onClick = {
                        viewModel.onGenderClick(gender = Gender.Female)
                    },
                    textStyle = MaterialTheme.typography.button.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }
        ActionButton(
            text = stringResource(id = coreRes.string.next),
            onClick = viewModel::onNextClick,
            modifier =  Modifier.align(Alignment.BottomEnd)
        )
    }
}
