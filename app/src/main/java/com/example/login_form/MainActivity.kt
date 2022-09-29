package com.example.login_form

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.LinkMovementMethod
import android.util.Patterns
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.login_form.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import java.util.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

 lateinit var button1 : Button
 lateinit var emailEditText :TextInputEditText
 lateinit var passwordEditText : TextInputEditText
lateinit var switch : Button

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
//        setLocalLanguage("ne-rNP")


        setContentView(R.layout.activity_main)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        button1 = findViewById(R.id.button1)
        button1.setOnClickListener {
            val msg: String = emailEditText.text.toString()
            val pas: String= passwordEditText.text.toString()

            if (msg.trim().isEmpty()) {
                emailEditText.error = "Required"
                Toast.makeText(applicationContext, "User Name Required ", Toast.LENGTH_SHORT).show()
            } else if (pas.trim().isEmpty()) {
                passwordEditText.error = "Required"
                Toast.makeText(applicationContext, "Password Required ", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Login Successful ", Toast.LENGTH_SHORT).show()
            }
        }
//        switch = findViewById(R.id.switch1)
//        switch.setOnClickListener({
//
//        })
        emailEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(emailEditText.text.toString())
                        .matches()
                )
                    button1.isEnabled = true
                else {
                    button1.isEnabled = false
                    emailEditText.setError("Invalid Email")
                }
            }
        })
        passwordEditText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                s?.apply {
                    if(isValidPassword(passwordEditText.text.toString()) && toString().length >= 8) {
                        passwordEditText.error = null

                    } else {
                        passwordEditText.error = "Invalid password"
                    }
                }



            }
            private fun isValidPassword(passWord: String): Boolean {
                val passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"
                val pattern = Pattern.compile(passwordPattern)
                val matcher = pattern.matcher(passWord)
                return matcher.matches()
            }
        })

        val linkview = findViewById<TextView>(R.id.reg)
        linkview.movementMethod = LinkMovementMethod.getInstance()
        val imagebtn3 = findViewById<ImageButton>(R.id.imbt3)
        imagebtn3.setOnClickListener() {
            val url = "https://www.facebook.com/"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

            val imagebtn2 = findViewById<ImageButton>(R.id.imbt2)
            imagebtn2.setOnClickListener() {
                val url = "https://www.apple.com/"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                startActivity(intent)
            }

                val imagebtn1 = findViewById<ImageButton>(R.id.imbt1)
                imagebtn1.setOnClickListener() {
                    val url = "https://www.google.com/"
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent)
                }
            }
    private fun updateResources(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val configuration: Configuration = this.resources.configuration
        configuration.setLocale(locale)
        configuration.setLayoutDirection(locale)
        this.createConfigurationContext(configuration)
    }
//fun setLocalLanguage(localcode: String) {
//    var locale : Locale = Locale(localcode)
//    Locale.setDefault(locale)
//
//    var config: Configuration = Configuration()
//    config.locale = locale
//
//    baseContext.resources.updateConfiguration(config ,baseContext.resources.displayMetrics)
//}




}








