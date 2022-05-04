package com.xl.openeye.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.xl.openeye.dataclass.Item
import com.xl.openeye.state.ViewEvent
import com.xl.openeye.ui.home.*

import com.xl.openeye.ui.ui.theme.Purple200
import com.xl.xl_base.tool.util.StringUtils


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
private fun LoadingContent(
    empty: Boolean,
    emptyContent: @Composable () -> Unit,
    loading: Boolean,
    onRefresh: () -> Unit,
    content: @Composable () -> Unit
) {
    if (empty) {
        emptyContent()
    } else {
        SwipeRefresh(
            state = rememberSwipeRefreshState(loading),
            onRefresh = onRefresh,
            content = content,

            )
    }
}


@OptIn(ExperimentalPagerApi::class, coil.annotation.ExperimentalCoilApi::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel) {

    val uiState = viewModel.state.collectAsState()

    val isRefresh = remember { mutableStateOf(false) }

    val data = remember { mutableListOf<Item>() }

    isRefresh.value = uiState.value.refresh

    uiState.value.homeInfo?.let {
        data.addAll(it.issueList[0].itemList)
    }

    LoadingContent(empty = data.size == 0, emptyContent = {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            CircularProgressIndicator()
        }

        viewModel.submitAction(ViewEvent.Refresh)
    }, loading = isRefresh.value, onRefresh = {
        viewModel.submitAction(ViewEvent.Refresh)
        isRefresh.value = true
        data.clear()
    }) {
        val bannerImages = arrayListOf<BannerData>()

        for (imageData in data) {
            if (bannerImages.size > 5) break
            imageData.data.image?.let {
                bannerImages.add(BannerData(it, ""))
                bannerImages.add(BannerData(it, ""))
                bannerImages.add(BannerData(it, ""))
            }
        }

        LazyColumn {
            itemsIndexed(data) { index, item ->
                if (index == 0) {
                    Banner(list = bannerImages)
                } else {
                    if (item.type == "video") {
                        HomeItemVideo(data = item.data) {
                            Log.e("TAG", "点击点击: " + it.playUrl)
                        }
                    } else {
                        HomeItemText(data = item.data.text ?: "空数据")
                    }
                }
                if (index == data.size - 1) {
                    try {
                        val map = StringUtils.getUrl(uiState.value.homeInfo!!.nextPageUrl)
                        viewModel.getNextHome(map["date"]!!)
                    } catch (e: Exception) {

                    }
                }
            }
        }

    }

}


