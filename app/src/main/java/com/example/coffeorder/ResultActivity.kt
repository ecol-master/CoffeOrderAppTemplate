package com.example.coffeorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {


    private var coffeeType = ""
    private var coffeeSize = ""
    private var sugar = false
    private var milk = false
    private var sirop = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        getIntentData()
        setData()
        Handler().postDelayed(Runnable {
            Toast.makeText(applicationContext, "Ваш заказ будет готов к выдаче через: 5 мин", Toast.LENGTH_LONG).show()
        }, 1000)
    }

    private fun getIntentData() {
        coffeeType = intent.getStringExtra("coffeeType").toString()
        coffeeSize = intent.getStringExtra("coffeeSize").toString()
        sugar = intent.getBooleanExtra("sugar", false)
        milk = intent.getBooleanExtra("milk", false)
        sirop = intent.getBooleanExtra("sirop", false)
    }

    private fun setData() {
        val number = (1..1000).random()
        findViewById<TextView>(R.id.your_order).text = "Ваш заказ %s".format(number.toString())
        var result = arrayListOf("")
        findViewById<TextView>(R.id.type_coffee).text = coffeeType
        findViewById<TextView>(R.id.size_coffee).text = coffeeSize
        if (sugar) {
         result.add("бабл гам")
        }
        if (milk) {
            result += "ваниль"
        }
        if (sirop) {
            result += "карамель"
        }
        result.remove("")
        findViewById<TextView>(R.id.adds_coffee).text = result.joinToString(" + ")
    }
}