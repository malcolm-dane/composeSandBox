 package com.mdane.composeSandbox.ui.common


import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.mdane.composeSandbox.ui.navigation.NavigationScreen


@Composable
fun NavigationButton(navController: NavController, destination: NavigationScreen, modifier: Modifier = Modifier) {
    Button(onClick = {
        Log.i(destination.name, "Navigate to screen 1")
        navController.navigate(destination.name)
    }, modifier = modifier.fillMaxWidth()) {
        Text(text = "Go to ${destination.title}")
    }
}


@Preview
@Composable
fun SomeButton(navController: NavController, destination: NavigationScreen, modifier: Modifier = Modifier) {

    Button(
        onClick={},
        modifier = Modifier.padding(8.dp),
        elevation = ButtonDefaults.elevation()
    ) {
        Text(text = "Elevated Button")
    }
}