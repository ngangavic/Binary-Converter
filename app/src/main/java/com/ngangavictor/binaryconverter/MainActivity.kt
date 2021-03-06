package com.ngangavictor.binaryconverter

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
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
    lateinit var imageViewShare: ImageView
    lateinit var thread: Thread
    lateinit var buttonEncode: Button
    lateinit var buttonDecode: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        spinner = findViewById(R.id.spinner)
        textViewResult = findViewById(R.id.textViewResult)
        imageViewShare = findViewById(R.id.imageViewShare)
        buttonDecode=findViewById(R.id.buttonDecode)
        buttonEncode=findViewById(R.id.buttonEncode)
        prev = ""

//        editText.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//
//            }
//
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                Log.d("START", start.toString())
//                Log.d("BEFORE", before.toString())
//                Log.d("COUNT", count.toString())
//                Log.d("TEXT", s.toString())
//
//                if (s!!.isNotEmpty()) {
//                    if (count > before) {
//                        prev = textViewResult.text.toString()
//                        getLetter(s.toString())
//                    } else if (count < before) {
//                        removeCharacter()
//                    }
//                } else {
//                    prev = ""
//                    textViewResult.text = ""
//                }
//            }
//
//        })

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
        imageViewShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, textViewResult.text.toString())
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

        buttonEncode.setOnClickListener {
            getEncode(editText.text.toString())
        }
        buttonDecode.setOnClickListener {
            getDecode(editText.text.toString())
        }

    }

    private fun getDecode(letter: String){
        try {
            when (type) {
                "Binary Coded Decimal" -> {
                    val txt = editText.text.toString()
                    val binary = getBinaryDecode(txt)
                    textViewResult.text = binary
                }
                "ASCII Code" -> {
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

    private fun getEncode(letter: String) {
        try {
            when (type) {
                "Binary Coded Decimal" -> {
                    val txt = editText.text.toString()
                    val binary = getBinaryEncode(txt)
                    textViewResult.text = binary
                }
                "ASCII Code" -> {
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


    private fun removeCharacter() {
        try {
            when (type) {
                "Binary Coded Decimal" -> {
                    val txt = textViewResult.text
                    textViewResult.text = txt.dropLast(9)
                }
                "ASCII Code" -> {
                    val txt = textViewResult.text
                    textViewResult.text = txt.dropLast(4)
                }
                "Hexadecimal" -> {
                    val txt = textViewResult.text
                    textViewResult.text = txt.dropLast(3)

                }
                "Octal" -> {
                    val txt = textViewResult.text
                    textViewResult.text = txt.dropLast(4)
                }
                "Decimal" -> {
//                    val txt = textViewResult.text
//                    textViewResult.text = txt.dropLast(9)
                    Toast.makeText(applicationContext,"Working on this part",Toast.LENGTH_SHORT).show()
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

    private fun getBinaryEncode(find: String):String {
        val builder = StringBuilder()

        for (c in find.toCharArray()) {
            val toString = Integer.toString(c.toInt(), 2); // get char value in binary
            builder.append(String.format("%08d", Integer.parseInt(toString))); // we complete to have 8 digits
        }

        return builder.toString()

    }

    private fun getBinaryDecode(binary: String):String{
        if (!isBinary(binary))
            return "Not a binary value";

        val chars = CharArray(binary.length / 8)
        var i = 0

        while (i < binary.length) {
            val str = binary.substring(i, i + 8)
            val nb = Integer.parseInt(str, 2)
            chars[i / 8] = nb.toChar()
            i += 8
        }

        return String(chars)
    }

    fun isBinary(txt: String?): Boolean {
        if (txt != null && txt.length % 8 == 0) {
            for (c in txt.toCharArray()) {
                if (c != '0' && c != '1')
                    return false
            }

            return true
        }

        return false
    }


}
