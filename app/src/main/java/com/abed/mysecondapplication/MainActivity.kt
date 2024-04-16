package com.abed.mysecondapplication

import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abed.mysecondapplication.ui.theme.MySecondApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySecondApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                Column{
                    HelloWorld("Summer")
                    Button(
                        onClick = {
                            val intent = Intent(this@MainActivity,Loginactivity::class.java)
                                 startActivity(intent)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp), colors = ButtonDefaults.buttonColors(Color.Magenta)) {
                        Text(text = "LOG IN HERE(<..>)")}
                    Spacer(modifier = Modifier.height(28.dp))
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp), colors = ButtonDefaults.buttonColors(Color.Magenta)) {
                        Text(text = "REGISTER HERE(<..>)")}
                    Spacer(modifier = Modifier.height(28.dp))
                    Button(
                        onClick = {
                            val intent = Intent(this@MainActivity,BackgroundActivity::class.java)
                            startActivity(intent)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp), colors = ButtonDefaults.buttonColors(Color.Magenta)) {
                        Text(text = "BACKGROUNDS(<..>)")}
                    }
                }
            }
        }
    }
}

@Composable
fun HelloWorld(name: String){
    Column {
        Text(
            text = "Hey $name! Welcome Back(<..>):Registration",
            fontSize = 20.sp,
            color = Color.Green,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier
//                .height(200.dp)
                .fillMaxWidth()
                .wrapContentHeight(align = Alignment.CenterVertically)
                .padding(25.dp)
                .background(Color.Black),
        )
        ImageComponent()
        Spacer(modifier = Modifier.height(28.dp))
        TextFieldComponent()
        Spacer(modifier = Modifier.height(28.dp))
        TextFieldEmailComponent()
        Spacer(modifier = Modifier.height(28.dp))
        TextFieldLocationComponent()
        Spacer(modifier = Modifier.height(28.dp))
        PasswordTextFeild()
        Spacer(modifier = Modifier.height(28.dp))
        Column {

//        Button(onClick = {},modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp))  {
//            Text(text = "REGISTER HERE(<..>)")
//          }
        }
    }
}
@Preview(showSystemUi = true, showBackground = true  )
@Composable
fun HelloWorldPreview(){
    HelloWorld("Briant")
}
@Composable
fun TextFieldComponent(){
    var text by remember{
        mutableStateOf(value="")
    }
    TextField(modifier = Modifier.fillMaxWidth(),
        value = text, onValueChange = {
        newText -> text = newText
    },
        label= {Text(text= "Enter your name:")},
        placeholder = {
            Text(text = "Please Enter your name:")
        })
}
@Composable
fun TextFieldEmailComponent(){
    var text by remember{
        mutableStateOf(value="")}
    TextField(modifier = Modifier.fillMaxWidth(),
        value = text, onValueChange = {
                newText -> text = newText
        },
        label= {Text(text= "Enter your Email:")},
        placeholder = {
            Text(text = "Please Enter your Email:")
        })
}
@Composable
fun TextFieldLocationComponent(){
    var text by remember{
        mutableStateOf(value="")}
    TextField(modifier = Modifier.fillMaxWidth(),
        value = text, onValueChange = {
                newText -> text = newText
        },
        label= {Text(text= "Enter your Location:")},
        placeholder = {
            Text(text = "Please Enter your Location:")
        })
}
@Composable
fun PasswordTextFeild(){
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.design_ic_visibility)
    else
        painterResource(id = R.drawable.design_ic_visibility_off)

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        onValueChange = {
            password = it
        },
        placeholder = { Text(text = "Password") },
        trailingIcon = {
            IconButton(onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Icon(
                    painter = icon,
                    contentDescription = "Visibility Icon"
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else PasswordVisualTransformation()
    )
}
//(onClick = {}) {
//    val intent = Intent(this@MainActivity,Loginactivity::class.java)
//    startActivity(intent)