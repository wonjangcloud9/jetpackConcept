package com.example.jetpack_concept

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "first") {
                composable("first") {
                    FirstScreen(navController = navController)
                }
                composable("second") {
                    SecondScreen(navController = navController)
                }
                composable("third/{value}") {backStackEntry ->
                    ThirdScreen(
                        navController = navController,
                        value = backStackEntry.arguments?.getString("value") ?: ""
                    )
                }
            }
        }
    }
}

@Composable
fun FirstScreen(navController: NavController) {
    val (value, setValue) = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "First Screen")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("second")
        }) {
            Text("Second Screen")
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = value, onValueChange = { setValue(it) })
        Button(onClick = {
            if (value.isNotEmpty()){
                navController.navigate("third/$value")
            }
        }) {
            Text("Third Screen")
        }

    }
}

@Composable
fun SecondScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Second Screen")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigateUp()
        }) {
            Text("back")
        }
    }
}

@Composable
fun ThirdScreen(value: String, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Third Screen")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = value)
        Button(onClick = {
            navController.navigateUp()
        }) {
            Text("back")
        }
    }
}
