package com.ridery.test.yerih.feature.usertask.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.ridery.test.yerih.core.ui.FloatingButton
import com.ridery.test.yerih.core.ui.Font
import com.ridery.test.yerih.core.ui.ModalDrawerContent
import com.ridery.test.yerih.core.ui.RideryTestTheme
import com.ridery.test.yerih.feature.usertask.ui.presentation.HomeViewModel.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
fun HomeScreen(
    user: String,
    event: Flow<UiEvent> = Channel<UiEvent>().receiveAsFlow(),
    onSwipe: () -> Unit = {},
    onEditClicked: () -> Unit = {},
    onLogOutClicked: () -> Unit = {},
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { ModalDrawerSheet {
                ModalDrawerContent(
                    onEditClicked = onEditClicked,
                    onLogOutClicked = onLogOutClicked
                )
            }
        },
    ) {
        Scaffold(
            floatingActionButton = { FloatingButton(scope, drawerState) }
        ) { contentPadding ->
            HomeScreenContent(
                user = user,
                event = event,
                onSwipe = onSwipe,
                modifier = Modifier.padding(contentPadding)
            )
        }
    }

}

@Composable
fun HomeScreenContent(
    user: String,
    userId: Int = 0,
    event: Flow<UiEvent> = Channel<UiEvent>().receiveAsFlow(),
    onSwipe: () -> Unit = {},
    modifier: Modifier,
) {

    val context = LocalContext.current
    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }
    var refreshing by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = refreshing, key2 = event) {

        event.collect { uiEvent ->
            when (uiEvent) {
                is UiEvent.ToastMsg -> Toast.makeText(context, uiEvent.msg, Toast.LENGTH_SHORT).show()

                UiEvent.SwipeFinish -> refreshing = false
            }
        }
    }

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = refreshing),
        onRefresh = { refreshing = true; onSwipe() },
        modifier = modifier
    ) {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
                .verticalScroll(rememberScrollState()),
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
}


@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    RideryTestTheme {
        HomeScreen(user = "name")
    }
}

