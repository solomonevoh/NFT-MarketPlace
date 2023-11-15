package com.monstar.nftmarketplace.stats


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun RankingCard(title: String, image: Painter, percentageChange: Double = 0.0, eth: Double = 0.0) {
    Row(
        modifier = Modifier
            .border(
                BorderStroke(1.dp, color = Color.Transparent),
                shape = RoundedCornerShape(22.dp)
            )
            .padding(10.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            image,
            contentDescription = "Ranking Image",
            modifier = Modifier
                .size(30.dp)
                .fillMaxSize()
                .padding(2.dp)
                .border(
                    BorderStroke(1.dp, color = Color.Transparent),
                    shape = RoundedCornerShape(22.dp)
                )
        )
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(text = title, fontSize = 13.sp, color = Color.White, textAlign = TextAlign.Left)
            Text(
                text = "view info",
                fontSize = 8.sp,
                color = Color.White.copy(0.5f),
                textAlign = TextAlign.Left
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.End
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
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
                fontSize = 8.sp,
                color = if (percentageChange > 0) {
                    Color.Green
                } else {
                    Color.Red

                },
                textAlign = TextAlign.Left
            )
        }
    }
}

@Preview
@Composable
fun PreviewRankingCard() {
    NFTMarketplaceTheme {
        RankingCard(
            rankings[0].title,
            painterResource(rankings[0].image),
            rankings[0].percentChange,
            rankings[0].eth
        )
    }
}