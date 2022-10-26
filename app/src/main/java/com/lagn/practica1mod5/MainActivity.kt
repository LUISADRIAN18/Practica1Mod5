package com.lagn.practica1mod5

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.text.method.ScrollingMovementMethod
import android.text.style.UpdateLayout
import android.view.View
import android.widget.*
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private lateinit var numberA: EditText
    private lateinit var numberB: EditText
    private lateinit var numberC: EditText
    private lateinit var description: TextView
    private lateinit var imagen: ImageView
    private lateinit var layoutF: LinearLayout


    private var formula: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listForm()







    }

    private fun listForm(){
        val spiner= findViewById<Spinner>(R.id.spnFormulas)
        val formulas = resources.getStringArray(R.array.formulas)
        val adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_item,formulas)
        spiner.adapter = adaptador
        layoutF = findViewById(R.id.lyF)
        spiner.onItemSelectedListener = object:
        AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                when(position){
                    0 ->{

                        imagen = findViewById(R.id.imvForm)
                        imagen.setImageResource(R.drawable.area_rec)
                        numberA = findViewById(R.id.edtA)
                        numberB = findViewById(R.id.edtB)
                        numberC = findViewById(R.id.edtC)

                        numberA.hint = getString(R.string.valorA)
                        numberB.hint = getString(R.string.valorH)
                        numberC.isVisible = false
                        layoutF.setBackgroundColor(getResources().getColor(R.color.salmon0))
                        formula=0
                        description= findViewById(R.id.txtD)
                        description.isVisible = false




                    }
                    1 ->{

                        imagen = findViewById(R.id.imvForm)
                        imagen.setImageResource(R.drawable.area_trian)

                        numberA = findViewById(R.id.edtA)
                        numberB = findViewById(R.id.edtB)
                        numberC = findViewById(R.id.edtC)

                        numberA.hint = getString(R.string.valorA)
                        numberB.hint = getString(R.string.valorH)
                        numberC.isVisible = false
                        formula=1

                        layoutF.setBackgroundColor(getResources().getColor(R.color.salmon1))
                        description= findViewById(R.id.txtD)
                        description.isVisible = false

                    }
                    2 ->{

                        imagen = findViewById(R.id.imvForm)
                        imagen.setImageResource(R.drawable.vol_ortoedro)

                        numberA = findViewById(R.id.edtA)
                        numberB = findViewById(R.id.edtB)
                        numberC = findViewById(R.id.edtC)
                        numberC.isVisible = true

                        numberA.hint = getString(R.string.valorA)
                        numberB.hint = getString(R.string.valorB)
                        numberC.hint = getString(R.string.valorC)

                        layoutF.setBackgroundColor(getResources().getColor(R.color.salmon2))
                        formula=2
                        description= findViewById(R.id.txtD)

                        description.isVisible = true

                        description.text = getString(R.string.description)

                        description.movementMethod = ScrollingMovementMethod()





                    }

                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }


        }



    }

    fun calcular(view: View) {

        numberA = findViewById(R.id.edtA)
        numberB = findViewById(R.id.edtB)
        numberC = findViewById(R.id.edtC)



        when(formula){
            0 ->{

                if ((numberA.text.isEmpty() or  numberB.text.isEmpty())) Toast.makeText(this, getString(R.string.campos_vacios), Toast.LENGTH_LONG).show()

                if ((numberA.text.isNotEmpty() and numberB.text.isNotEmpty())) {


                    val numA = numberA.text.toString().toFloat()
                    val numB = numberB.text.toString().toFloat()

                    if ((numA == 0f) or (numB == 0f)  ){
                        Toast.makeText(this,getString(R.string.errorVol), Toast.LENGTH_LONG).show()
                        numberA.text.clear()
                        numberB.text.clear()

                    }

                    if ((numA != 0f) and (numB != 0f)  ) {

                        if (numA == numB){
                            Toast.makeText(this, getString(R.string.valores_iguales, numA, numB), Toast.LENGTH_LONG).show()


                        } else {
                            //var parametros = Bundle()
                            var resul: Float = numA * numB
                            val intent = Intent(this, Resultados::class.java )

                            intent.putExtra("R",resul)





                            startActivity(intent)

                            numberA.text.clear()
                            numberB.text.clear()
                            numberC.text.clear()

                        }

                    }






                }
            }
            1 ->{
                if ((numberA.text.isEmpty() or  numberB.text.isEmpty())) Toast.makeText(this, getString(R.string.campos_vacios), Toast.LENGTH_LONG).show()

                if ((numberA.text.isNotEmpty() and numberB.text.isNotEmpty())) {


                    val numA = numberA.text.toString().toFloat()
                    val numB = numberB.text.toString().toFloat()

                    if ((numA == 0f) or (numB == 0f)  ){
                        Toast.makeText(this,getString(R.string.errorVol), Toast.LENGTH_LONG).show()
                        numberA.text.clear()
                        numberB.text.clear()


                    }

                    if ((numA != 0f) and (numB != 0f)  ) {

                        if (numA == numB){
                            Toast.makeText(this, getString(R.string.valores_iguales_triangulo, numA, numB), Toast.LENGTH_LONG).show()


                        } else {
                            var resul: Float = (numA * numB)/2

                            val intent = Intent(this, Resultados::class.java )

                            intent.putExtra("R",resul)





                            startActivity(intent)
                            numberA.text.clear()
                            numberB.text.clear()
                            numberC.text.clear()


                            Toast.makeText(this, "${resul}", Toast.LENGTH_LONG).show()
                        }

                    }


                }
            }
            2 ->{
                if ((numberA.text.isEmpty() or  numberB.text.isEmpty() or numberC.text.isEmpty())) Toast.makeText(this, getString(R.string.campos_vacios), Toast.LENGTH_LONG).show()

                if ((numberA.text.isNotEmpty() and numberB.text.isNotEmpty() and numberC.text.isNotEmpty())) {


                    val numA = numberA.text.toString().toFloat()
                    val numB = numberB.text.toString().toFloat()
                    val numC = numberC.text.toString().toFloat()

                    if ((numA == 0f) or (numB == 0f) or (numC == 0f) ){
                        numberA.error = getString(R.string.valor_requerido)
                        numberB.error = getString(R.string.valor_requerido)

                        numberA.text.clear()
                        numberB.text.clear()
                        numberC.text.clear()
                        Toast.makeText(this,getString(R.string.errorVol), Toast.LENGTH_LONG).show()


                    }

                    if ((numA != 0f) and (numB != 0f ) and (numC != 0f )) {

                        var resul : Float = (numA*numB*numC)

                        val ortoedro = Ortoedro(numA, numB, numC,resul)

                        val intent = Intent(this, Resultados::class.java )


                        intent.putExtra("vol", ortoedro)


                        startActivity(intent)
                        numberA.text.clear()
                        numberB.text.clear()
                        numberC.text.clear()


                        Toast.makeText(this, "${resul}", Toast.LENGTH_LONG).show()

                    }

                }
            }


        }





    }




}

