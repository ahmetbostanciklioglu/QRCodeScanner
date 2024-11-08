package com.qr.code.scanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import com.qr.code.scanner.ui.theme.QRCodeScannerTheme

const val URL_KEY: String = "UrlKey"

class MainActivity : ComponentActivity() {

    private var urlText by mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QRCodeScannerTheme(useSystemUIController = true) {
                QRCodeScannerScreen(urlText = urlText, onUrlTextUpdate = { urlText = it })
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(URL_KEY, urlText)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val restoreUrlText = savedInstanceState.getString(URL_KEY)

        if (restoreUrlText != null) urlText = restoreUrlText
    }
}



