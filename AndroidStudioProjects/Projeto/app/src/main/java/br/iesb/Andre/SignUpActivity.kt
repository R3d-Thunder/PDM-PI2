package br.iesb.Andre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btConfirmaSignUp.setOnClickListener{

            Confirma()

        }

        btVoltaSingUp.setOnClickListener{

            Volta()

        }

    }

    private fun Confirma() {

        val email = edUsu.text.toString()
        val senha1 = EdSenha1.text.toString()
        val senha2 = edSenha2.text.toString()

        if (senha1 != senha2) {

            Toast.makeText(this, "Senhas nao iguais", Toast.LENGTH_SHORT).show()
            return

        }

        val auth = FirebaseAuth.getInstance()
        val TaskDeLogin = auth.createUserWithEmailAndPassword(email, senha1)

        TaskDeLogin.addOnCompleteListener { resultado ->

            if (resultado.isSuccessful) {

                finish()

            } else {

                Toast.makeText(this, "Erro no cadastro!", Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun Volta(){

        finish()

    }

}