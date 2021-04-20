package br.iesb.Andre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgot.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class ForgotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        btConfirmaForgot.setOnClickListener(){

            Confirma()

        }

        btVoltaForgot.setOnClickListener(){

            Volta()

        }

    }

    private fun Confirma(){

        val email = edEmailForgot.text.toString()

        val auth = FirebaseAuth.getInstance()
        auth.sendPasswordResetEmail(email)
        Toast.makeText(this, "E-mail Enviado", Toast.LENGTH_SHORT).show()
        finish()

    }

    private fun Volta(){

        finish()

    }

}