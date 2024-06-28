package com.example.imc

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalcularIMCActivity : AppCompatActivity() {

    private lateinit var clickAnimation: Animation

    private lateinit var btnCalcular: Button
    private lateinit var btnVoltar: Button
    private lateinit var peso: EditText
    private lateinit var altura: EditText
    private lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcular_imc)

        peso = findViewById(R.id.etPeso)
        altura = findViewById(R.id.etAltura)
        resultado = findViewById(R.id.tvResultado)
        btnCalcular = findViewById(R.id.btnCalcular)
        btnVoltar = findViewById(R.id.btnVoltar)

        clickAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click_animation)

        btnCalcular.setOnClickListener {
            btnCalcular.startAnimation(clickAnimation)
            if (altura.text.isNotEmpty() && peso.text.isNotEmpty()){
                var result = peso.text.toString().toDouble() / (altura.text.toString()
                    .toDouble() * altura.text.toString().toDouble())
                resultado.setText("O valor do imc é igual a %.2f".format(result))
            }
        }

        btnVoltar.setOnClickListener {
            btnVoltar.startAnimation(clickAnimation)
            finish()
        }
    }
}