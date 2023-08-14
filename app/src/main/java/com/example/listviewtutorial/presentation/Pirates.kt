@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.listviewtutorial.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.listviewtutorial.R
import com.example.listviewtutorial.domain.StrawHat

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Pirates(
    strawHatList: List<StrawHat>,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color.White,
                ),
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .wrapContentHeight()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.hat),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .padding(8.dp),
                            contentScale = ContentScale.Fit,
                        )
                        Text(
                            text = "Mugiwara Squad",
                            style = MaterialTheme.typography.headlineMedium,
                        )
                    }
                },
            )
        },
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth().background(Color.Black),
            contentPadding = PaddingValues(16.dp),

        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        "Team Strawhat here..",
                    )
                }
            }
            items(strawHatList) { character ->
                StrawHatCard(
                    name = character.name,
                    age = character.age,
                    description = character.description,
                    image = character.imageRes,
                )
            }
        }
    }
}
