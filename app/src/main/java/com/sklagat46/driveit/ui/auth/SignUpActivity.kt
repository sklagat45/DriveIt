package com.sklagat46.driveit.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.sklagat46.driveit.R
import com.sklagat46.driveit.models.User
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    val mFireStore = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setupActionBar()

        // Click event for sign-up button.
        tv_sign_up.setOnClickListener {
            registerUser()
        }

    }
    /**
     * A function for actionBar Setup.
     */
    private fun setupActionBar() {

        this.setSupportActionBar(toolbar_signup)

        toolbar_signup.setNavigationOnClickListener { onBackPressed() }
    }


    private fun registerUser() {

        // Here we get the text from editText and trim the space
        val username: String = et_username.text.toString().trim { it <= ' ' }
        val email: String = et_email.text.toString().trim { it <= ' ' }
        val password: String = et_password.text.toString().trim { it <= ' ' }


        if (validateForm(username, email, password)) {
            // Show the progress dialog.
            Toast.makeText(this,"Please wait",Toast.LENGTH_SHORT).show();
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->

                    // If the registration is successfully done
                    if (task.isSuccessful) {

                        // Firebase registered user
                        val firebaseUser: FirebaseUser = task.result!!.user!!
                        // Registered Email
                        val registeredEmail = firebaseUser.email!!

                        val user = User(
                            firebaseUser.uid, username, registeredEmail
                        )

                        // call the registerUser function of FirestoreClass to make an entry in the database.
                        registerUser(this@SignUpActivity, user)
                    } else {
                        Toast.makeText(
                            this@SignUpActivity,
                            task.exception!!.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }

    }

    /**
     * A function to make an entry of the registered user in the firestore database.
     */
    fun registerUser(activity: SignUpActivity, userInfo: User) {

        mFireStore.collection("users")
            // Document ID for users fields. Here the document it is the User ID.
            .document()
            // Here the userInfo are Field and the SetOption is set to merge. It is for if we wants to merge
            .set(userInfo, SetOptions.merge())
            .addOnSuccessListener {

                // Here call a function of base activity for transferring the result to it.
                activity.userRegisteredSuccess()
            }
            .addOnFailureListener { e ->
                Log.e(
                    activity.javaClass.simpleName,
                    "Error writing document",
                    e
                )
            }
    }

    /**
     * A function to validate the entries of a new user.
     */
    private fun validateForm(name: String, email: String, password: String): Boolean {
        return when {
            TextUtils.isEmpty(name) -> {
                Toast.makeText(this,"Enter Username",Toast.LENGTH_SHORT).show();
                false
            }
            TextUtils.isEmpty(email) -> {
                Toast.makeText(this,"Enter Email",Toast.LENGTH_SHORT).show();
                false
            }
            TextUtils.isEmpty(password) -> {
                Toast.makeText(this,"Enter password",Toast.LENGTH_SHORT).show();
                false
            }
            else -> {
                true
            }
        }
    }

    /**
     * A function to be called the user is registered successfully and entry is made in the firestore database.
     */
    fun userRegisteredSuccess() {

        Toast.makeText(
            this@SignUpActivity,
            "You have successfully registered.",
            Toast.LENGTH_SHORT
        ).show()

        /**
         * Here the new user registered is automatically signed-in so we just sign-out the user from firebase
         * and send him to Intro Screen for Sign-In
         */
        FirebaseAuth.getInstance().signOut()
        // Finish the Sign-Up Screen
        finish()
    }

}