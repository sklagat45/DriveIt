package com.sklagat46.driveit.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.sklagat46.driveit.R
import com.sklagat46.driveit.models.LoginUser
import com.sklagat46.driveit.ui.auth.viewmodel.LoginViewModel
import com.sklagat46.driveit.ui.dashboard.MainDashboardActivity
import kotlinx.android.synthetic.main.activity_sign_in.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private val loginViewModel: LoginViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

//        setupActionBar()

//        tv_sign_in.setOnClickListener {
//            signInRegisteredUser()
//        }


        tv_forgot_password.setOnClickListener {

            // Launch the lounge forgot password screen.
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }





        tv_register_now.setOnClickListener {

            // Launch the lounge forgot password screen.
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        tv_fire_login.setOnClickListener {
            fire_login.visibility = GONE
            server_login.visibility = VISIBLE
        }


        tv_fire_login.setOnClickListener {

            // Launch the lounge forgot password screen.
            startActivity(Intent(this, SignUpActivity::class.java))
        }


    }

     fun performLogin(view: View){
        val user_name = et_username_signin.text.toString().trim { it <= ' ' }
        val password = et_password_signin.text.toString().trim { it <= ' ' }
        val login = LoginUser(
            user_name,
            password
        )
        loginViewModel.loginUser(login)
         startActivity(
             Intent(
                 this@LoginActivity,
                 MainDashboardActivity::class.java
             )
         )
         this.finish()
    }

    private fun signInRegisteredUser() {

        // Here we get the text from editText and trim the space
        val email: String = et_email_si.text.toString().trim { it <= ' ' }
        val password: String = et_password_si.text.toString().trim { it <= ' ' }

        if (validateForm(email, password)) {
            // Show the progress dialog.
            Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show();

            // Sign-In using FirebaseAuth
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Calling the FirestoreClass signInUser function to get the data of user from database.

                        startActivity(
                            Intent(
                                this@LoginActivity,
                                MainDashboardActivity::class.java
                            )
                        )
                        this.finish()

                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            task.exception!!.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }
    }

    private fun getUserDetails(any: Any) {

    }

    /**
     * A function for actionBar Setup.
     */
//   private fun setupActionBar() {
//
//        setSupportActionBar(toolbar_signin)
//        toolbar_signin.setNavigationOnClickListener { onBackPressed() }
//    }

    /**
     * A function to validate the entries of a user.
     */
    private fun validateForm(email: String, password: String): Boolean {
        return if (TextUtils.isEmpty(email)) {

            Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show();
            false
        } else if (TextUtils.isEmpty(password)) {

            Toast.makeText(this, "missing Password", Toast.LENGTH_SHORT).show();
            false
        } else {
            true
        }
    }

    fun tv_fire_login(view: View) {
        server_login.visibility = GONE
        fire_login.visibility = VISIBLE
    }

//    fun tv_fire_login(view: View) {
//        server_login.visibility = GONE
//        fire_login.visibility = VISIBLE
//    }
}