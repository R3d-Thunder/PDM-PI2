package br.iesb.Andre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btLogin.setOnClickListener{

            login()

        }

        btSingUp.setOnClickListener{

            signUP()

        }

        tvForget.setOnClickListener {

            forget()

        }

    }

    private fun login(){

        val email = edMail.text.toString()
        val senha = edSenha.text.toString()
        //Toast.makeText(this, str, Toast.LENGTH_SHORT).show()

        val auth = FirebaseAuth.getInstance()
        val TaskDeLogin = auth.signInWithEmailAndPassword(email,senha)

        TaskDeLogin.addOnCompleteListener { resultado ->

            if (resultado.isSuccessful){

                val intencaoDeChamada = Intent(this, HomeActivity::class.java)
                startActivity(intencaoDeChamada)

            }else{

                Toast.makeText(this, "Usuario ou senha Invalida", Toast.LENGTH_SHORT).show()

            }

        }

    }


    private fun forget(){

        val intencaoDeChamada = Intent(this, ForgotActivity::class.java)
        startActivity(intencaoDeChamada)

    }

    private fun signUP(){

        val intencaoDeChamada = Intent(this, SignUpActivity::class.java)
        startActivity(intencaoDeChamada)

    }

}