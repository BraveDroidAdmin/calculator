package com.bravedroid.design

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
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
import com.bravedroid.design.ui.theme.CalculatorTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@AndroidEntryPoint
class DemoActivity : ComponentActivity() {
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
                    StateManagingLayout(vm.uiState) { nameToAdd ->
                        Toast.makeText(this@DemoActivity, "Add: $nameToAdd", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }
}

@HiltViewModel
class StateViewModel @Inject constructor() : ViewModel() {
    var uiState: MutableState<UiState> = mutableStateOf(
        UiState.Default
    )
}

@Composable
fun StateManagingLayout(
    state: MutableState<UiState>,
    onAddName: (nameToAdd: String) -> Unit = {},
) {

    var uiState: UiState by remember {
        state
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
                value = uiState.name,
                onValueChange = {
                    uiState = uiState.copy(name = it)
                })
            Button(
                modifier = Modifier.padding(start = 20.dp),
                onClick = {
                    if (uiState.name.isNotBlank()) {
                        onAddName(uiState.name)
                        uiState = uiState.copy(
                            name = "",
                            nameList = uiState.nameList + uiState.name,
                        )
                    }
                }) {
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
            items(uiState.nameList) { current ->
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = current,
                )
            }
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
        StateManagingLayout(mutableStateOf(UiState.Default)) {}
    }
}


