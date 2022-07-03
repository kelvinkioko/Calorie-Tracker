package compose.calory.tracker

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import compose.calory.core.navigation.Route
import compose.calory.onboarding_presentation.welcome.WelcomeScreen
import compose.calory.tracker.navigation.navigate
import compose.calory.tracker.ui.theme.CaloryTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloryTrackerTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Route.WELCOME
                ) {
                    composable(Route.WELCOME) {
                        WelcomeScreen(onNavigate = navController::navigate)
                    }
                    composable(Route.AGE) {
                        Toast.makeText(this@MainActivity, "Age Route", Toast.LENGTH_LONG).show()
                    }
                    composable(Route.GENDER) {
                        Toast.makeText(this@MainActivity, "Gender", Toast.LENGTH_LONG).show()
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    CaloryTrackerTheme {
        // WelcomeScreen()
    }
}
