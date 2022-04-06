package com.example.fakecalci

import android.Manifest.permission.READ_CONTACTS
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.fakecalci.ui.theme.FakeCalciTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var number = "0"
            if(intent.getStringExtra("number")!=null){
                number = intent.getStringExtra("number")
                as String
            }
            checkPermission()

            FakeCalciTheme {
                MainUI(number)
            }
        }
    }

    private fun checkPermission() {
        val checkPermission = ContextCompat.checkSelfPermission(this,
        android.Manifest.permission.READ_CONTACTS)
        if(checkPermission == PackageManager.PERMISSION_GRANTED) return
        else {
            ActivityCompat.requestPermissions(this, arrayOf(
                android.Manifest.permission.READ_CONTACTS), 1)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            1->{
                if(grantResults.size>=0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) return
                else Toast.makeText(this, "You don't have permission", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


