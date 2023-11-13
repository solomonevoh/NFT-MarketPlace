package com.monstar.nftmarketplace

import java.util.UUID

data class Ranking(
    val title: String,
    val image: Int,
    var percentChange: Double = 0.0,
    var eth: Double = 0.0,
    val id: UUID = UUID.randomUUID()
)

var rankings = listOf<Ranking>(
    Ranking("Azumi", R.drawable.ranking01, 3.99, 200055.02),
    Ranking("Hape prime", R.drawable.ranking02, 33.79, 180055.45),
    Ranking("Crypto", R.drawable.ranking03, 3.99, 90055.62),
    Ranking("Ape Club", R.drawable.ranking04, 3.99, 88055.12),
    Ranking("Bat", R.drawable.ranking05, 3.99, 10055.86),
    Ranking("Mutant", R.drawable.ranking06, 3.99, 9095.27),
    Ranking("Metaverse", R.drawable.ranking07, 3.99, 2342.4),
    Ranking("Mountain", R.drawable.ranking08, 3.99, 2349024.53),
    Ranking("Mutant Ape", R.drawable.ranking05, 3.99, 93492.3),
    Ranking("The Mountain", R.drawable.ranking10, 3.99, 239802.3),

    )