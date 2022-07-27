package com.chrisan.kotlinudemydelivery.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.chrisan.kotlinudemydelivery.R

class MainActivity : AppCompatActivity() {

    var imageviewGoToRegister : ImageView? = null
    var editTextEmail : EditText? = null
    var editTextPassword : EditText? = null
    var buttonLogin : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageviewGoToRegister = findViewById(R.id.imageview_go_to_register)
        editTextEmail = findViewById(R.id.edittext_email)
        editTextPassword = findViewById(R.id.edittext_password)
        buttonLogin = findViewById(R.id.btn_login)

        // ? 연산자 사용
        imageviewGoToRegister?.setOnClickListener { goToResister() }
        buttonLogin?.setOnClickListener { login() }
    }

    private fun login() {
        val email = editTextEmail?.text.toString() // 널포인터 익셉션
        val password = editTextPassword?.text.toString()

        if (isValidForm(email, password)) {
            Toast.makeText(this, "유효성 검사를 통과됐습니다.", Toast.LENGTH_SHORT).show()
        }else {
            Toast.makeText(this, "유효성 검사를 실패했습니다.", Toast.LENGTH_SHORT).show()
        }

        Toast.makeText(this, "이메일은 ${email} 입니다.", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "비밀번호 ${password} 입니다.", Toast.LENGTH_SHORT).show()
    }

    // 확장함
    fun String.isEmailValid() : Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    private fun isValidForm(email : String, password : String) : Boolean {
        if (email.isBlank()) {
            return false
        }
        if (password.isBlank()) {
            return false
        }
        if (!email.isEmailValid()) {
            return false
        }

        return true
    }


    private fun goToResister() {
        val i = Intent(this, RegisterActivity::class.java)
        startActivity(i)
    }
}