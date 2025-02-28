package com.example.lecture6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lecture6.lectures.HomeScreen
import com.example.lecture6.lectures.Lec6Screen
import com.example.lecture6.lectures.Lec7Screen
import com.example.lecture6.lectures.Lec8Screen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "home"
            ) {
                composable("home") {
                    HomeScreen2(navController)
                }
                composable("6") {
                    Lec6Screen()
                }
                composable("7") {
                    Lec7Screen()
                }
                composable("8") {
                    Lec8Screen()
                }
                composable("9") {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen2(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "6부터 9까지")
        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = {
            navController.navigate("6")
        }) {
            Text("Lecture6")
        }
        Button(onClick = {
            navController.navigate("7")
        }) {
            Text("Lecture7")
        }
        Button(onClick = {
            navController.navigate("8")
        }) {
            Text("Lecture8")
        }

        Button(onClick = {
            navController.navigate("9")
        }) {
            Text("Lecture9")
        }

    }
}