package com.example.uts_project_medicipaw

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import android.util.Log

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_screen)

        auth = FirebaseAuth.getInstance()

        val emailEditText = findViewById<EditText>(R.id.et_email)
        val usernameEditText = findViewById<EditText>(R.id.et_text2)
        val passwordEditText = findViewById<EditText>(R.id.et_password2)
        val confirmPasswordEditText = findViewById<EditText>(R.id.et_password3)
        val registerButton = findViewById<Button>(R.id.button2)
        val loginTextView = findViewById<TextView>(R.id.textView2)

        registerButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (email.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                register(email, password, username)
            }
        }

        loginTextView.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun register(email: String, password: String, username: String) {
        Log.d("RegisterActivity", "Attempting to register user with email: $email")

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val userId = auth.currentUser?.uid
                    val database = FirebaseDatabase.getInstance().getReference("Users/$userId")
                    database.child("username").setValue(username)

                    Toast.makeText(baseContext, "Registration successful.", Toast.LENGTH_SHORT)
                        .show()
                    finish()
                } else {
                    val errorMessage = task.exception?.message ?: "Unknown error"
                    Log.e("RegisterActivity", "Registration failed: $errorMessage")
                    Toast.makeText(
                        baseContext,
                        "Registration failed: $errorMessage",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }}