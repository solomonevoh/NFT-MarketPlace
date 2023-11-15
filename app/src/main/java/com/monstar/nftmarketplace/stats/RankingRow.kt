package com.monstar.nftmarketplace.stats


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monstar.nftmarketplace.R
import com.monstar.nftmarketplace.rankings
import com.monstar.nftmarketplace.ui.theme.NFTMarketplaceTheme

@Composable
fun RankingRow(
    index: Int,
    title: String,
    image: Painter,
    percentageChange: Double = 0.0,
    eth: Double = 0.0
) {
    Row(
        modifier = Modifier
            .border(
                BorderStroke(1.dp, color = Color.Transparent),
                shape = RoundedCornerShape(22.dp)
            )
            .padding(10.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            (index + 1).toString(),
            fontSize = 15.sp,
            color = Color(235, 235, 245).copy(0.6f),
            modifier = Modifier.padding(10.dp)
        )
        Image(
            image,
            contentDescription = "Ranking Image",
            modifier = Modifier
                .padding(vertical = 11.dp)
                .padding(end = 15.dp)
                .height(44.dp)
                .width(44.dp)
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp))
        )
        Column {
            Text(
                text = title,
                fontSize = 17.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "view info",
                fontSize = 13.sp,
                color = Color(235, 235, 245).copy(0.6f),
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(

            horizontalAlignment = Alignment.End
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_eth),
                    contentDescription = "Ethereum Icon",
                    modifier = Modifier.size(13.dp)
                )
                Text(
                    text = eth.toString(),
                    fontSize = 13.sp,
                    color = Color.White,
                    textAlign = TextAlign.Left
                )
            }


            Text(
                text = "$percentageChange%",
                fontSize = 13.sp,
                color = if (percentageChange > 0) {
                    Color.Green
                } else {
                    Color.Red
                }
            )
        }
    }
}

@Preview
@Composable
fun PreviewRankingRow() {
    NFTMarketplaceTheme {
        RankingRow(
            0,
            rankings[0].title,
            painterResource(rankings[0].image),
            rankings[0].percentChange,
            rankings[0].eth
        )
    }
}