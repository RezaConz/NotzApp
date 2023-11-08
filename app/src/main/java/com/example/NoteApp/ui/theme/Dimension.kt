package com.example.NoteApp.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimension(
    val extraSmall: Dp = 0.dp,
    val small1: Dp = 0.dp,
    val small2: Dp = 0.dp,
    val small3: Dp = 0.dp,
    val medium1: Dp = 0.dp,
    val medium2: Dp = 0.dp,
    val medium3: Dp = 0.dp,
    val large: Dp = 0.dp,
    val buttonHeight: Dp = 40.dp,
    val logoSize: Dp = 42.dp,
    val superLarge: Dp = 0.dp
)

val CompactSmallDimens = Dimension(
    small1 = 6.dp,
    small2 = 5.dp,
    small3 = 8.dp,
    medium1 = 15.dp,
    medium2 = 26.dp,
    medium3 = 30.dp,
    large = 45.dp,
    buttonHeight = 30.dp,
    logoSize = 36.dp,
    superLarge = 100.dp
)

val CompactMediumDimens = Dimension(
    small1 = 8.dp,
    small2 = 13.dp,
    small3 = 17.dp,
    medium1 = 25.dp,
    medium2 = 30.dp,
    medium3 = 35.dp,
    large = 65.dp,
    superLarge = 150.dp
)

val CompactDimens = Dimension(
    small1 = 10.dp,
    small2 = 15.dp,
    small3 = 20.dp,
    medium1 = 30.dp,
    medium2 = 36.dp,
    medium3 = 40.dp,
    large = 80.dp,
    superLarge = 170.dp
)

val MediumDimens = Dimension(
    small1 = 10.dp,
    small2 = 15.dp,
    small3 = 20.dp,
    medium1 = 30.dp,
    medium2 = 36.dp,
    medium3 = 40.dp,
    large = 110.dp,
    logoSize = 55.dp,
    superLarge = 180.dp
)

val ExpandedDimens = Dimension(
    small1 = 15.dp,
    small2 = 20.dp,
    small3 = 25.dp,
    medium1 = 35.dp,
    medium2 = 30.dp,
    medium3 = 45.dp,
    large = 130.dp,
    logoSize = 72.dp,
    superLarge = 150.dp
)
