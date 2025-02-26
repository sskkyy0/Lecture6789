package com.example.lecture6


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


class ViewActivity: ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            val viewModel = viewModel<MainViewModel>()
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    viewModel.data.value,
                    fontSize = 30.sp
                )
                Button(onClick = {
                    viewModel.changeValue()
                }) {
                    Text("변경")
                }

            }
        }
    }
}
// remember 없이도 mutableStateOf 되는 이유: 액티비티하고 생명주기를 같이 가져감
//이게 뭔소리냐

class MainViewModel : ViewModel(){
    private val _data = mutableStateOf("Hello")
    val data: State<String> = _data // 외부에서 수정 불가능
    fun changeValue(){
        _data.value = "World"
    }
}

@Composable
fun justScreen(){
    val data = remember{ mutableStateOf("Hello") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            data.value,
            fontSize = 30.sp
        )
        Button(onClick = {
            data.value = "World"
        }) {
            Text("변경")
        }

    }
}






