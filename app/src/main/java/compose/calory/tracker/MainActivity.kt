package compose.calory.tracker

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import compose.calory.core.navigation.Route
import compose.calory.onboarding_presentation.age.AgeScreen
import compose.calory.onboarding_presentation.gender.GenderScreen
import compose.calory.onboarding_presentation.welcome.WelcomeScreen
import compose.calory.tracker.navigation.navigate
import compose.calory.tracker.ui.theme.CaloryTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloryTrackerTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Route.WELCOME
                    ) {
                        composable(Route.WELCOME) {
                            WelcomeScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.GENDER) {
                            GenderScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.AGE) {
                            AgeScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navController::navigate
                            )
                        }
                        composable(Route.HEIGHT) {
                            Toast.makeText(this@MainActivity, "Height", Toast.LENGTH_LONG).show()
                        }
                        composable(Route.WEIGHT) {
                            Toast.makeText(this@MainActivity, "Weight", Toast.LENGTH_LONG).show()
                        }
                        composable(Route.NUTRIENT_GOAL) {
                            Toast.makeText(this@MainActivity, "Nutrient Goal", Toast.LENGTH_LONG).show()
                        }
                        composable(Route.ACTIVITY) {
                            Toast.makeText(this@MainActivity, "Activity", Toast.LENGTH_LONG).show()
                        }
                        composable(Route.GOAL) {
                            Toast.makeText(this@MainActivity, "Goal", Toast.LENGTH_LONG).show()
                        }
                        composable(Route.TRACKER_OVERVIEW) {
                            Toast.makeText(this@MainActivity, "Tracker Overview", Toast.LENGTH_LONG).show()
                        }
                        composable(Route.SEARCH) {
                            Toast.makeText(this@MainActivity, "Search", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    CaloryTrackerTheme {
        // WelcomeScreen()
    }
}
