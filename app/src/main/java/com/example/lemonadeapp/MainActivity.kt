package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeAppTheme {
                LemonadeApp()
            }
        }
    }
}


@Composable
fun LemonadeImage(modifier: Modifier){
    var change by remember { mutableStateOf(1) }
    var  imagesResources =when (change){
        1 -> R.drawable.lemon_tree
        2-> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }
    val textDescription = when (change) {
        1 -> R.string.description_of_lemon_tree
        2 -> R.string.Description_of_lemon_squeeze
        3 -> R.string.Description_of_lemon_drink
        4 -> R.string.description_of_lemon_restart
        else -> R.string.description_of_lemon_tree
    }
    Text(
        text = stringResource(R.string.lemonade),
        fontSize = 20.sp,
        modifier = modifier
            .background(color = Color.Yellow)
            .fillMaxWidth()
            .absolutePadding(top = 20.dp, bottom = 15.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment= Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {


        Button(onClick = {
            change = when (change) {
                1 -> 2
                2 -> 3
                3 -> 4
                else -> 1
            }
        }, modifier = modifier,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
            shape = RoundedCornerShape(30.dp)){
            Image(
                painter = painterResource(imagesResources),
                contentDescription = "null", // Replace with your actuals tring resource
                modifier = Modifier.size(150.dp) // Adjust size as needed
            )
        }
        Spacer(modifier = modifier
            .height(20.dp))
        Text(
            text = stringResource(textDescription)

        )
    }
}
@Preview(showBackground = true)
@Composable
fun LemonadeApp(){
    LemonadeImage(modifier = Modifier)
}



