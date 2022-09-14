package com.example.breakingbadcompose.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.breakingbadcompose.R
import com.example.breakingbadcompose.ui.theme.*
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ProfileScreen(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .background(color = bb_background)
            .fillMaxSize(), contentAlignment = Alignment.TopCenter
    ) {

        Column {
            //img
            val img = R.drawable.ic_brba_splash
            val painter = rememberImagePainter(data = img)
            Image(
                modifier = Modifier
                    .padding(top = 64.dp)
                    .size(200.dp)
                    .clip(CircleShape)
                    .border(width = 4.dp, color = bb_active_color, shape = CircleShape)
                    .fillMaxWidth()
                    .background(color = bb_control_color),
                painter = painter,
                contentDescription = "profile picture",
            )

            Text(
                fontSize = MaterialTheme.typography.h5.fontSize,
                text = "Name",
                color = bb_white,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(top = 32.dp)
            )
            Text(
                fontSize = MaterialTheme.typography.h6.fontSize,
                text = "Email",
                color = bb_white,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.padding(64.dp))

//            LogoWithText(logo = R.drawable.ic_baseline_language_24, txt = "Language",1, onClick = onClick )
//           Divider(color = bb_control_color, thickness = 2.dp)
            LogoWithText(logo = R.drawable.ic_baseline_login_24, txt = "Login", onClick=onClick )

        }


    }
}

@Composable
fun LogoWithText(logo: Int, txt: String, num:Int=0, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(top = if (num==1)128.dp else 8.dp), contentAlignment = Alignment.CenterStart,

    ) {

        Image(
            painter = rememberImagePainter(data = logo),
            contentDescription = "_",
            modifier = Modifier
                .padding(start = 32.dp)
                .size(30.dp),
        )
        Text(
            text = txt,
            modifier = Modifier
                .padding(start = 80.dp)
                .clickable { onClick() },
            color = bb_white,

        )

    }

}

//
//@Composable
//@Preview
//fun ProfileScreenPreview() {
//    ProfileScreen {
//
//    }
//}