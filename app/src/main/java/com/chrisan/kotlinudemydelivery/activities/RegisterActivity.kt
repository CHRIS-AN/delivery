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
import com.chrisan.kotlinudemydelivery.models.ResponseHttp
import com.chrisan.kotlinudemydelivery.models.User
import com.chrisan.kotlinudemydelivery.providers.UsersProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    var imageViewGoToLogin : ImageView? = null
    var editTextFirstName : EditText? = null
    var editTextLastName : EditText? = null
    var editTextEmail : EditText? = null
    var editTextPhone : EditText? = null
    var editTextPassword : EditText? = null
    var editTextConfirmPassword : EditText? = null
    var buttonRegister : Button? = null

    val userProvider = UsersProvider()


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

            val user = User(
                firstname = firstName,
                lastname = lastName,
                email = email,
                phone = phone,
                password = password)

            userProvider.register(user)?.enqueue(object:Callback<ResponseHttp> {
                override fun onResponse(
                    call: Call<ResponseHttp>,
                    response: Response<ResponseHttp>
                ) {
                    Log.d(TAG, "Response : ${response} ")
                    Log.d(TAG, "Response : ${response.body()} ")
                    Toast.makeText(this@RegisterActivity, response.message(), Toast.LENGTH_SHORT).show()
                }

                // 응답 실패 시,
                override fun onFailure(call: Call<ResponseHttp>, t: Throwable) {
                    Log.d(TAG, "응답에 실패했습니다. 메시지 -> ${t.message}")
                    Toast.makeText(this@RegisterActivity, "응답에 실패했습니다. 메시지 -> ${t.message}", Toast.LENGTH_SHORT).show()
                }

            })
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