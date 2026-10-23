package com.example.mybookshelf.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(nomUser: String,onBack:()->Unit){
Box(
    modifier= Modifier.fillMaxSize(),
    contentAlignment= Alignment.Center
){
    Column(
        horizontalAlignment= Alignment.CenterHorizontally
    ){
        Card(
            modifier= Modifier.padding(10.dp),
            elevation = CardDefaults.cardElevation(20.dp),
            border= BorderStroke(width=2.dp,color=Color.Black),
        ){
            Text(
                modifier=Modifier.padding(20.dp),
                text="Bienvenido $nomUser",
                color=Color.Black
            )
        }
        Button(
            onClick=onBack,
            content={
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Volver",
                )
            },
        )
    }


}
}