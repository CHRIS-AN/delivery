package com.chrisan.kotlinudemydelivery.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.chrisan.kotlinudemydelivery.R

class RegisterActivity : AppCompatActivity() {

    var imageViewGoToLogin : ImageView? = null
    var editTextFirstName : EditText? = null
    var editTextLastName : EditText? = null
    var editTextEmail : EditText? = null
    var editTextPhone : EditText? = null
    var editTextPassword : EditText? = null
    var editTextConfirmPassword : EditText? = null
    var buttonRegister : Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        imageViewGoToLogin = findViewById(R.id.imageview_go_to_login)
        editTextFirstName = findViewById(R.id.edittext_firstname)
        editTextLastName = findViewById(R.id.edittext_lastname)
        editTextEmail = findViewById(R.id.edittext_email)
        editTextPhone = findViewById(R.id.edittext_phone)
        editTextPassword = findViewById(R.id.edittext_password)
        editTextConfirmPassword = findViewById(R.id.edittext_confirm_password)
        buttonRegister = findViewById(R.id.btn_register)

        imageViewGoToLogin?.setOnClickListener { goToLogin() }
        buttonRegister?.setOnClickListener { register() }
    }

    private fun register() {
        val firstName = editTextFirstName?.text.toString()
        val lastName = editTextLastName?.text.toString()
        val email = editTextEmail?.text.toString()
        val phone = editTextPhone?.text.toString()
        val password = editTextPassword?.text.toString()
        val confirmPassword = editTextConfirmPassword?.text.toString()


        if (isValidForm(firstName, lastName, email, phone, password, confirmPassword)) {
            Toast.makeText(this, "회원 가입에 성공했습니다.", Toast.LENGTH_SHORT).show()
        }

    }

    // 확장함
    fun String.isEmailValid() : Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    private fun isValidForm(
        firstName : String,
        lastName : String,
        email : String,
        phone : String,
        password : String,
        confirmPassword : String
    ) : Boolean {
        if (firstName.isBlank()) {
            return false
        }

        if (lastName.isBlank()) {
            return false
        }

        if (email.isBlank()) {
            return false
        }

        if (phone.isBlank()) {
            return false
        }

        if (password.isBlank()) {
            return false
        }

        if (confirmPassword.isBlank()) {
            return false
        }

        if (!email.isEmailValid()) {
            return false
        }

        if (password != confirmPassword) {
            return false
        }

        return true
    }

    private fun goToLogin() {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }

    companion object {
        const val TAG = "RegisterActivity"
    }
}