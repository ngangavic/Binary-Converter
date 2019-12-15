package com.ngangavictor.binaryconverter

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ngangavictor.binaryconverter.data.Data.Companion.asciiSmall
import com.ngangavictor.binaryconverter.data.Data.Companion.binarySmall
import com.ngangavictor.binaryconverter.data.Data.Companion.smallLetters
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var spinner: Spinner
    lateinit var textViewResult: TextView
    lateinit var type: String
    lateinit var prev:String






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        spinner = findViewById(R.id.spinner)
        textViewResult = findViewById(R.id.textViewResult)
        prev=""

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s!!.isNotEmpty()) {
                    prev=textViewResult.text.toString()
                    getLetter(s.toString())
                }else{
                    prev=""
                    textViewResult.text=""
                }
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
                }
            }

        }
    }

    private fun getLetter(letter:String) {
        try {
            if (type == "Binary Coded Decimal") {

                var i = 0
                Log.d("BINARY LENGTH",letter.length.toString())
                while (i < letter.length) {
                    getBinarySmall(letter[i])
                    i++
                }

            }else if (type == "ASCII Code"){
                var i = 0
                Log.d("ASCII LENGTH",letter.length.toString())
                while (i < letter.length) {
                    getASCIISmall(letter[i])
                    i++
                }
            } else {
                textViewResult.text = "No result"
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    private fun getASCIISmall(c: Char) {
        val a = asciiSmall.get(smallLetters.indexOf(c.toString()))
        Log.d("MAIN ACTIVITY ASCII",a)
        val final = prev+" "+a
        Log.d("FINAL ASCII",final)
        textViewResult.text=""
        textViewResult.text=final
    }

    private fun getBinarySmall(find:Char){
        val a = binarySmall.get(smallLetters.indexOf(find.toString()))
        Log.d("MAIN ACTIVITY BINARY",a)
        val final = prev+" "+a
        Log.d("FINAL BINARY",final)
        textViewResult.text=""
        textViewResult.text=final

    }



}
