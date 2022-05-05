package com.xl.openeye.ui.video

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import com.xl.openeye.R
import com.xl.openeye.dataclass.Data
import com.xl.xl_base.tool.util.DateUtil

/**
 * @Author : wyl
 * @Date : 2022/5/5
 * Desc :
 */

@Composable
fun VideoScreen(data: Data) {

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Image(
            painter = rememberImagePainter(data.cover.blurred + "/thumbnail/1920x1080"),
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        VideoTop(data = data)
    }

}


@Composable
fun VideoTop(data: Data) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        val (video, title, date, description, icons) = createRefs()

        Text(
            text = "", modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .constrainAs(video) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }

        )


        Text(text = data.title,
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(video.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(top = 10.dp),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp)

        Text(
            text = "#" + data.type + "/" + DateUtil.format(
                data.author.latestReleaseTime,
                "yyyy/mm/dd HH:mm"
            ),
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(top = 10.dp)
                .constrainAs(date) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Text(
            text = data.description,
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(top = 10.dp)
                .constrainAs(description) {
                    top.linkTo(date.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })

        Row(modifier = Modifier
            .constrainAs(icons) {
                top.linkTo(description.bottom)
                start.linkTo(parent.start)
            }
            .padding(top = 10.dp)) {
            Legend(icon = R.mipmap.ic_like, msg = data.consumption.collectionCount.toString())
            Legend(icon = R.mipmap.ic_share_white, msg = data.consumption.shareCount.toString())
            Legend(icon = R.mipmap.ic_like, msg = data.consumption.replyCount.toString())
        }

    }
}

@Composable
fun Legend(icon: Int, msg: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(end = 10.dp)
    ) {
        Image(painter = rememberImagePainter(icon), contentDescription = null)
        Text(
            text = msg,
            color = Color.White,
            fontSize = 13.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 5.dp)
        )
    }
}