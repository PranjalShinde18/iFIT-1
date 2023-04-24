package com.healthcare.ifit

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.healthcare.ifit.MentalHealth.MeditationScreenUi
import com.healthcare.ifit.MentalHealth.ui.MentalScreen
import com.healthcare.ifit.MentalHealth.ui.SleepScreen
import com.healthcare.ifit.MentalHealth.ui.Timer
import com.healthcare.ifit.ui.theme.IFITTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val googleAuthUiClient by lazy {

        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = com.google.android.gms.auth.api.identity.Identity.getSignInClient(applicationContext)
        )

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{

            IFITTheme{

                Surface (
                    modifier = Modifier.fillMaxSize()
                )
                {

                    val navController = rememberNavController()


                    NavHost(navController = navController, startDestination = "sign_in") {


                        composable("sign_in") {
                            val viewModel = viewModel<SignInViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()

                            val launcher = rememberLauncherForActivityResult(
                                contract = ActivityResultContracts.StartIntentSenderForResult(),
                                onResult = { result ->
                                    if(result.resultCode == RESULT_OK) {
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
                                if(googleAuthUiClient.getSignedInUser() != null) {
                                    navController.navigate("HomeScreen")
                                }
                            }

                            LaunchedEffect(key1 = state.isSignInSuccessful) {
                                if(state.isSignInSuccessful) {
                                    Toast.makeText(
                                        applicationContext,
                                        "Sign in successful",
                                        Toast.LENGTH_LONG
                                    ).show()

                                    navController.navigate("homescreen")
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
                                    navController.navigate("homescreen")
                                }

                            )
                        }

                        composable("homescreen") {
                            HomeScreen(
                                userData = googleAuthUiClient.getSignedInUser(),
                                onSignOut = {
                                    lifecycleScope.launch {
                                        googleAuthUiClient.signOut()
                                        Toast.makeText(
                                            applicationContext,
                                            "Signed out",
                                            Toast.LENGTH_LONG
                                        ).show()

                                        navController.popBackStack()
                                    }
                                },

                                onBMIcal = {
                                    navController.navigate("bmical")
                                },

                                onWater = {

                                    navController.navigate("water")
                                },

                                onMedicine ={
                                    navController.navigate("Medicine")
                                },
                                onMentalHealth = {
                                    navController.navigate("Mental")
                                }

                            )
                        }

                        composable("bmical"){
                            BMIScreen(
                                viewModel = viewModel()
                            )
                        }

                        composable("water"){
                            WaterTracker()
                        }

                        composable("Medicine"){
                            Reminder( onHome = {
                                navController.popBackStack()
                            }
                            )
                        }

                        composable("Mental"){

                            MentalScreen(

                                onMeditation = {
                                    navController.navigate("meditate")
                                },

                                onSleep = {
                                    navController.navigate("Sleep")
                                }
                            )
                        }

                        composable("meditate"){
//
                            MeditationScreenUi(
                                on3min = {
                                         navController.navigate("onthreemincall")
                                },
                                on5min = {
                                    navController.navigate("onfivemincall")
                                },
                                on10min = {
                                    navController.navigate("ontenmincall")
                                }
                            )
                        }

                        composable("onthreemincall"){
                            Timer(
                                totalTime = 180L * 1000L,
                                modifier = Modifier.size(200.dp)
                            )
                        }

                        composable("onfivemincall"){
                            Timer(
                                totalTime = 300L * 1000L,
                                modifier = Modifier.size(200.dp)
                            )
                        }

                        composable("ontenmincall"){
                            Timer(
                                totalTime = 600L * 1000L,
                                modifier = Modifier.size(200.dp)
                            )
                        }

                        composable("Sleep"){
                            SleepScreen(

                            )
                        }



                    }
                }
            }
        }
    }
}