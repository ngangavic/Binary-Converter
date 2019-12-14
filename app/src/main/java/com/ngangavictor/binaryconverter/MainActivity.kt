package com.ngangavictor.binaryconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var spinner: Spinner
    lateinit var textViewResult:TextView
    lateinit var type:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText=findViewById(R.id.editText)
        spinner=findViewById(R.id.spinner)
        textViewResult=findViewById(R.id.textViewResult)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent != null) {
                    type = parent.getItemAtPosition(position).toString()
                    if(type=="Binary Coded Decimal"){
                        getBinary("Binary Coded Decimal")
                    }else{
                        getBinary("nothing")
                    }
                }
            }

        }
    }

    private fun getBinary(convertType:String){
        if (convertType=="Binary Coded Decimal") {
            val binaryList = resources.getStringArray(R.array.binary)[10]
            textViewResult.text = binaryList.toString()
           // val a = convertType in arrayOf(binaryList)
        }else{
            textViewResult.text="No result"
        }
    }



}
