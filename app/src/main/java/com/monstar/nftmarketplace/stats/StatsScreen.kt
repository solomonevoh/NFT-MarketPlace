package com.monstar.nftmarketplace.stats

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.TrackChanges
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monstar.nftmarketplace.rankings
import com.monstar.nftmarketplace.ui.theme.NFTMarketplaceTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(modifier = Modifier.padding(bottom = 10.dp)) {
                        Text(
                            "Stats",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                },

                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        },
        containerColor = Color(33, 17, 52),

        ) {
        Column(
            modifier = Modifier
                .padding(bottom = 30.dp)
                .padding(top = 70.dp)
        ) {
            CustomTabComponent()
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(0.15f)
                ),
                elevation = CardDefaults.cardElevation(0.dp),
                border = BorderStroke(1.dp, Color.White.copy(0.5f)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(16.dp, 20.dp)
            ) {
                RankingTable(rankings)
            }

        }
    }
}

@Composable
fun CustomTabComponent() {
    var tabIndex by remember {
        mutableStateOf(0)
    }
    var tabData =
        listOf("Ranking" to Icons.Default.Assessment, "Activity" to Icons.Default.TrackChanges)

    TabRow(
        selectedTabIndex = tabIndex,
        containerColor = Color.Transparent,
        divider = {
            Divider(
                color = Color(66, 34, 104),
                thickness = 1.dp
            )
        },
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.customTabOffset(tabPositions[tabIndex]),
                height = 4.dp,
                color = Color(148, 103, 255)
            )
        }
    ) {
        tabData.forEachIndexed { index, pair ->
            Tab(selected = tabIndex == index, onClick = { tabIndex = index }) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = pair.second, contentDescription = null, tint = Color.White)
                    Text(
                        pair.first,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 17.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

fun Modifier.customTabOffset(tabPosition: TabPosition): Modifier = composed {
    val indicatorWidth = 118.dp
    val currentTabWidth = tabPosition.width
    val indicatorOffset by animateDpAsState(
        targetValue = tabPosition.left + currentTabWidth / 2 - indicatorWidth / 2,
        animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing)
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(indicatorWidth)
}

@Preview
@Composable
fun StatsScreenPreview() {
    NFTMarketplaceTheme {
        StatsScreen()
    }
}