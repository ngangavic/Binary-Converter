package com.ngangavictor.binaryconverter

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var spinner: Spinner
    lateinit var textViewResult: TextView
    lateinit var type: String

    var binary = arrayOf(
        "01100001",
        "01100010",
        "01100011",
        "01100100",
        "01100101",
        "01100110",
        "01100111",
        "01101000",
        "01101001",
        "01101010",
        "01101011",
        "01101100",
        "01101101",
        "01101110",
        "01101111",
        "01110000",
        "01110001",
        "01110010",
        "01110011",
        "01110100",
        "01110101",
        "01110110",
        "01110111",
        "01111000",
        "01111001",
        "01111010"
        )

    var smallLetters= arrayOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        spinner = findViewById(R.id.spinner)
        textViewResult = findViewById(R.id.textViewResult)

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                getBinary("Binary Coded Decimal",s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                getBinary("Binary Coded Decimal","a")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                getBinary("Binary Coded Decimal",s.toString())
            }

        })
        
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
//                    if (type == "Binary Coded Decimal") {
//                        getBinary("Binary Coded Decimal",editText.text.toString())
//                    } else {
//                        getBinary("nothing","")
//                    }
                }
            }

        }
    }

    private fun getBinary(convertType: String,letter:String) {
        try {
            if (convertType == "Binary Coded Decimal") {
                //smallLetters.indexOf(letter).toString()
                //textViewResult.text = binary.get(20)
                val a = binary.get(smallLetters.indexOf(letter))
                textViewResult.text = a.toString()
                // val a = convertType in arrayOf(binaryList)
            } else {
                textViewResult.text = "No result"
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }


}
