package com.example.p003calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class CalculadoraActivity : AppCompatActivity() {
    private lateinit var btnSumar: Button
    private lateinit var btnRestar: Button
    private lateinit var btnMultiplicar: Button
    private lateinit var btnDividir: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnRegresar: Button

    private lateinit var txtNum1: EditText
    private lateinit var txtNum2: EditText
    private lateinit var lblResultado :TextView

    private var calculadora = Calculadora(0,0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)
        iniciarComponentes()

        btnSumar.setOnClickListener { btnSumar() }
        btnRestar.setOnClickListener { btnRestar() }
        btnMultiplicar.setOnClickListener { btnMultiplicar()}
        btnDividir.setOnClickListener { btnDividir() }
        btnLimpiar.setOnClickListener { limpiar() }
        btnRegresar.setOnClickListener { regresar() }
    }

    private fun regresar(){
        val confirmar = AlertDialog.Builder(this)
        confirmar.setTitle("Calculadora")
        confirmar.setMessage("¿ Deseas regresar ?")
        confirmar.setPositiveButton("Confirmar"){ _, _->finish()}
        confirmar.setNegativeButton("Cancelar"){ _, _->}.show()
    }

    private fun limpiar() {
        txtNum1.text.clear()
        txtNum2.text.clear()
        lblResultado.text = ""
    }
    private fun iniciarComponentes() {
        btnSumar = findViewById(R.id.btnSumar)
        btnRestar = findViewById(R.id.btnRestar)
        btnMultiplicar = findViewById(R.id.btnMultiplicar)
        btnDividir = findViewById(R.id.btnDividir)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnRegresar = findViewById(R.id.btnRegresar)

        txtNum1 = findViewById(R.id.txtNum1)
        txtNum2 = findViewById(R.id.txtNum2)
        lblResultado = findViewById(R.id.lblResultado)

    }

    private fun btnSumar(){
        if ((txtNum1.text.isEmpty()) or (txtNum2.text.isEmpty())){
            Toast.makeText(this.applicationContext, "Values Required", Toast.LENGTH_SHORT).show()
            return
        }
        calculadora.num1 = txtNum1.text.toString().toInt()
        calculadora.num2 = txtNum2.text.toString().toInt()
        lblResultado.text = calculadora.sumar().toString()

    }

    private fun btnRestar(){
        if ((txtNum1.text.isEmpty()) or (txtNum2.text.isEmpty())){
            Toast.makeText(this.applicationContext, "Values Required", Toast.LENGTH_SHORT).show()
            return
        }
        calculadora.num1 = txtNum1.text.toString().toInt()
        calculadora.num2 = txtNum2.text.toString().toInt()
        lblResultado.text = calculadora.restar().toString()

    }

    private fun btnDividir(){
        if ((txtNum1.text.isEmpty()) or (txtNum2.text.isEmpty())){
            Toast.makeText(this.applicationContext, "Values Required", Toast.LENGTH_SHORT).show()
            return
        }
        calculadora.num1 = txtNum1.text.toString().toInt()
        calculadora.num2 = txtNum2.text.toString().toInt()
        lblResultado.text = calculadora.dividir().toString()

    }

    private fun btnMultiplicar(){
        if ((txtNum1.text.isEmpty()) or (txtNum2.text.isEmpty())){
            Toast.makeText(this.applicationContext, "Values Required", Toast.LENGTH_SHORT).show()
            return
        }
        calculadora.num1 = txtNum1.text.toString().toInt()
        calculadora.num2 = txtNum2.text.toString().toInt()
        lblResultado.text = calculadora.multiplicar().toString()

    }

}