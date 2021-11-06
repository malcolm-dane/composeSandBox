package com.mdane.composeSandbox.screen2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mdane.composeSandbox.ui.common.MyScreenTitle
import com.mdane.composeSandbox.ui.common.NavigationButton
import com.mdane.composeSandbox.ui.navigation.NavigationScreen
import com.mdane.composeSandbox.ui.theme.ComposeTheme

@Composable
fun Screen2(navController: NavController, screen2ViewModel: Screen2ViewModel) {
    val title = screen2ViewModel.title.collectAsState(initial = "")

    Column(modifier = Modifier
        .fillMaxHeight()
        .background(Color.LightGray), verticalArrangement = Arrangement.Bottom) {

        //Spacer(modifier = Modifier.fillMaxHeight(fraction = 0.9f))
        NavigationButton(navController, NavigationScreen.SCREEN_1)
    }
    Column(modifier = Modifier
        .fillMaxHeight(), verticalArrangement = Arrangement.Top) {
        MyScreenTitle(title = title.value)
    }
}

@Preview(showBackground = true)
@Composable
fun Screen2Preview() {
    ComposeTheme {
        val navController = rememberNavController()
        val screen2ViewModel = Screen2ViewModel()
        Screen2(navController, screen2ViewModel)
    }
}