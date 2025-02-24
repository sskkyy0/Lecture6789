package com.example.lecture6

import android.annotation.SuppressLint
import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import com.example.lecture6.ui.theme.Lecture6Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val (text, setValue)= remember { // 값을 다시 할당하는 setter ???
                mutableStateOf("")
            }
            val scaffoldState = rememberBottomSheetScaffoldState()
            val scope = rememberCoroutineScope()
            val keyboardController = LocalSoftwareKeyboardController.current
            Scaffold { // 지금 여기서부터 뭔가 잘못됐어
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(
                        value = text, // 들어가는 값을 변수형태로 가지고 있어야 입력하는대로 바뀌겟지
                        onValueChange = { // 이벤트 처리?
                            setValue
                        }
                    )
                    Button(onClick = {
                        keyboardController?.hide()
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Hello $text")
                        }
                        // suspend 함수...는 코루틴에서 실행을 해야한다
                        //코루틴이 뭐애?
                    }) {
                        Text("클릭!")
                    }
                }
            }


        }
    }
}

