package net.noble.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.noble.notes.ui.theme.AppTheme
import java.text.NumberFormat
/*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.noble.notes.ui.theme.NotesTheme
*/
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.App
                ) {
                    //bodymain()
                    //newnotes()
                    newtask()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun newtask(){
    var name by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(30.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Row{
            TextField(value = name, onValueChange = {
                name = it },maxLines = 1,modifier = Modifier.width(325.dp),
                placeholder = { Text("Titulo de tarea") })
        }
        Row{
            Text("Hora y fecha tarea")
            //Text(text = "Hora de la nota")
        }

        Row{
            var description by remember{
                mutableStateOf("")
            }
            TextField(value = description, onValueChange = {
                description = it},maxLines = 15,modifier = Modifier.width(325.dp)
                , placeholder = { Text("Description") })
        }


    }
}
/*
@ExperimentalMaterial3Api
@Composable
fun DatePicker(
    state: DatePickerState,
    modifier: Modifier = Modifier,
    dateFormatter: DatePickerFormatter = remember { DatePickerDefaults.dateFormatter() },
    title: (@Composable () -> Unit)? = {
        DatePickerDefaults.DatePickerTitle(
            displayMode = state.displayMode,
            modifier = Modifier.padding(DatePickerTitlePadding)
        )
    },
    headline: (@Composable () -> Unit)? = {
        DatePickerDefaults.DatePickerHeadline(
            selectedDateMillis = state.selectedDateMillis,
            displayMode = state.displayMode,
            dateFormatter = dateFormatter,
            modifier = Modifier.padding(DatePickerHeadlinePadding)
        )
    },
    showModeToggle: Boolean = true,
    colors: DatePickerColors = DatePickerDefaults.colors()
) {
}
*/


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun newnotes() {
    var name by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(30.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Row{
            TextField(value = name, onValueChange = {
                name = it},maxLines = 1,modifier = Modifier.width(325.dp),
             placeholder = { Text("Titulo de nota") })
        }
        Row{
            Text("Hora y fecha nota")
                //Text(text = "Hora de la nota")
            }

        Row{
            var description by remember{
                mutableStateOf("")
            }
            TextField(value = description, onValueChange = {
                description = it},maxLines = 15,modifier = Modifier.width(325.dp)
            , placeholder = { Text("Description") })



        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun bodymain() {
    var name by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .padding(5.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row{
            TextField(value = name, onValueChange = {
                name = it },modifier = Modifier.width(375.dp),
                placeholder = { Text("Buscar") })

        }
    }
    Column(
        modifier = Modifier/*Modifier.fillMaxSize()*//*Modifier.size(250.dp, 100.dp)*//*Modifier*/
            .padding(65.dp)
            .verticalScroll(rememberScrollState()),
        ) {
        Row (verticalAlignment = Alignment.Top,
             //horizontalArrangement = Arrangement.spacedBy(space = 1.dp)
            //horizontalArrangement = Arrangement.SpaceBetween
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Todo")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Notas")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Tareas")
            }
        }


    }
    /*
    LazyColumn {
        // Add a single item
        item {
            Text(text = "First item")
        }

        // Add 5 items
        items(5) { index ->
            Text(text = "Item: $index")
        }

        // Add another single item
        item {
            Text(text = "Last item")
        }
    }
    */


    //Text(text = "Hello World")
    Canvas(modifier = Modifier.size(200.dp, 100.dp)/*Modifier.fillMaxSize()*/) {
        val rectColor = Color.LightGray
        val rectSize = Size(950f, 200f)
        val rectTopLeft = Offset(50f, 50f)

        val espace = 270f
        val marg = 15f


        //drawIntoCanvas { canvas ->
            translate(left = marg, top = espace) {
                drawRoundRect(
                    color = rectColor,
                    topLeft = rectTopLeft,
                    size = rectSize,
                    cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx())
                )
            }
            translate(left = marg, top = (espace*2)) {
                drawRoundRect(
                    color = rectColor,
                    topLeft = rectTopLeft,
                    size = rectSize,
                    cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx())
                )
            }

            translate(left = marg, top = (espace*3)) {
                drawRoundRect(
                    color = rectColor,
                    topLeft = rectTopLeft,
                    size = rectSize,
                    cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx())
                )
            }

            translate(left = marg, top = (espace*4)) {
                drawRoundRect(
                    color = rectColor,
                    topLeft = rectTopLeft,
                    size = rectSize,
                    cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx())
                )
            }

            translate(left = marg, top = (espace*5)) {
                drawRoundRect(
                    color = rectColor,
                    topLeft = rectTopLeft,
                    size = rectSize,
                    cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx())
                )
            }

            translate(left = marg, top = (espace*6)) {
                drawRoundRect(
                    color = rectColor,
                    topLeft = rectTopLeft,
                    size = rectSize,
                    cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx())
                )
            }

            translate(left = marg, top = (espace*7)) {
                drawRoundRect(
                    color = rectColor,
                    topLeft = rectTopLeft,
                    size = rectSize,
                    cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx())
                )
            }
            /*
        val canvasQuadrantSize = size / 2F
        translate(left = 75f, top = 250f) {
            inset(horizontal = 70f, vertical = 70f) {
                drawRect(color = Color.Green, size(200f, 100f)/*canvasQuadrantSize*/,alpha = 0.3f, /*cornerRadius =*/ )
                //drawRect(30, 5, Color.Red);
            }
            */


        }

    //}


    Column(
        modifier = Modifier
            .padding(5.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(onClick = {}) {
            Text(text = "+")
        }
    }

}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        Greeting("Android")
    }
}