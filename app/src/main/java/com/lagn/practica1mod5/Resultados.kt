package com.lagn.practica1mod5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class Resultados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)


        val bundle = intent.extras
        var txtResult = findViewById<TextView>(R.id.txtResul)

        val resul = bundle?.getFloat("R")





        if (resul != null) {
            if(resul  > 0f) {
                txtResult.text = getString(R.string.resultadoForm, resul)


            }
            else{
                val ortoedro = bundle?.getSerializable("vol") as Ortoedro

                txtResult.text = getString(R.string.resultadoOrtoedro, ortoedro.a, ortoedro.b, ortoedro.c, ortoedro.resul)



            }
        }


    }


    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))

    }
}