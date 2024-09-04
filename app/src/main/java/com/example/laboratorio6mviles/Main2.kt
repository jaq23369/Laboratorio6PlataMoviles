package com.example.laboratorio6mviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeDetailsScreen()
        }
    }
}
@Composable
fun RecipeDetailsScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.prime),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
        }

        item {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Prime Rib Roast",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = "The Prime Rib Roast is a classic and tender cut of beef taken from the rib primal cut. Learn how to make the perfect prime rib roast to serve your family and friends.",
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = null, tint = Color.Red)
                Spacer(modifier = Modifier.width(4.dp))
                Text("4.5")
                Spacer(modifier = Modifier.width(16.dp))
                Text("685 SHARES")
                Spacer(modifier = Modifier.width(16.dp))
                Text("107 SAVES")
            }
        }

        item {
            Text(
                text = "SHOPPING LIST",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text("- 1 Prime Rib Roast (standing rib), approximately 8 pounds")
            Text("- 1/2 cup good-quality balsamic vinegar")
            Text("- 1 cup (packed) Italian parsley leaves")
            Text("- 8 cloves garlic, minced")
            Text("- 1/4 teaspoon salt")
            Text("- 1 cup water")
            Text("- 3 drops Worcestershire sauce")
        }

        item {
            Text(
                text = "PREPARATION",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            )
            PreparationStep(
                stepNumber = 1,
                text = "Preheat oven to 350 degrees F. Let roast stand at room temperature for 1 hour."
            )
            PreparationStep(
                stepNumber = 2,
                text = "In a small saucepan over medium-high heat, boil balsamic vinegar until it reduces to 1/4 cup, approximately 3 minutes. Remove from heat and set aside."
            )
            PreparationStep(
                stepNumber = 3,
                text = "Finely mince the parsley. Mix together with the minced garlic, 1/4 teaspoon salt, and a generous amount of pepper."
            )
            PreparationStep(
                stepNumber = 4,
                text = "After slicing the roast, add any accumulated meat juices to the balsamic sauce. Serve the meat slices on warmed plates with balsamic sauce on the side."
            )
        }

        item {
            Text(
                text = "COMMENTS",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Comment(
                userName = "TOM KLEIN",
                date = "7.01.2017",
                comment = "This prime rib roast was amazing!!!"
            )
            Comment(
                userName = "SALLY PARKER",
                date = "7.01.2017",
                comment = "I was amazed at how little preparation this took. Just rub on the herbs and butter, let it sit for a few hours and you have an amazing piece of meat! mmmmmmmmmmmmmmmmmmmmmmmh"
            )

            CommentInput()
        }
    }
}
@Composable
fun PreparationStep(stepNumber: Int, text: String) {
    Row(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(
            text = "$stepNumber.",
            style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Red)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }
}

@Composable
fun Comment(userName: String, date: String, comment: String) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Replace with a user avatar or icon if you have one
            Icon(imageVector = Icons.Default.Favorite, contentDescription = null, tint = Color.Gray)
            Spacer(modifier = Modifier.width(8.dp))
            Text(userName, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(8.dp))
            Text(date)
        }
        Text(comment)
    }
}

@Composable
fun CommentInput() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        val textState = remember { androidx.compose.runtime.mutableStateOf("") }
        BasicTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .weight(1f)
                .background(Color(0xFFF1F1F1), shape = MaterialTheme.shapes.small)
                .padding(8.dp)
        )
        IconButton(onClick = { /* Send comment */ }) {
            Icon(imageVector = Icons.Default.Send, contentDescription = null, tint = Color.Red)
        }
    }
}