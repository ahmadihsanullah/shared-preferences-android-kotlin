package belajar.android.sharedprefrences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import belajar.android.sharedprefrences.helper.Constant
import belajar.android.sharedprefrences.helper.SharedPreferencesHelper

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    lateinit var loginButton: Button
    lateinit var usernameEditText : EditText
    lateinit var passwordEditText : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferencesHelper = SharedPreferencesHelper(this)
        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener{
            if(usernameEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()){
                saveUSer(usernameEditText.text.toString(), passwordEditText.text.toString())
                message("Berhasil Masuk")
                moveIntent()
            }
        }
    }

    fun saveUSer(username: String, password: String){
        sharedPreferencesHelper.put(Constant.PREF_IS_USERNAME, username)
        sharedPreferencesHelper.put(Constant.PREF_IS_PASSWORD, password)
        sharedPreferencesHelper.put(Constant.PREF_IS_LOGIN, true)
    }

    override fun onStart() {
        super.onStart()
        if(sharedPreferencesHelper.getBoolean(Constant.PREF_IS_LOGIN)){
            moveIntent()
        }
    }

    fun moveIntent(){
        startActivity(Intent(this@MainActivity, Useractivity::class.java))
        finish()
    }

    fun message(message:String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

}