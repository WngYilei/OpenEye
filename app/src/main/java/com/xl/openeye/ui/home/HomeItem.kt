package com.xl.openeye.ui.home

import android.graphics.Paint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import com.xl.openeye.dataclass.Data
import com.xl.xl_base.tool.util.DateUtil
import com.xl.openeye.R

/**
 * @Author : wyl
 * @Date : 2022/4/27
 * Desc :
 */
@Composable
fun HomeItemVideo(data: Data, click: (data: Data) -> Unit) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
    ) {
        val (image, type, time, heard, title, name, share) = createRefs()
        Image(
            painter = rememberImagePainter(data.cover.feed),
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
            modifier = Modifier
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(3.dp))
                .height(200.dp)
                .clickable {
                    click(data)
                }
        )

        Box(
            modifier = Modifier
                .constrainAs(type) {
                    top.linkTo(image.top)
                    start.linkTo(image.start)
                }
                .width(50.dp)
                .height(50.dp)
                .padding(start = 5.dp, top = 5.dp)
                .clip(CircleShape)
                .alpha(0.5f)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = data.category
            )
        }

        Box(
            modifier = Modifier
                .constrainAs(time) {
                    bottom.linkTo(image.bottom)
                    end.linkTo(image.end)
                }
                .padding(bottom = 15.dp, end = 10.dp)
                .width(50.dp)
                .height(30.dp)
                .alpha(0.5f)
                .background(Color.White, shape = RoundedCornerShape(3.dp)),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = DateUtil.format(data.duration * 1000.toLong(), "HH:mm")
            )
        }


        Image(
            painter = rememberImagePainter(data.author.icon),
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
            modifier = Modifier
                .constrainAs(heard) {
                    top.linkTo(image.bottom)
                    start.linkTo(image.start)
                }
                .padding(top = 10.dp)
                .width(40.dp)
                .height(40.dp)
                .clip(CircleShape)
        )

        Text(
            text = data.title,
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(heard.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(top = 10.dp),
            fontSize = 14.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,//文字加粗
        )

        Text(
            text = data.author.name,
            modifier = Modifier
                .constrainAs(name) {
                    bottom.linkTo(heard.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            fontSize = 12.sp,
        )

        Icon(
            painter = rememberImagePainter(R.mipmap.ic_share),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(share) {
                    top.linkTo(heard.top)
                    bottom.linkTo(heard.bottom)
                    end.linkTo(image.end)
                }
                .padding(top = 10.dp)
                .width(20.dp)
                .height(20.dp)
        )

    }

}


@Composable
fun HomeItemText(data: String) {
    Text(
        text = data, textAlign = TextAlign.Center, fontSize = 18.sp,
        color = Color.Black,
        fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth()
    )
}
