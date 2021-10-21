package com.sklagat46.driveit.data.repository

import com.sklagat46.driveit.models.LoginResponse
import com.sklagat46.driveit.models.LoginUser
import com.sklagat46.driveit.remote.CommonApi
import retrofit2.Response

/**
 * interface LoginRepository
 */
interface LoginRepository {
    /**
     * login
     */
    suspend fun login(user: LoginUser): Response<LoginResponse>

}

/**
 * LoginRepositoryImpl
 */
class LoginRepositoryImpl(
    private val commonApi: CommonApi
) :
    LoginRepository {

    override suspend fun login(user: LoginUser): Response<LoginResponse> {
        return commonApi.loginAsync(user).await()
    }

}
