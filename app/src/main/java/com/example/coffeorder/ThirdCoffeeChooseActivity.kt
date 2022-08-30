package com.example.coffeorder

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.coffeorder.R

class ThirdCoffeeChooseActivity: AppCompatActivity() {

    private var coffeeSize = ""
    private var sugar = false
    private var milk = false
    private var sirop = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_coffee_choose_activity)
        coffeeSize = findViewById<RadioButton>(R.id.rbb1).text.toString()
        setRadioButton()
        setCheckBox()
        doOrder()
    }

    private fun setRadioButton() {
        findViewById<RadioButton>(R.id.rbb1).setOnClickListener {
            coffeeSize = (it as RadioButton).text.toString()
            findViewById<RadioButton>(R.id.rbb1).isChecked = true
            findViewById<RadioButton>(R.id.rbb2).isChecked = false
            findViewById<RadioButton>(R.id.rbb3).isChecked = false
        }
        findViewById<RadioButton>(R.id.rbb2).setOnClickListener {
            coffeeSize = (it as RadioButton).text.toString()
            findViewById<RadioButton>(R.id.rbb1).isChecked = false
            findViewById<RadioButton>(R.id.rbb2).isChecked = true
            findViewById<RadioButton>(R.id.rbb3).isChecked = false
        }
        findViewById<RadioButton>(R.id.rbb3).setOnClickListener {
            coffeeSize = (it as RadioButton).text.toString()
            findViewById<RadioButton>(R.id.rbb1).isChecked = false
            findViewById<RadioButton>(R.id.rbb2).isChecked = false
            findViewById<RadioButton>(R.id.rbb3).isChecked = true
        }
    }

    private fun setCheckBox() {
        findViewById<CheckBox>(R.id.checkBoxBG).setOnClickListener {
            sugar = !sugar
        }
        findViewById<CheckBox>(R.id.checkBoxV).setOnClickListener {
            milk = !milk
        }
        findViewById<CheckBox>(R.id.checkBoxC).setOnClickListener {
            sirop = !sirop
        }
    }

    private fun doOrder() {
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup1)
        findViewById<Button>(R.id.buttonSubmit).setOnClickListener {
            val coffeeType = findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text.toString()
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("coffeeType", coffeeType)
            intent.putExtra("coffeeSize", coffeeSize)
            intent.putExtra("sugar", sugar)
            intent.putExtra("milk", milk)
            intent.putExtra("sirop", sirop)
            startActivity(intent)
        }
    }
}