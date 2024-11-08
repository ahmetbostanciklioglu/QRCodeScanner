package com.qr.code.scanner

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QRCodeScannerScreen(
    urlText: String,
    onUrlTextUpdate: (String) -> Unit
) {
    var statusText by remember { mutableStateOf("") }
    val context = LocalContext.current

    PermissionRequestDialog(
        permission = Manifest.permission.CAMERA,
        onResult = { isGranted ->
            statusText = if (isGranted) {
                "Scan QR code now!"
            } else {
                "No camera permission!"
            }
        }
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = statusText, fontWeight = FontWeight.SemiBold, fontSize = 30.sp)
        Spacer(modifier = Modifier.height(5.dp))
        CameraPreview { url ->
            onUrlTextUpdate(url)
        }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = urlText,
            onValueChange = { },
            label = { Text("Detected URL") },
            readOnly = true
        )

        Spacer(modifier = Modifier.height(5.dp))
        Button(
            onClick = {
                launchUrl(context = context, urlText = urlText)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Launch",
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp
            )
        }
    }
}

private fun launchUrl(context: Context, urlText: String) {
    val uri: Uri = Uri.parse(urlText)

    val intent = Intent(Intent.ACTION_VIEW, uri).apply { setPackage("com.android.chrome") }

    try {
        context.startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        intent.setPackage(null)

        try {
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {  }
    }
}