package com.example.NoteApp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.NoteApp.R

@Composable
fun EmpthyAnimationComponent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            EmptyAnimation()


            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Tidak ada catatan",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onSecondary
            )
        }
    }
}

@Composable
fun EmptyAnimation() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.empty))

    LottieAnimation(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .semantics { contentDescription = "Empty Animation" },
        iterations = LottieConstants.IterateForever,
        composition = composition,
    )
}

@Composable
fun LoadingAnimationComponent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LoadingAnimation()

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Tunggu ya",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onSecondary
            )
        }
    }
}

@Composable
fun LoadingAnimation() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))

    LottieAnimation(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .semantics { contentDescription = "Empty Animation" },
        iterations = LottieConstants.IterateForever,
        composition = composition,
    )
}

@Composable
fun DividerTextComponent(){
    Row (modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(weight = 1f),
            color = MaterialTheme.colors.onSecondary,
            thickness = 1.dp
        )
        Text(text = " or " ,color = MaterialTheme.colors.onSecondary)
        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(weight = 1f),
            color = MaterialTheme.colors.onSecondary,
            thickness = 1.dp
        )
    }
}

//@Composable
//fun BoldTextComponent(Value :String){
//    Text(
//        text = Value,
//        modifier = Modifier
//            .fillMaxWidth()
//            .heightIn(androidx.compose.material3.MaterialTheme.dimens.small3),
//        style = TextStyle(
//            fontSize = androidx.compose.material3.MaterialTheme.typography.headlineLarge.fontSize,
//            fontWeight = FontWeight.Bold,
//            fontStyle = FontStyle.Normal
//        ),
//        color = normalTextColor,
//        textAlign = TextAlign.Center
//    )
//}