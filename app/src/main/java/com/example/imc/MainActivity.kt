package com.example.imc

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var clickAnimation: Animation

    private lateinit var btnCadastrar: Button
    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnCadastrar = findViewById(R.id.btnCadastrar)
        btnCalcular = findViewById(R.id.btnCalcular)

        clickAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click_animation)

        btnCadastrar.setOnClickListener {
            btnCadastrar.startAnimation(clickAnimation)
            val intent = Intent(this, CadastroPessoaActivity::class.java)
            startActivity(intent)
        }

        btnCalcular.setOnClickListener {
            btnCalcular.startAnimation(clickAnimation)
            val intent = Intent(this, CalcularIMCActivity::class.java)
            startActivity(intent)
        }

    }
}