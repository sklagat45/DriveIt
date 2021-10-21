package com.sklagat46.driveit.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth
import com.sklagat46.driveit.R
import com.sklagat46.driveit.ui.dashboard.MainDashboardActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        // This is used to get the file from the assets folder and set it to the title textView.
//        val typeface: Typeface =
//            Typeface.createFromAsset(assets, "carbon bl.ttf")
//        tv_app_name.typeface = typeface
        // Adding the handler to after the a task after some delay.
        Handler().postDelayed({

            // TODO (Step 2: Check if the current user id is not blank then send the user to MainActivity as he have logged in
            //  before or else send him to Intro Screen as earlier.)
            // START
            // Here if the user is signed in once and not signed out again from the app. So next time while coming into the app
            // we will redirect him to MainScreen or else to the Intro Screen as it was before.

            /**
             * A function for getting the user id of current logged user.
             */
            fun getCurrentUserID(): String {
                // TODO (Step 1: Return the user id if he is already logged in before or else it will be blank.)
                // START
                // An Instance of currentUser using FirebaseAuth
                val currentUser = FirebaseAuth.getInstance().currentUser

                // A variable to assign the currentUserId if it is not null or else it will be blank.
                var currentUserID = ""
                if (currentUser != null) {
                    currentUserID = currentUser.uid
                }

                return currentUserID
                // END
            }
            // Get the current user id
            val currentUserID = getCurrentUserID()
//             Start the Intro Activity

            if (currentUserID.isEmpty()) {
                // Start the Intro Activity
                startActivity(Intent(this@SplashScreen, LoginActivity::class.java))

            } else {
                // Start the Main Activity
                startActivity(Intent(this@SplashScreen, MainDashboardActivity::class.java))

            }
            finish() // Call this when your activity is done and should be closed.
            // END
        }, 2500) // Here we pass the delay time in milliSeconds after which the splash activity will disappear.

    }
}