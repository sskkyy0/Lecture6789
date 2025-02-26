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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel


class ViewActivity: ComponentActivity(){
    private val viewModel by viewModels<MainViewModel> (  )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
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
                    viewModel.data.value = "World"
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
    val data = mutableStateOf("Hello")

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






