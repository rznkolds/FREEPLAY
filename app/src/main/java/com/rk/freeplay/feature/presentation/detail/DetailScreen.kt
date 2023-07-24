package com.rk.freeplay.feature.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.rk.freeplay.R

@Composable
fun DetailScreen(
    id: Int?,
    viewModel: DetailViewModel = hiltViewModel()
) {
    if (id != null) viewModel.getGameDetail(id)

    val state = viewModel.state.value.details

    state?.also {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = state.thumbnail,
                    builder = {
                        placeholder(R.drawable.picture)
                        crossfade(true)
                    }
                ),
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp)),
                contentDescription = "Game Picture",
                contentScale = ContentScale.Crop
            )

            Text(
                text = it.title!!,
                fontSize = 20.sp,
                color = Color.Red,
                fontWeight = FontWeight.Bold,
            )

            Divider(
                color = Color.Red,
                modifier = Modifier
                    .height(2.dp)
                    .fillMaxWidth(),
            )

            Requirements(
                title = "About : ",
                description = it.description!!
            )

            Text(
                text = "System Requirements :",
                color = Color.Red,
                modifier = Modifier.padding(top = 10.dp)
            )

            Divider(
                color = Color.Red,
                modifier = Modifier
                    .height(2.dp)
                    .fillMaxWidth(),
            )

            Requirements(
                title = "OS : ",
                description = it.requirements?.os!!
            )

            Requirements(
                title = "GPU : ",
                description = it.requirements.processor!!
            )

            Requirements(
                title = "RAM : ",
                description = it.requirements.memory!!
            )

            Requirements(
                title = "DISPLAY CARD :",
                description = it.requirements.graphics!!
            )

            Text(
                text = "Screenshots :",
                color = Color.Red,
                modifier = Modifier.padding(top = 10.dp)
            )

            Divider(
                color = Color.Red,
                modifier = Modifier
                    .height(2.dp)
                    .fillMaxWidth(),
            )

            if (!it.pictures.isNullOrEmpty()) {

                LazyRow {
                    items(it.pictures) {
                        Row (
                            modifier = Modifier
                                .height(200.dp)
                                .width(300.dp)
                                .padding(10.dp)
                        ) {
                            Image(
                                painter = rememberImagePainter(
                                    data = it.image,
                                    builder = {
                                        placeholder(R.drawable.picture)
                                        crossfade(true)
                                    }
                                ),
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(
                                        RoundedCornerShape(10.dp)
                                    ),
                                contentScale = ContentScale.FillBounds,
                                contentDescription = "Game Picture"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Requirements(title:String, description: String) {
    Column {
        Text(
            text = title,
            modifier = Modifier.padding(top = 10.dp)
        )

        Text(
            text = description,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun DetailScreenPreview() {
    DetailScreen(8)
}