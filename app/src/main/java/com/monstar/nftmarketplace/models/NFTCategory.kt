package com.monstar.nftmarketplace

import java.util.UUID

data class NFTCategory(
    val title : String,
    val image: Int,
    val id :UUID = UUID.randomUUID()
)

val categories = listOf<NFTCategory>(
    NFTCategory("Music", R.drawable.card_music),
    NFTCategory("Art", R.drawable.card_art),
    NFTCategory("Virtual World", R.drawable.card_vw)
)