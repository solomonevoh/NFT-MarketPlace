package com.monstar.nftmarketplace.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monstar.nftmarketplace.R
import com.monstar.nftmarketplace.ui.theme.NFTMarketplaceTheme

@Composable
fun CategoryCard(title: String, image: Painter) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(27.dp))
            .border(
                BorderStroke(1.dp, Color.White.copy(0.1f)),
                shape = RoundedCornerShape(27.dp)
            )
            .height(186.dp)
            .width(280.dp)
    ) {

        Image(
            painter = image,
            contentDescription = "Card Background",
            modifier = Modifier.fillMaxSize()
        )
        Text(
            title,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        )
    }
}

@Preview
@Composable
fun PreviewCategoryCard() {
    NFTMarketplaceTheme {
        Column {
            CategoryCard("Art", painterResource(id = R.drawable.card_art))
            CategoryCard("Music", painterResource(id = R.drawable.card_music))
            CategoryCard("Virtual Worlds", painterResource(id = R.drawable.card_vw))
        }
    }
}