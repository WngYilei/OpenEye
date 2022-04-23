package com.xl.openeye.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

import com.xl.openeye.ui.ui.theme.Purple200



@Composable
fun FindScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple200)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "发现",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@Composable
fun HotScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = com.xl.openeye.R.color.purple_500))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "热门",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}



@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = com.xl.openeye.R.color.purple_500))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "我的",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}



@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple200)
            .wrapContentSize(Alignment.TopCenter)
    ) {

    }
}
