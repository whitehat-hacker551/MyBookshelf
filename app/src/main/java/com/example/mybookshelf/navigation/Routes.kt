package com.example.mybookshelf.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes: NavKey {

   @Serializable
   data object Login: Routes(){

   }
    @Serializable
    data class Home(val nomUser:String): Routes(){

    }

}