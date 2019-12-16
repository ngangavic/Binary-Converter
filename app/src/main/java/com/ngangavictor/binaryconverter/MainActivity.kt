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
import com.ngangavictor.binaryconverter.data.Data.Companion.asciiCapital
import com.ngangavictor.binaryconverter.data.Data.Companion.asciiSmall
import com.ngangavictor.binaryconverter.data.Data.Companion.binaryCapital
import com.ngangavictor.binaryconverter.data.Data.Companion.binarySmall
import com.ngangavictor.binaryconverter.data.Data.Companion.capitalLetters
import com.ngangavictor.binaryconverter.data.Data.Companion.decimalCapital
import com.ngangavictor.binaryconverter.data.Data.Companion.decimalSmall
import com.ngangavictor.binaryconverter.data.Data.Companion.hexCapital
import com.ngangavictor.binaryconverter.data.Data.Companion.hexSmall
import com.ngangavictor.binaryconverter.data.Data.Companion.octalCapital
import com.ngangavictor.binaryconverter.data.Data.Companion.octalSmall
import com.ngangavictor.binaryconverter.data.Data.Companion.smallLetters

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var spinner: Spinner
    lateinit var textViewResult: TextView
    lateinit var type: String
    lateinit var prev: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        spinner = findViewById(R.id.spinner)
        textViewResult = findViewById(R.id.textViewResult)
        prev = ""

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s!!.isNotEmpty()) {
                    prev = textViewResult.text.toString()
                    getLetter(s.toString())
                } else {
                    prev = ""
                    textViewResult.text = ""
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

    private fun getLetter(letter: String) {
        try {
            when (type) {
                "Binary Coded Decimal" -> {
                    var i = 0
                    Log.d("BINARY LENGTH", letter.length.toString())
                    while (i < letter.length) {
                        getBinary(letter[i])
                        i++
                    }
                }
                "ASCII LENGTH" -> {
                    var i = 0
                    Log.d("ASCII LENGTH", letter.length.toString())
                    while (i < letter.length) {
                        getASCII(letter[i])
                        i++
                    }
                }
                "Hexadecimal" -> {
                    var i = 0
                    Log.d("HEX LENGTH", letter.length.toString())
                    while (i < letter.length) {
                        getHexadecimal(letter[i])
                        i++
                    }
                }
                "Octal" -> {
                    var i = 0
                    Log.d("OCTAL LENGTH", letter.length.toString())
                    while (i < letter.length) {
                        getOctal(letter[i])
                        i++
                    }
                }
                "Decimal" -> {
                    var i = 0
                    Log.d("DEC LENGTH", letter.length.toString())
                    while (i < letter.length) {
                        getDec(letter[i])
                        i++
                    }
                }
                else ->
                    textViewResult.text = "No result"
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun getDec(c: Char) {
        if (c.isUpperCase()) {
            val a = decimalCapital.get(capitalLetters.indexOf(c.toString()))
            Log.d("MAIN ACTIVITY OCTAL", a)
            val final = prev + " " + a
            Log.d("FINAL OCTAL", final)
            textViewResult.text = ""
            textViewResult.text = final
        } else {
            val a = decimalSmall.get(smallLetters.indexOf(c.toString()))
            Log.d("MAIN ACTIVITY OCTAL", a)
            val final = prev + " " + a
            Log.d("FINAL OCTAL", final)
            textViewResult.text = ""
            textViewResult.text = final
        }
    }

    private fun getOctal(c: Char) {
        if (c.isUpperCase()) {
            val a = octalCapital.get(capitalLetters.indexOf(c.toString()))
            Log.d("MAIN ACTIVITY OCTAL", a)
            val final = prev + " " + a
            Log.d("FINAL OCTAL", final)
            textViewResult.text = ""
            textViewResult.text = final
        } else {
            val a = octalSmall.get(smallLetters.indexOf(c.toString()))
            Log.d("MAIN ACTIVITY OCTAL", a)
            val final = prev + " " + a
            Log.d("FINAL OCTAL", final)
            textViewResult.text = ""
            textViewResult.text = final
        }
    }

    private fun getHexadecimal(c: Char) {
        if (c.isUpperCase()) {
            val a = hexCapital.get(capitalLetters.indexOf(c.toString()))
            Log.d("MAIN ACTIVITY HEX", a)
            val final = prev + " " + a
            Log.d("FINAL HEX", final)
            textViewResult.text = ""
            textViewResult.text = final
        } else {
            val a = hexSmall.get(smallLetters.indexOf(c.toString()))
            Log.d("MAIN ACTIVITY HEX", a)
            val final = prev + " " + a
            Log.d("FINAL HEX", final)
            textViewResult.text = ""
            textViewResult.text = final
        }
    }

    private fun getASCII(c: Char) {
        if (c.isUpperCase()) {
            val a = asciiCapital.get(capitalLetters.indexOf(c.toString()))
            Log.d("MAIN ACTIVITY ASCII", a)
            val final = prev + " " + a
            Log.d("FINAL ASCII", final)
            textViewResult.text = ""
            textViewResult.text = final
        } else {
            val a = asciiSmall.get(smallLetters.indexOf(c.toString()))
            Log.d("MAIN ACTIVITY ASCII", a)
            val final = prev + " " + a
            Log.d("FINAL ASCII", final)
            textViewResult.text = ""
            textViewResult.text = final
        }
    }

    private fun getBinary(find: Char) {
        if (find.isUpperCase()) {
            val a = binaryCapital.get(capitalLetters.indexOf(find.toString()))
            Log.d("MAIN ACTIVITY BINARY", a)
            val final = prev + " " + a
            Log.d("FINAL BINARY", final)
            textViewResult.text = ""
            textViewResult.text = final
        } else {
            val a = binarySmall.get(smallLetters.indexOf(find.toString()))
            Log.d("MAIN ACTIVITY BINARY", a)
            val final = prev + " " + a
            Log.d("FINAL BINARY", final)
            textViewResult.text = ""
            textViewResult.text = final
        }

    }


}
