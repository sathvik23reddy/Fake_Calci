package com.example.fakecalci

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


var sb: StringBuilder = StringBuilder("")
@Composable
fun MainUI(n: String){
    val context = LocalContext.current
    var number = n

    if(number[0] == '+') number = number.substring(3, number.length)
    val b = StringBuilder()
    for(i in number){
        if(i>='0' && i<='9')b.append(i)
    }
    number = b.toString()
    var x: String by remember { mutableStateOf("0") }
    Column{
        //Result
        val configuration = LocalConfiguration.current
        val screenHeight = configuration.screenHeightDp
        val sH = screenHeight/(7.5)
        val screenWidth = configuration.screenWidthDp
        val sW = screenWidth/(4)
        Box(modifier = Modifier
            .background(color = Color.Black)
            .height((screenHeight / 3).dp)
            .fillMaxSize()) {
            Text(text = "$x",modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(horizontal = 20.dp, vertical = 15.dp)
                .pointerInput(Unit) {
                    detectTapGestures(onLongPress = {
                        context.startActivity(Intent(context, ContactsActivity::class.java))
                    })
                }, fontSize = 40.sp, fontWeight = FontWeight.Bold
            )
        }


        //Panel
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue)){
            //R1
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(sH.dp)
                , horizontalArrangement = Arrangement.SpaceBetween) {
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = {
                    sb.delete(0, sb.length)
                    x = "0"
                }, modifier = Modifier.fillMaxHeight().width(sW.dp)) {
                    Text(text = "AC", fontWeight = FontWeight.SemiBold,
                        color = Color.Black, fontSize = 35.sp)
                }
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = {
                    if(sb.isNotEmpty()) sb.deleteCharAt(sb.length-1)
                    x = sb.toString()
                }, modifier = Modifier.fillMaxHeight().width(sW.dp)) {
                    Text(text = "C", fontWeight = FontWeight.SemiBold,
                        color = Color.Black, fontSize = 35.sp)
                }
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = {
                    sb.append("%")
                    x=sb.toString()
                }, modifier = Modifier.fillMaxHeight().width(sW.dp)) {
                    Text(text = "%", fontWeight = FontWeight.SemiBold,
                        color = Color.Black, fontSize = 35.sp)
                }
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = {
                    sb.append("/")
                    x=sb.toString()
                }, modifier = Modifier.fillMaxHeight().width(sW.dp)) {
                    Text(text = "/", fontWeight = FontWeight.SemiBold,
                        color = Color.Black, fontSize = 35.sp)
                }
            }

            //R2
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(sH.dp)
                , horizontalArrangement = Arrangement.SpaceBetween) {
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = {
                    sb.append("7")
                    x=sb.toString()
                }, modifier = Modifier.fillMaxHeight().width(sW.dp)) {
                    Text(text = "7", fontWeight = FontWeight.SemiBold,
                        color = Color.Black, fontSize = 35.sp)
                }
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = {
                    sb.append("8")
                    x=sb.toString()
                }, modifier = Modifier.fillMaxHeight().width(sW.dp)) {
                    Text(text = "8", fontWeight = FontWeight.SemiBold,
                        color = Color.Black, fontSize = 35.sp)
                }
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = {
                    sb.append("9")
                    x=sb.toString()
                }, modifier = Modifier.fillMaxHeight().width(sW.dp)) {
                    Text(text = "9", fontWeight = FontWeight.SemiBold,
                        color = Color.Black, fontSize = 35.sp)
                }
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = {
                    sb.append("x")
                    x=sb.toString()
                }, modifier = Modifier.fillMaxHeight().width(sW.dp)) {
                    Text(text = "x", fontWeight = FontWeight.SemiBold,
                        color = Color.Black, fontSize = 35.sp)
                }
            }

            //R3
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(sH.dp)
                , horizontalArrangement = Arrangement.SpaceBetween) {
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = {
                    sb.append("4")
                    x=sb.toString()
                }, modifier = Modifier.fillMaxHeight().width(sW.dp)) {
                    Text(text = "4", fontWeight = FontWeight.SemiBold,
                        color = Color.Black, fontSize = 35.sp)
                }
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = {
                    sb.append("5")
                    x=sb.toString()
                }, modifier = Modifier.fillMaxHeight().width(sW.dp)) {
                    Text(text = "5", fontWeight = FontWeight.SemiBold,
                        color = Color.Black, fontSize = 35.sp)
                }
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = {
                    sb.append("6")
                    x=sb.toString()
                }, modifier = Modifier.fillMaxHeight().width(sW.dp)) {
                    Text(text = "6", fontWeight = FontWeight.SemiBold,
                        color = Color.Black, fontSize = 35.sp)
                }
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = {
                    sb.append("-")
                    x=sb.toString()
                }, modifier = Modifier.fillMaxHeight().width(sW.dp)){
                    Text(text = "-", fontWeight = FontWeight.SemiBold,
                        color = Color.Black, fontSize = 35.sp)
                }
            }

            //R4
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(sH.dp)
                , horizontalArrangement = Arrangement.SpaceBetween) {
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = {
                    sb.append("1")
                    x=sb.toString()
                }, modifier = Modifier.fillMaxHeight().width(sW.dp)) {
                    Text(text = "1", fontWeight = FontWeight.SemiBold,
                        color = Color.Black, fontSize = 35.sp)
                }
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = {
                    sb.append("2")
                    x=sb.toString()
                }, modifier = Modifier.fillMaxHeight().width(sW.dp)) {
                    Text(text = "2", fontWeight = FontWeight.SemiBold,
                        color = Color.Black, fontSize = 35.sp)
                }
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = {
                    sb.append("3")
                    x=sb.toString()
                }, modifier = Modifier.fillMaxHeight().width(sW.dp)) {
                    Text(text = "3", fontWeight = FontWeight.SemiBold,
                        color = Color.Black, fontSize = 35.sp)
                }
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = {
                    sb.append("+")
                    x=sb.toString()
                }, modifier = Modifier.fillMaxHeight().width(sW.dp)) {
                    Text(text = "+", fontWeight = FontWeight.SemiBold,
                        color = Color.Black, fontSize = 35.sp)
                }
            }

            //R5
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(sH.dp)
            , horizontalArrangement = Arrangement.SpaceBetween){
                Button(modifier = Modifier.fillMaxHeight().width(sW.dp),
                    onClick = {if (sb.isNotEmpty()) {
                        if (sb[0] == '-') sb.delete(0, 1)
                        else sb.insert(0, '-')
                    } else sb.append('-')
                        x = sb.toString()},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)) {
                    Text(text = "+/-", fontWeight = FontWeight.SemiBold,
                        color = Color.Black, fontSize = 35.sp)
                }
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = {
                    sb.append("0")
                    x=sb.toString()
                }, modifier = Modifier.fillMaxHeight().width(sW.dp)) {
                    Text(text = "0", fontWeight = FontWeight.SemiBold,
                        color = Color.Black, fontSize = 35.sp)
                }
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = {
                    sb.append(".")
                    x=sb.toString()
                }, modifier = Modifier.fillMaxHeight().width(sW.dp)) {
                    Text(text = ".", fontWeight = FontWeight.SemiBold,
                        color = Color.Black, fontSize = 35.sp)
                }
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = {
                    sb.delete(0, sb.length)
                    if(number.equals("0")){
                        Toast.makeText(context, "Kya Gunda Banega Re Thu",
                        Toast.LENGTH_SHORT).show()
                    }
                    else x = number
                }, modifier = Modifier.fillMaxHeight().width(sW.dp)) {
                    Text(text = "=", fontWeight = FontWeight.SemiBold,
                        color = Color.Black, fontSize = 35.sp)
                }
            }
        }
    }

}



