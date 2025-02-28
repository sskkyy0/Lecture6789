package com.example.lecture6.lectures

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class StateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen(viewModel: MainViewModel2 = viewModel()) {
    val text1: MutableState<String> = remember { mutableStateOf("Hello World") }

    var text2 by remember { mutableStateOf("Hello World") }

    val (text: String, setText: (String) -> Unit) = remember {
        mutableStateOf("Hello World")
    }

    val text3: State<String> = viewModel.liveData.observeAsState("Hello World")
    Column() {
        Text("Hello World")
        Button(onClick = {
            text1.value = "변경"
            print(text1.value)
            text2 = "변경"
            print(text2)
            setText("변경")
            viewModel.changeValue("변경")
        }) {
            Text("클릭")
        }
        TextField(value = text, onValueChange = setText)
    }
}

class MainViewModel2 : ViewModel() {
    private val _value: MutableState<String> = mutableStateOf("Hello World") // 쓰기와 읽기 가능
    val value: State<String> = _value // 읽기만 가능

    private val _liveData= MutableLiveData<String>()
    val liveData: LiveData<String> = _liveData

    fun changeValue(value: String) {
        _value.value = value
    }
}