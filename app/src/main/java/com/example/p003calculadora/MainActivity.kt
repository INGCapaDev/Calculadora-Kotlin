package com.example.p003calculadora

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

     private lateinit var btnIngresar : Button
     private lateinit var btnCerrar : Button
     private lateinit var txtUsuario : EditText
     private lateinit var txtContrasena : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniciarComponentes()

        btnIngresar.setOnClickListener { ingresar() }
        btnCerrar.setOnClickListener { cerrar() }

    }

    private fun iniciarComponentes(){
        btnIngresar = findViewById(R.id.btnIngresar)
        btnCerrar = findViewById(R.id.btnCerrar)
        txtUsuario = findViewById(R.id.txtUsuario)
        txtContrasena = findViewById(R.id.txtContraseña)
    }

    @SuppressLint("SuspiciousIndentation")
    private fun ingresar(){
        val strUsuario : String = application.resources.getString(R.string.usuario)
        val strContra : String = application.resources.getString(R.string.contraseña)

        if ((txtUsuario.text.toString() == strUsuario) and (txtContrasena.text.toString() == strContra)){
            val bundle = Bundle()
            bundle.putString("usuario", strUsuario)

            val intent = Intent(this, CalculadoraActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
            return
        }

        Toast.makeText(this.applicationContext, "Usuario o contraseña no validos", Toast.LENGTH_SHORT).show()
    }

    private fun cerrar(){
        val confirmar = AlertDialog.Builder(this)
        confirmar.setTitle("Calculadora")
        confirmar.setMessage("¿ Deseas Cerrar ?")
        confirmar.setPositiveButton("Confirmar"){ _, _->finish()}
        confirmar.setNegativeButton("Cancelar"){ _, _->}.show()
    }
}