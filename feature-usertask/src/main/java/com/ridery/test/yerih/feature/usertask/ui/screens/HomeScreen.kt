package com.ridery.test.yerih.feature.usertask.ui.screens

import android.widget.Toast
import androidx.activity.compose.BackHandler
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
import com.ridery.test.yerih.core.ui.AlertDialogApp
import com.ridery.test.yerih.core.ui.FloatingButton
import com.ridery.test.yerih.core.ui.Font
import com.ridery.test.yerih.core.ui.ModalDrawerContent
import com.ridery.test.yerih.core.ui.RideryTestTheme
import com.ridery.test.yerih.feature.usertask.ui.presentation.HomeViewModel.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    userId: Int = 0,
    event: Flow<UiEvent> = Channel<UiEvent>().receiveAsFlow(),
    onSwipe: () -> Unit = {},
    onEditClicked: (Int) -> Unit = {},
    onLogOutClicked: () -> Unit = {},
    onBack: ()->Unit = {}
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    var dialogState by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    BackHandler {
        if(drawerState.isOpen) scope.launch { drawerState.close() }
        else dialogState = true
    }


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { ModalDrawerSheet {
                ModalDrawerContent(
                    onEditClicked = {onEditClicked(userId)},
                    onLogOutClicked = onLogOutClicked
                )
            }
        },
    ) {
        Scaffold(
            floatingActionButton = { FloatingButton(scope, drawerState) }
        ) { contentPadding ->
            HomeScreenContent(
                event = event,
                onSwipe = onSwipe,
                onBack = onBack,
                modifier = Modifier.padding(contentPadding)
            )
        }
    }

    if(dialogState) AlertDialogApp(
        title = "Do you want log out?",
        onOkClicked = onBack,
        onCancel = { dialogState = false }
    )


}

@Composable
fun HomeScreenContent(
    event: Flow<UiEvent> = Channel<UiEvent>().receiveAsFlow(),
    onSwipe: () -> Unit = {},
    onBack: ()->Unit = {},
    modifier: Modifier,
) {

    val context = LocalContext.current
    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }
    var refreshing by remember { mutableStateOf(false) }
    var username by remember{ mutableStateOf("") }
    var dialogState by remember { mutableStateOf(false) }


    LaunchedEffect(key1 = refreshing, key2 = event) {

        event.collect { uiEvent ->
            when (uiEvent) {
                is UiEvent.UpdateData -> username = uiEvent.username
                is UiEvent.ToastMsg -> Toast.makeText(context, uiEvent.msg, Toast.LENGTH_SHORT).show()
                UiEvent.SwipeFinish -> { refreshing = false; dialogState = true }
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
            val guideHorzLine = createGuidelineFromTop(0.5f)
            val guideForTitle = createGuidelineFromTop(0.15f)


            Text(
                text = "Welcome to home $username",
                style = Font.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(welcome) {
                    centerHorizontallyTo(parent)
                    centerAround(guideForTitle)
                })


            Box(modifier = Modifier
                .constrainAs(map) { centerAround(guideHorzLine) }
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

        if(dialogState) AlertDialogApp(
            title = "Your data is refreshed",
            onCancel = { dialogState = false },
            onOkClicked = { dialogState = false }
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    RideryTestTheme {
        HomeScreen()
    }
}

