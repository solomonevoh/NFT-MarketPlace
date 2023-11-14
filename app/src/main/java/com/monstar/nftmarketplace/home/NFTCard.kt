package com.monstar.nftmarketplace.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monstar.nftmarketplace.R
import com.monstar.nftmarketplace.nfts
import com.monstar.nftmarketplace.ui.theme.NFTMarketplaceTheme

@Composable
fun NFTCard(title: String, subTitle: String, image: Painter, likes: Int, eth: Double) {
    var isLiked by remember {
        mutableStateOf(false)
    }

    Column(

        modifier = Modifier
            .height(262.dp)
            .width(175.dp)
            .border(
                BorderStroke(1.dp, Color.White.copy(0.5f)),
                shape = RoundedCornerShape(30.dp)
            )
            .clip(
                RoundedCornerShape(30.dp)
            )
            .background(Color.White.copy(0.2f))
    ) {
        Image(
            painter = image,
            contentDescription = "",
            modifier = Modifier
                .height(155.dp)
                .width(155.dp)
                .padding(10.dp)
                .border(
                    BorderStroke(1.dp, color = Color.Transparent),
                    shape = RoundedCornerShape(27.dp)
                )
                .fillMaxSize()
                .clip(RoundedCornerShape(27.dp)),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .padding(bottom = 10.dp)
        ) {
            Text(
                text = "Wave",
                fontSize = 13.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Left
            )
            Text(
                text = "wav2 #5672",
                fontSize = 12.sp,
                color = Color(235, 235, 245).copy(0.6f),
                textAlign = TextAlign.Left
            )

        }
        Row(
            modifier = Modifier.padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_eth),
                    contentDescription = "Ethereum Icon",
                    modifier = Modifier.size(13.dp)
                )
                Text(
                    eth.toString(),
                    color = Color.White,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Left
                )
                Spacer(Modifier.weight(1f))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconToggleButton(checked = isLiked, onCheckedChange = {
                        isLiked = !isLiked
                    }, modifier = Modifier.size(13.dp)) {
                        Icon(
                            tint = if (isLiked) {
                                Color.Red
                            } else {
                                Color(235, 235, 245).copy(0.6f)

                            },
                            imageVector = if (isLiked) {
                                Icons.Filled.Favorite
                            } else {

                                Icons.Default.FavoriteBorder
                            },
                            contentDescription = "Favourite Button"
                        )
                    }
                }
                Text(
                    likes.toString(),
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Right,
                    color = Color(235, 235, 245).copy(0.6f)
                )
            }
        }

    }
}

@Preview
@Composable
fun PreviewNFTCard() {
    NFTMarketplaceTheme {
        NFTCard(
            nfts[0].title,
            nfts[0].subTitle,
            painterResource(nfts[0].image),
            nfts[0].likes,
            nfts[0].eth
        )
    }
}