package com.blackgreen.juegoadivina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btnComenzar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnComenzar = findViewById(R.id.btnIniciar)

        btnComenzar.setOnClickListener(){
            val intelJugar = Intent(this,JuegoActivity::class.java)
            startActivity(intelJugar)
        }
    }
}