package com.dozenc.example.qrcodescanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

import com.dozenc.lib.qrcodescanner.QRCodeScannerActivity

class MainActivity : AppCompatActivity() {

    val QR_REQUEST_CODE = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.scanner_btn)

        btn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, QRCodeScannerActivity::class.java)
            startActivityForResult(intent,QR_REQUEST_CODE)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (QR_REQUEST_CODE == requestCode &&  RESULT_OK == resultCode){
            findViewById<TextView>(R.id.hello_world).text = data?.getStringExtra("result")
        }
    }
}