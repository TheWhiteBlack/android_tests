package com.ridery.test.yerih.feature.usertask.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
import com.ridery.test.yerih.feature.usertask.ui.viewmodels.HomeViewModel.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    user: String,
    event: Flow<UiEvent> = Channel<UiEvent>().receiveAsFlow(),
    onSwipe: ()->Unit = {},
    onEditClicked: ()->Unit = {},
    onLogOutClicked: ()->Unit = {},
) {
    val context = LocalContext.current
    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }
    var refreshing by remember { mutableStateOf(false) }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = refreshing, key2 = event) {
        if (refreshing) {
            delay(1500)
            refreshing = false
        }

        event.collect{uiEvent ->
            when(uiEvent){
                is UiEvent.ToastMsg -> Toast.makeText(context, uiEvent.msg, Toast.LENGTH_SHORT).show()
            }
        }
    }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { ModalDrawerSheet { ModalDrawerContent() } },
    ) {
        Scaffold(
            floatingActionButton = { FloatingButton(scope, drawerState) }
        ) { contentPadding ->
            // Screen content
            Box(modifier = Modifier.padding(contentPadding))
        }
    }

//    SwipeRefresh(
//        state = rememberSwipeRefreshState(isRefreshing = refreshing),
//        onRefresh = { refreshing = true; onSwipe() },
//    ) {
//
//        ConstraintLayout(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(horizontal = 30.dp)
//                .verticalScroll(rememberScrollState()),
//        ) {
//            val (welcome, map) = createRefs()
//            Text(
//                text = "Welcome to home $user",
//                style = Font.titleLarge,
//                textAlign = TextAlign.Center,
//                modifier = Modifier.constrainAs(welcome) {
//                    top.linkTo(parent.top, 40.dp)
//                    centerHorizontallyTo(parent)
//                })
//
//
//            Box(modifier = Modifier
//                .constrainAs(map) {
//                    centerHorizontallyTo(parent)
//                    top.linkTo(welcome.bottom, 40.dp)
//                }
//                .clip(RoundedCornerShape(30.dp))
//            ) {
//
//                GoogleMap(
//                    modifier = Modifier.size(400.dp, 200.dp),
//                    cameraPositionState = cameraPositionState
//                ) {
//                    Marker(
//                        state = MarkerState(position = singapore),
//                        title = "Singapore",
//                        snippet = "Marker in Singapore"
//                    )
//                }
//
//            }
//
//        }
//    }



}