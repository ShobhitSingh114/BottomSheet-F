package com.example.bottomsheet_f

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.bottomsheet_f.ui.theme.BottomSheetFTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomSheetFTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BottomSheet()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet() {

    val sheetState = rememberModalBottomSheetState()
    // rememberSaveAble for screenRotation
//    var isSheetOpen by rememberSaveable {
//        mutableStateOf(false)
//    }
    var isSheetOpen by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                isSheetOpen = true
            }
        ) {
            Text(text = "Open Sheet")
        }
    }

    // if sheetOpen then only we wanna see the ModalBottomSheet
    if (isSheetOpen) {
        ModalBottomSheet(
            // sheetState = used for to control the visibility of the bottom sheet
            sheetState = sheetState,
            // onDismissRequest = this is called when we swipe it away or tap outside of the bottom sheet
            onDismissRequest = { isSheetOpen = false }
        ) {
            Image(painter = painterResource(id = R.drawable.kermit), contentDescription = "kermit")
        }
    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BottomSheetFTheme {

    }
}