package com.healthcare.ifit

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.healthcare.ifit.featuresUi.BMIScreen
import com.healthcare.ifit.featuresUi.Reminder
import com.healthcare.ifit.featuresUi.WaterTracker
import com.healthcare.ifit.mentalhealth.Timer
import com.healthcare.ifit.mentalhealth.ui.DailyMeditationScreen
import com.healthcare.ifit.mentalhealth.ui.MeditationScreenUi
import com.healthcare.ifit.mentalhealth.ui.MentalHealthScreen
import com.healthcare.ifit.model.SignInViewModel
import com.healthcare.ifit.ui.InputScreen
import com.healthcare.ifit.ui.ProfileScreen
import com.healthcare.ifit.ui.theme.IFITTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {

    private val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = com.google.android.gms.auth.api.identity.Identity.getSignInClient(
                applicationContext
            )
        )
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            IFITTheme {
                val navController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()

                val currentScreen = backStackEntry?.destination?.route

                Scaffold(
                    bottomBar = {
                        if (currentScreen != IFitScreen.SignIn.name &&
                            currentScreen !=IFitScreen.InputScreen.name) {
                            IFitBottomBar(
                                onHomeSc = {
                                    navController.popBackStack(IFitScreen.Home.name, false)
                                },
                                onBlogSc = {
                                    navController.navigate(IFitScreen.Blog.name)
                                },
                                onMHSc = {
                                    navController.navigate(IFitScreen.MentalHealth.name)
                                },
                                onPrSc = {
                                    navController.navigate(IFitScreen.Profile.name)
                                },
                                currentScreen
                            )
                        }
                    }
                ) {

                    NavHost(
                        navController = navController,
                        startDestination = IFitScreen.SignIn.name,
                        modifier = Modifier.padding(it)
                    ) {

                        composable(IFitScreen.SignIn.name) {
                            val viewModel = viewModel<SignInViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()
                            val launcher = rememberLauncherForActivityResult(
                                contract = ActivityResultContracts.StartIntentSenderForResult(),
                                onResult = { result ->
                                    if (result.resultCode == RESULT_OK) {
                                        lifecycleScope.launch {
                                            val signInResult = googleAuthUiClient.signInWithIntent(
                                                intent = result.data ?: return@launch
                                            )
                                            viewModel.onSignInResult(signInResult)
                                        }
                                    }
                                }
                            )
                            LaunchedEffect(key1 = Unit) {
                                if (googleAuthUiClient.getSignedInUser() != null) {
                                    navController.navigate(IFitScreen.Home.name)
                                }
                            }
                            LaunchedEffect(key1 = state.isSignInSuccessful) {
                                if (state.isSignInSuccessful) {
                                    Toast.makeText(
                                        applicationContext,
                                        "Sign in successful",
                                        Toast.LENGTH_LONG
                                    ).show()
                                    navController.navigate(IFitScreen.InputScreen.name)
                                    viewModel.resetState()
                                }
                            }
                            SignInScreen(
                                state = state,
                                onSignInClick = {
                                    lifecycleScope.launch {
                                        val signInIntentSender = googleAuthUiClient.signIn()
                                        launcher.launch(
                                            IntentSenderRequest.Builder(
                                                signInIntentSender ?: return@launch
                                            ).build()
                                        )
                                    }
                                },
                            )
                        }


                        composable(IFitScreen.InputScreen.name) {
                            InputScreen(
                                onDataInserted = {
                                    navController.navigate(IFitScreen.Home.name)
                                }
                            )
                        }

                        composable(IFitScreen.Home.name) {
                            HomeScreen(
//                                onSignOut = {
//                                    lifecycleScope.launch {
//                                        googleAuthUiClient.signOut()
//                                        Toast.makeText(
//                                            applicationContext,
//                                            "Signed out",
//                                            Toast.LENGTH_LONG
//                                        ).show()
//                                        navController.popBackStack()
//                                    }
//                                },
                                onBMICal = {
                                    navController.navigate(IFitScreen.BMIScreen.name)

                                },
                                onWater = {
                                    navController.navigate(IFitScreen.Water.name)
                                },
                                onMedicine = {
                                    navController.navigate(IFitScreen.Medicine.name)
                                },
                                onSleep = {
                                          navController.navigate("sleeptracker")
                                },
                            )
                        }

                        composable(IFitScreen.MentalHealth.name) {
                            MentalHealthScreen(
                                onMeditation = {
                                    navController.navigate(IFitScreen.Meditation.name)
                                },
                                onSleep = {
                                    navController.navigate(IFitScreen.Sleep.name)
                                },
                            )
                        }


                        composable(IFitScreen.Profile.name) {
                            ProfileScreen(
                                onSignOut = {
                                    lifecycleScope.launch {
                                        googleAuthUiClient.signOut()
                                        Toast.makeText(
                                            applicationContext,
                                            "Signed out",
                                            Toast.LENGTH_LONG
                                        ).show()
                                        navController.popBackStack( IFitScreen.SignIn.name , false)
                                    }
                                },
                                updateProfile = {
                                    navController.navigate( IFitScreen.SignIn.name )
                                },
                                userData = googleAuthUiClient.getSignedInUser(),
                            )
                        }


                        composable("inpscr") {
                            InputScreen(
                                onDataInserted = {
                                    navController.navigate(IFitScreen.Home.name)
                                }
                            )
                        }


                        composable(IFitScreen.Blog.name) {
                            Shopping( )
                        }

                        composable(IFitScreen.BMIScreen.name) {
                            BMIScreen(
                                viewModel = viewModel()
                            )

                        }

                        composable("sleeptracker"){

                        }

                        composable(IFitScreen.Water.name) {
                            WaterTracker()
                        }

                        composable(IFitScreen.Medicine.name) {
                            Reminder(onHome = {
                                navController.popBackStack()
                            }
                            )
                        }

                        composable(IFitScreen.Sleep.name) {
                            DailyMeditationScreen()
                        }

                        composable(IFitScreen.Meditation.name) {

                            MeditationScreenUi(
                                on3min = {
                                    navController.navigate("onThreeMinCall")
                                },
                                on5min = {
                                    navController.navigate("onFiveMinCall")
                                },
                                on10min = {
                                    navController.navigate("onTenMinCall")
                                }
                            )
                        }

                        composable("onThreeMinCall") {
                            Timer(
                                totalTime = 180L * 1000L,
                                modifier = Modifier.size(200.dp)
                            )
                        }

                        composable("onFiveMinCall") {
                            Timer(
                                totalTime = 300L * 1000L,
                                modifier = Modifier.size(200.dp)
                            )
                        }

                        composable("onTenMinCall") {
                            Timer(
                                totalTime = 600L * 1000L,
                                modifier = Modifier.size(200.dp)
                            )
                        }
                    }
                }
            }
        }
    }

}

enum class IFitScreen() {
    SignIn,
    InputScreen,
    Home,
    Blog,
    MentalHealth,
    Profile,
    BMIScreen,
    Medicine,
    Water,
    Meditation,
    Sleep
}

@Composable
fun IFitBottomBar(
    onHomeSc: () -> Unit,
    onBlogSc: () -> Unit,
    onMHSc: () -> Unit,
    onPrSc: () -> Unit,
    currentScreen: String?
) {
    BottomAppBar(
        modifier = Modifier
            .height(80.dp),
        backgroundColor = MaterialTheme.colors.background
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.home),
                contentDescription = stringResource(R.string.home),
                tint =  if(currentScreen == IFitScreen.Home.name) Color.Cyan else Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .clickable { onHomeSc.invoke() }
            )
            Icon(
                painter = painterResource(id = R.drawable.workout),
                contentDescription = stringResource(R.string.workout),
                tint = if(currentScreen == IFitScreen.Blog.name) Color.Cyan else Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .clickable { onBlogSc.invoke() }
            )
            Icon(
                painter = painterResource(id = R.drawable.medition),
                contentDescription = stringResource(R.string.meditation),
                tint = if(currentScreen == IFitScreen.MentalHealth.name) Color.Cyan else Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .clickable { onMHSc.invoke() }
            )
            Icon(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = stringResource(R.string.profile),
                tint = if(currentScreen == IFitScreen.Profile.name) Color.Cyan else Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .clickable { onPrSc.invoke() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview(){
    IFITTheme() {
        IFitBottomBar(
            onHomeSc = { /*TODO*/ },
            onBlogSc = { /*TODO*/ },
            onMHSc = { /*TODO*/ },
            onPrSc = { /*TODO*/ },
            currentScreen = ""
        )
    }

}