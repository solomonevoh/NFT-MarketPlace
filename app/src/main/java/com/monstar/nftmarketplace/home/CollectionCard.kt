package com.monstar.nftmarketplace.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.monstar.nftmarketplace.collections
import com.monstar.nftmarketplace.ui.theme.NFTMarketplaceTheme

@Composable
fun CollectionCard(title: String, image: Painter, likes: Int) {
Column
}

@Preview
@Composable

fun PreviewCollectionCard() {
    NFTMarketplaceTheme {
        CollectionCard(
            collections[0].title,
            painterResource(collections[0].image),
            collections[0].likes
        )
    }
}