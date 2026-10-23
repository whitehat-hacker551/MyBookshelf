package com.example.mybookshelf.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.mybookshelf.screens.HomeScreen
import com.example.mybookshelf.screens.LoginScreen

@Composable
fun NavigationWrapper(){
    val backStack = rememberNavBackStack(Routes.Login)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeAt(backStack.lastIndex) },
        entryProvider=  entryProvider {
                entry<Routes.Login> {
                    LoginScreen{
                        nomUser ->
                        backStack.add(Routes.Home(nomUser))
                    }
                }
            entry<Routes.Home> { key ->
                HomeScreen(
                    key.nomUser,onBack = { backStack.removeAt(backStack.lastIndex) }
                )

            }
        }
    )
}

