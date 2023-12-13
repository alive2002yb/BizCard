package com.example.bizcard

import android.os.Bundle
import android.print.PrintAttributes.Margins
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bizcard.ui.theme.BizCardTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard()
{
    val buttonclick = remember{ mutableStateOf(false) }
    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(),
    ){
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = cardElevation(4.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.white),
            )
        )
        {
            Column(modifier=Modifier
                .height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                CreateImageProfile()
                Divider(modifier = Modifier
                    .padding(50.dp,0.dp),
                    thickness = 2.dp,
                    color = Color.LightGray
                )
                CreateInfo()
                Button(onClick = {
                                 buttonclick.value=!buttonclick.value
                },
                    shape = RectangleShape,
                    border = BorderStroke(1.dp,Color.LightGray)
                ){
                    Text(text = "Portfolio",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }


            }
            if(buttonclick.value)
            {
                Content()
            }
                    }

        }
    }
@Preview
@Composable
fun Content()
{
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(5.dp))
    {
        Surface (modifier= Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            color = Color.White,
            border = BorderStroke(.5.dp, color = Color.LightGray),
            shadowElevation = 5.dp,
            shape= RoundedCornerShape(corner = CornerSize(6.dp))
        ){
            Portfolio(data = listOf("DiceRoller","AboutMe","ColorMyViews","DiceRoller","AboutMe","ColorMyViews","DiceRoller","AboutMe","ColorMyViews","DiceRoller","AboutMe","ColorMyViews","DiceRoller","AboutMe","ColorMyViews"))
        }
    }

}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
        items(data) { item ->
            Card(
                modifier = Modifier.padding(5.dp),
                shape = RectangleShape,
                elevation = cardElevation(4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.white),
                )
            )
            {
                Row(
                    modifier = Modifier
                        .padding(7.dp)
                        .background(MaterialTheme.colorScheme.surface)
                )
                {
                    CreateImageProfile(modifier = Modifier.size(100.dp))
                    Column(modifier = Modifier.align(Alignment.CenterVertically)
                        .padding(7.dp)
                        .border(.5.dp, color = Color.Black)) {
                        Text(
                        text = item.toString(), modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                        Text(
                            text = "A Good Project made by me", modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(0.dp,5.dp),
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "A Good Project made by me", modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}
@Composable
private fun CreateInfo() {
    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {
        Text(
            text = "Yog Bakhru", modifier = Modifier,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            fontFamily = FontFamily.Cursive,
        )
        Text(
            text = "Android Compose Dev",
            modifier = Modifier
                .padding(3.dp)
        )
        Text(
            text = "@sudo_ssh_yogiiii",
            modifier = Modifier
                .padding(3.dp),
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Composable
private fun CreateImageProfile(modifier:Modifier= Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 5.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile image",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BizCardTheme {
        CreateBizCard()
    }
}