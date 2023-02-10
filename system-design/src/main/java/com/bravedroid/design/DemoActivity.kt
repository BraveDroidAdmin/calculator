package com.bravedroid.design

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.bravedroid.design.DemoActivity.Companion.WITH_SHOWING_LOW_PERFORMANCE
import com.bravedroid.design.ui.theme.CalculatorTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@AndroidEntryPoint
class DemoActivity : ComponentActivity() {
    companion object {
        //activate this flag and check the LayoutInspector when recomposition occurs everytime a new values from textField
        const val WITH_SHOWING_LOW_PERFORMANCE = true
    }

    private val vm by viewModels<StateViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {

                        StateManagingLayout(vm.uiState, vm.name, vm.nameList) { nameToAdd ->
                            Toast.makeText(this@DemoActivity, "Add: $nameToAdd", Toast.LENGTH_SHORT)
                                .show()
                        }

                        BoxColors()
                    }
                }
            }
        }
    }
}

@HiltViewModel
class StateViewModel @Inject constructor() : ViewModel() {
    val uiState: MutableState<UiState> = mutableStateOf(
        UiState.Default
    )
    val name: MutableState<String> = mutableStateOf(
        ""
    )
    val nameList: MutableState<List<String>> = mutableStateOf(
        listOf()
    )
    var colorPen = mutableStateOf(1)

    fun update(it: Int) {
        colorPen.value = (it)

    }
}

@Composable
fun StateManagingLayout(
    state: MutableState<UiState>,
    nameState: MutableState<String>,
    nameListState: MutableState<List<String>>,
    onAddName: (nameToAdd: String) -> Unit = {},
) {
    var uiState: UiState by remember {
        state
    }
    var name: String by remember {
        nameState
    }
    var nameList: List<String> by remember {
        nameListState
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Red.copy(alpha = .2f))
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {

        Row(modifier = Modifier) {
            Text(
                modifier = Modifier.padding(end = 20.dp),
                text = "Please enter a name: "
            )
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = if (WITH_SHOWING_LOW_PERFORMANCE) uiState.name else name,

                onValueChange = {
                    if (WITH_SHOWING_LOW_PERFORMANCE) uiState = uiState.copy(name = it) else name =
                        it
                })
            Button(
                modifier = Modifier.padding(start = 20.dp),
                onClick = {
                    if (WITH_SHOWING_LOW_PERFORMANCE) {
                        if (uiState.name.isNotBlank()) {
                            onAddName(uiState.name)
                            uiState = uiState.copy(
                                name = "",
                                nameList = uiState.nameList + uiState.name,
                            )
                        }
                    } else {
                        if (name.isNotBlank()) {
                            onAddName(name)

                            nameList = nameList + name
                            name = ""

                        }
                    }
                },
            ) {
                Text(text = "Add")
                Icon(imageVector = Icons.Default.Add, contentDescription = "ADD")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = .2f)),
        ) {
            item {
                Text(
                    modifier = Modifier
                        .background(Color(0x1D03A9F4))
                        .padding(start = 16.dp),
                    text = "\uD83C\uDFC6 My added names: ",
                    color = Color(0xFF012B3D)
                )
            }
            if (WITH_SHOWING_LOW_PERFORMANCE) {
                items(uiState.nameList) { current ->
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = current,
                    )
                }
            } else {
                items(nameList) { current ->
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = current,
                    )
                }
            }
        }
    }
}

@Stable
enum class ColorType {
    Green,
    Red,
    Blue,
}

@Composable
fun BoxColors() {
    var colorPen by remember {
        mutableStateOf(1)
    }
    Row(modifier = Modifier.fillMaxWidth()) {
        Button(
            {
                // onBoxClick(1)
                colorPen = 1
            },
            Modifier
                .height(100.dp)
                .weight(1f)
                .background(Color.Green),
        ) { Text(text = ("Green")) }
        Button(
            {
                // onBoxClick(2)
                colorPen = 2
            }, Modifier
                .height(100.dp)
                .weight(1f)
                .background(Color.Red)

        ) {
            Text(text = "Red")
        }
        Button(
            {
                //onBoxClick(3)
                colorPen = (3)
            },
            Modifier
                .height(100.dp)
                .weight(1f)
                .background(Color.Blue),
        ) {
            Text(text = "Blue")
        }

        Box(
            Modifier
                .height(100.dp)
                .weight(1f)
                .background(Color.Gray)
                .clickable {
                    colorPen = (4)


                }
        )
        Box(
            Modifier
                .height(100.dp)
                .weight(1f)
                .background(
                    when (colorPen) {
                        1 -> Color.Green
                        2 -> Color.Red
                        3 -> Color.Blue
                        4 -> Color.Gray
                        else -> Color.Cyan
                    }
                )

        )
    }
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(
            Modifier
                .height(100.dp)
                .weight(.3f)
                .background(Color.Black)
        ) {
            Text(
                text = "DummyText",
                color = Color.Gray,
                modifier = Modifier.background(
                    when (colorPen) {
                        1 -> Color.Green
                        2 -> Color.Red
                        else -> Color.Blue
                    }
                )
            )
        }
    }
}

data class UiState(
    val name: String,
    val nameList: List<String>,
) {
    companion object {
        val Default = UiState("", listOf())
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalculatorTheme {
        Column(modifier = Modifier.fillMaxWidth()) {

            StateManagingLayout(
                mutableStateOf(UiState.Default),
                mutableStateOf(""),
                mutableStateOf(listOf()),
            ) {}

            var colorPen by remember {
                mutableStateOf(Color.White)
            }


            BoxColors()
        }
    }
}


