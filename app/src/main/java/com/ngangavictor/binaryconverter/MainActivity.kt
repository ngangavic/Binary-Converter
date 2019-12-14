package com.ngangavictor.binaryconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var spinner: Spinner
    lateinit var textViewResult:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText=findViewById(R.id.editText)
        spinner=findViewById(R.id.spinner)
        textViewResult=findViewById(R.id.textViewResult)
    }



}
