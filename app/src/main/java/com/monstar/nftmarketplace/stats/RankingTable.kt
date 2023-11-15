package com.monstar.nftmarketplace.stats

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.monstar.nftmarketplace.rankings
import com.monstar.nftmarketplace.ui.theme.NFTMarketplaceTheme

@Composable
fun RankingList() {
    LazyColumn(
        modifier = Modifier.padding(vertical = 30.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(rankings) { ranking ->
            RankingRow(
                ranking.title,
                painterResource(ranking.image),
                ranking.percentChange,
                ranking.eth
            )
        }
    }
}

@Preview
@Composable
fun PreviewRankingList() {
    NFTMarketplaceTheme {
        RankingList()
    }
}