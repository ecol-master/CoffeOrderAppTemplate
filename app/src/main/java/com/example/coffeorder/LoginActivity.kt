package com.example.coffeorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        signIn()
    }

    private fun signIn() {
        findViewById<Button>(R.id.buttonSubmit).setOnClickListener {

            val login =
                findViewById<EditText>(R.id.editTextPhone).text.toString()

            val password =
                findViewById<EditText>(R.id.editTextTextPassword).text.toString()

            if (login.isNotEmpty() && password.isNotEmpty()) {
                //Логин и пароль не пустые. Переключаем на следющий экран
                //Создаем "мост" между экранами
                val intent = Intent(this, MapActivity::class.java)
                //Передаем логин по ключу "loginKey"
                intent.putExtra("loginKey", login)
                //Запускаем следующий экран
                startActivity(intent)
            } else {
                Toast.makeText(
                    this, "Оба поля должны быть заполнены",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

}