package belajar.android.sharedprefrences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import belajar.android.sharedprefrences.helper.Constant
import belajar.android.sharedprefrences.helper.SharedPreferencesHelper

class Useractivity : AppCompatActivity() {
    lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    lateinit var usernameTextView: TextView
    lateinit var logoutButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        sharedPreferencesHelper = SharedPreferencesHelper(this)
        usernameTextView = findViewById(R.id.usernameTextView)
        logoutButton = findViewById(R.id.logoutButton)

        usernameTextView.text = sharedPreferencesHelper.getString(Constant.PREF_IS_USERNAME)

        logoutButton.setOnClickListener {
            sharedPreferencesHelper.clear()
            message("keluar")
            moveIntent()
        }

    }

    fun moveIntent(){
        startActivity(Intent(this@Useractivity, MainActivity::class.java))
        finish()
    }

    fun message(message:String){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }
}