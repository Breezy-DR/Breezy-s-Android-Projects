package com.breezydr.shamelessselfpromo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import android.widget.TextView

class PreviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        val textViewMessage: TextView = findViewById(R.id.text_view_message)
        textViewMessage.setText("sssss")

    }
}