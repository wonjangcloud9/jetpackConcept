package com.example.jetpack_concept

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack_concept.ui.theme.JetpackconceptTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackconceptTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .background(color = MaterialTheme.colors.primary),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Column(
                            modifier = Modifier
                                .background(color = MaterialTheme.colors.secondary)
                                .padding(10.dp)
                        ) {
                            Text("Hello")
                            Spacer(modifier = Modifier.height(10.dp))
                            Text("World!")
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .background(color = MaterialTheme.colors.secondary)
                                .padding(10.dp)
                        ) {
                            Text("Hello")
                            Spacer(modifier = Modifier.width(10.dp))
                            Text("World!")
                        }
                    }
                }
            }
        }
    }
}