package com.abed.mysecondapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abed.mysecondapplication.ui.theme.MySecondApplicationTheme

class Loginactivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySecondApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        HelloWorld1(name = "Maria")
                        Button(
                            onClick ={
                                     val intent = Intent(this@Loginactivity,MainActivity::class.java)
                                startActivity(intent)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp), colors = ButtonDefaults.buttonColors(Color.Magenta)
                        ) {
                            Text(text = "REGISTER HERE(<..>)")
                        }
                        Spacer(modifier = Modifier.height(28.dp))
                        Button(
                            onClick = {}, modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(text = "LOGIN HERE(<..>)")
                    }
                }
            }
        }
    }
}
@Composable
fun HelloWorld1(name: String) {
    Column {
        Text(
            text = "Hey $name! Welcome Back(<..>):log in:",
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
        TextFieldComponent1()
        Spacer(modifier = Modifier.height(28.dp))
        TextFieldEmailComponent1()
        Spacer(modifier = Modifier.height(28.dp))
        TextFieldLocationComponent1()
        Spacer(modifier = Modifier.height(28.dp))
        Column {

            }
        }
    }
}
    
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview(){
    HelloWorld("Maria")
}
@Composable
fun TextFieldComponent1(){
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
fun TextFieldEmailComponent1(){
    var text by remember{
        mutableStateOf(value="")
    }
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
fun TextFieldLocationComponent1(){
    var text by remember{
        mutableStateOf(value="")
    }
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
fun ImageComponent() {
    Image(modifier = Modifier
        .wrapContentHeight()
        .fillMaxWidth()
        .height(80.dp), painter = painterResource(id = R.drawable.img), contentDescription ="MY LOGO")
}
