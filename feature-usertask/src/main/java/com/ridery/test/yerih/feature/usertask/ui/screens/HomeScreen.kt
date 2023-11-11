package com.ridery.test.yerih.feature.usertask.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.ridery.test.yerih.core.domain.UserDomain
import com.ridery.test.yerih.core.ui.Font

@Composable
fun HomeScreen(
    user: String,
) {
    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
    ) {
        val (welcome, map) = createRefs()
        Text(
            text = "Welcome to home $user",
            style = Font.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.constrainAs(welcome) {
                top.linkTo(parent.top, 40.dp)
                centerHorizontallyTo(parent)
            })


        Box(modifier = Modifier
            .constrainAs(map) {
                centerHorizontallyTo(parent)
                top.linkTo(welcome.bottom, 40.dp)
            }
            .clip(RoundedCornerShape(30.dp))
        ) {

            GoogleMap(
                modifier = Modifier.size(400.dp, 200.dp),
                cameraPositionState = cameraPositionState
            ) {
                Marker(
                    state = MarkerState(position = singapore),
                    title = "Singapore",
                    snippet = "Marker in Singapore"
                )
            }

        }
    }
}