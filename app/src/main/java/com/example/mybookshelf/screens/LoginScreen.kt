package com.example.mybookshelf.screens

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.mybookshelf.R

@Composable
fun LoginScreen(navtoHome: (String) -> Unit){
    Box(
        modifier = Modifier.fillMaxSize().border(width = 10.dp, color = Color.Green)
    ){
        val context= LocalContext.current
    IconCerrarApp(context,Modifier.padding(top = 50.dp,end=10.dp).align(Alignment.TopEnd))
        Logo(Modifier.align(Alignment.TopCenter).size(130.dp).clip(CircleShape).padding(top = 50.dp))
        Box(
            modifier = Modifier.align(Alignment.Center)
        ){
            FieldSection(navtoHome)

        }
    }
}

@Composable
fun IconCerrarApp (context: Context,modifier:Modifier= Modifier){
    IconButton(
        modifier= modifier,
        onClick = { (context as? Activity )?.finish()},
        content = {
            Icon(

                imageVector = Icons.Filled.Close,
                contentDescription = "Cerrar Sesión"
            )
        }

    )
}
@Composable
fun Logo(modifier:Modifier= Modifier){
    Image(
        modifier=modifier,
        painter = painterResource(id=R.drawable.busc),
        contentDescription = "Logo de la App",
        contentScale = ContentScale.Crop
    )
}

@Composable
fun FieldSection(navtoHome: (String) -> Unit){
    var nombre by rememberSaveable() {mutableStateOf("") }
    var password by rememberSaveable() {mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){

        FieldNombre(nombre,onNombreChange = {nombre=it})
        FieldPassword(password,onPasswordChange = {password=it})
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            SignInButton(nombre,password,navtoHome)
            SignUpButton()
        }
        SignInWithGoogleButton()
    }

}

@Composable
fun FieldNombre(nombre:String,onNombreChange:(String)->Unit){
    val keyboardController= LocalSoftwareKeyboardController.current
    TextField(
        value = nombre,
        onValueChange = onNombreChange,
        label={
            Text("Nombre de Usuario")
        },
        keyboardOptions= KeyboardOptions(keyboardType = KeyboardType.Text),
    )
}
@Composable
fun FieldPassword(password:String,onPasswordChange:(String)->Unit){
    val keyboardController= LocalSoftwareKeyboardController.current
    var passVisibility by rememberSaveable(){mutableStateOf(false)}

    TextField(
        value = password,
        onValueChange = onPasswordChange,
        label={
            Text("Contraseña")

        },
        keyboardOptions= KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation= if(passVisibility) VisualTransformation.None else
            PasswordVisualTransformation(),
        trailingIcon ={
            IconButton(onClick = { passVisibility=!passVisibility }) {
                Icon(
                    imageVector = if(passVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    contentDescription = "Ver contraseña"
                )
            }
        }
    )

}
@Composable
fun SignInButton(nombre:String,password:String,navtoHome: (String) -> Unit){
    val toast = Toast.makeText(LocalContext.current, "Contraseña Incorrecta", Toast.LENGTH_SHORT)

    Button(
        onClick = {
            if(password=="123456"){
                if(nombre.contains("@")){
                    navtoHome(nombre.substringBefore("@"))
                }else{
                    navtoHome(nombre)

                }
            }  else{
                toast.show()
            }

        },


        modifier = Modifier.padding(top = 10.dp),
        content={Text("Iniciar Sesión")}
    )
}
@Composable
fun SignUpButton(){
    val toast = Toast.makeText(LocalContext.current, "Registro no Implementado", Toast.LENGTH_SHORT)

    Button(
        onClick = { toast.show() },
        modifier = Modifier.padding(top = 10.dp),
        content={Text("Registrate")}
    )
}
@Composable
fun SignInWithGoogleButton(){
    val toast = Toast.makeText(LocalContext.current, "No Implementado", Toast.LENGTH_SHORT)

    Button(
        onClick = { toast.show() },
        modifier = Modifier.padding(top = 10.dp),
        content={
            Icon(
                imageVector = Icons.Filled.GMobiledata,
                contentDescription = "Iniciar Sesión con Google",
            )
        }
    )
}

