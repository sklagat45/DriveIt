package com.sklagat46.driveit.ui.auth.viewmodel

import android.app.ProgressDialog
import android.content.Context
import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sklagat46.driveit.data.repository.LoginRepository
import com.sklagat46.driveit.models.LoginResponse
import com.sklagat46.driveit.models.LoginUser
import kotlinx.coroutines.*
import okhttp3.ResponseBody
import retrofit2.Retrofit
import timber.log.Timber
import java.io.IOException
import kotlin.coroutines.CoroutineContext


/**
 * LoginViewModel
 */
class LoginViewModel(
    private val loginRepository: LoginRepository,
    private val retrofit: Retrofit
) :
    ViewModel(),
    CoroutineScope {

    private val job = Job()
    lateinit var progressDialog: ProgressDialog
    private var auth: LoginResponse? = null

    override val coroutineContext: CoroutineContext = Dispatchers.Main + job
    val showLoading = MutableLiveData<Boolean>()
    val responseLogin = MutableLiveData<LoginResponse>()

    /**
     * loginUser
     */
    fun loginUser(User: LoginUser) {
        // Show progressBar during the operation on the MAIN (default) thread
        showLoading.value = true
        // launch the Coroutine
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) { loginRepository.login(User) }
                showLoading.value = false
                if (result.isSuccessful) {
                    responseLogin.value = result.body()
                    Timber.d("LoginRepose" + result.body().toString())
                } else {

                    Timber.d("Error")
                }
            } catch (e: IOException) {
                e.printStackTrace()
                Timber.e(e)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        // Clear our job when the linked activity is destroyed to avoid memory leaks
        job.cancel()
    }

    fun getAuth(): LoginResponse? {
        return auth
    }

    fun setAuth(auth: LoginResponse?) {
        this.auth = auth
    }


}