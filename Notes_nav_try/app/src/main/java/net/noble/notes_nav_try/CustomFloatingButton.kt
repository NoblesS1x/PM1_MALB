package com.jai.multifabbutton.compose

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.animation.core.*
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
//import net.noble.notes_nav_try.ui.theme
//import com.jai.multifabbutton.ui.theme.Gray80
//import com.jai.multifabbutton.ui.theme.blue


//Declaracion y creacion del boton flotante
/*
@Composable
@Preview
fun FloatingButton(){
    FloatingActionButton(onClick = {},
        shape = CircleShape,
        containerColor = blue,
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 8.dp
        )
    ) {
        Icon(
            painter = painterResource(id = com.jai.multifabbutton.R.drawable.ic_fab_add),
            contentDescription = null,
            tint = Color.White
        )
    }
}


@Preview
@Composable
fun ViewMultiFloatingButton(){
    MultiFloatingActionButton(fabIcon = painterResource(id =com.jai.multifabbutton.R.drawable.ic_fab_add), items = arrayListOf(FabItem(icon =  painterResource(id = com.jai.multifabbutton.R.drawable.ic_fab_add), label = "",{})))
}


//Clase enumeracion de estados del boton flotante
enum class MultiFabState {
    COLLAPSED, EXPANDED
}
class FabItem(
    val icon: Painter,
    val label: String,
    val onFabItemClicked: () -> Unit
)


//Accion de boton y comportamiento 
@Composable
fun MultiFloatingActionButton(
    fabIcon: Painter,
    items: List<FabItem>,
    showLabels: Boolean = true,
    onStateChanged: ((state: MultiFabState) -> Unit)? = null
) {
    var currentState by remember { mutableStateOf(MultiFabState.COLLAPSED) }
    val stateTransition: Transition<MultiFabState> =
        updateTransition(targetState = currentState, label = "")
    val stateChange: () -> Unit = {
        currentState = if (stateTransition.currentState == MultiFabState.EXPANDED) {
            MultiFabState.COLLAPSED
        } else MultiFabState.EXPANDED
        onStateChanged?.invoke(currentState)
    }
    val rotation: Float by stateTransition.animateFloat(
        transitionSpec = {
            if (targetState == MultiFabState.EXPANDED) {
                spring(stiffness = Spring.StiffnessLow)
            } else {
                spring(stiffness = Spring.StiffnessMedium)
            }
        },
        label = ""
    ) { state ->
        if (state == MultiFabState.EXPANDED) 45f else 0f
    }
    val isEnable = currentState == MultiFabState.EXPANDED

    BackHandler(isEnable) {
        currentState = MultiFabState.COLLAPSED
    }

    val modifier = if(currentState ==   MultiFabState.EXPANDED)
        Modifier
            .fillMaxSize()
            .clickable(indication = null,
                interactionSource = remember { MutableInteractionSource() }) {
                currentState = MultiFabState.COLLAPSED
            } else Modifier.fillMaxSize()

    Box(modifier = modifier, contentAlignment = Alignment.BottomEnd) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            if (currentState == MultiFabState.EXPANDED) {
                Canvas(modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        scaleX = 2.2f
                        scaleY = 2.1f
                    }) {
                    translate(150f, top = 300f) {
                        scale(5f) {}
                        drawCircle(Gray80, radius = 200.dp.toPx())

                    }
                }
            }
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom,
            ) {
                items.forEach { item ->
                    SmallFloatingActionButtonRow(
                        item = item,
                        stateTransition = stateTransition,
                        showLabel = showLabels
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
                FloatingActionButton(
                    shape = CircleShape,
                    containerColor = blue,
                    onClick = {
                        stateChange()
                    }) {
                    Icon(
                        painter = fabIcon,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.rotate(rotation)
                    )
                }
            }

        }
    }

    }

//Boton flotante hijo del boton flotante padre
@Composable
fun SmallFloatingActionButtonRow(
    item: FabItem,
    showLabel: Boolean,
    stateTransition: Transition<MultiFabState>
) {
    val alpha: Float by stateTransition.animateFloat(
        transitionSpec = {
            tween(durationMillis = 50)
        }, label = ""
    ) { state ->
        if (state == MultiFabState.EXPANDED) 1f else 0f
    }
    val scale: Float by stateTransition.animateFloat(
        label = ""
    ) { state ->
        if (state == MultiFabState.EXPANDED) 1.0f else 0f
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .alpha(animateFloatAsState((alpha), label = "").value)
            .scale(animateFloatAsState(targetValue = scale, label = "").value)
    ) {
        if (showLabel) {
            Text(
                text = item.label,
                modifier = Modifier
                    .padding(start = 6.dp, end = 6.dp, top = 4.dp, bottom = 4.dp)
                    .clickable(onClick = { item.onFabItemClicked() })
            )
        }
        SmallFloatingActionButton(
            shape = CircleShape,
            modifier = Modifier
                .padding(4.dp),
            onClick = { item.onFabItemClicked() },
            containerColor = blue,
            contentColor = Color.White
        ) {
            Icon(
                painter = item.icon,
                contentDescription = item.label
            )
        }
    }
}
 */