package com.blackgreen.juegoadivina

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.random.Random

class JuegoActivity : AppCompatActivity() {

    lateinit var musica:MediaPlayer
    lateinit var etrespuestaUser:EditText
    lateinit var btnRespuesta:Button
    lateinit var sonResCorr:MediaPlayer
    lateinit var sonResInc:MediaPlayer
    var NGanador =0
    var NUser = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)

        musica = MediaPlayer.create(this,R.raw.musica)
        sonResCorr = MediaPlayer.create(this,R.raw.correcto)
        sonResInc = MediaPlayer.create(this,R.raw.error)
        btnRespuesta = findViewById(R.id.btnAdivinar)
        etrespuestaUser = findViewById(R.id.etNumero)
        rMusica()
        genNumero()

        btnRespuesta.setOnClickListener{

            val respuesta = etrespuestaUser.text.toString()
            if (respuesta.equals("")){
                Toast.makeText(this,"Debes ingresar un valor",Toast.LENGTH_LONG).show()
                sonInc()

            }else{

                NUser = respuesta.toInt()
                if (NUser == NGanador){
                    sonCorr()
                    etrespuestaUser.text = null
                }else{
                    sonInc()
                    etrespuestaUser.text = null
                    Toast.makeText(this,"El valor era: $NGanador",Toast.LENGTH_LONG).show()
                }
                genNumero()
            }
        }

    }



    private fun sonCorr() {
        sonResCorr.start()
    }

    private fun sonInc() {
        sonResInc.start()
    }

    private fun genNumero() {
        NGanador = Random.nextInt(1,10)
    }

    private fun rMusica() {
        musica.isLooping = true
        musica.start()
    }
}