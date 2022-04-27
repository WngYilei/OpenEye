package com.xl.openeye.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.xl.openeye.state.ViewEvent
import com.xl.openeye.ui.home.Banner
import com.xl.openeye.ui.home.BannerData
import com.xl.openeye.ui.home.HomeViewModel
import com.xl.openeye.ui.search.SearchViewModel

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


@OptIn(ExperimentalPagerApi::class, coil.annotation.ExperimentalCoilApi::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    var data = viewModel.state.collectAsState()
    Button(onClick = { viewModel.getHome(1) }) {
        Text(text = "获取数据")
    }
    data.value.homeInfo?.let {
        var url = it.issueList[0].itemList[0].data.image;
        Log.e("TAG", "HomeScreen: " + url)
        val bannerImages = arrayListOf<BannerData>()
        bannerImages.add(BannerData(url, ""))
        bannerImages.add(BannerData(url, ""))
        bannerImages.add(BannerData(url, ""))

        LazyColumn {
            itemsIndexed(data.value.homeInfo!!.issueList) { index, item ->
                if (index == 0) {
                    Banner(list = bannerImages)
                } else {

                }
            }
        }
    }
}


