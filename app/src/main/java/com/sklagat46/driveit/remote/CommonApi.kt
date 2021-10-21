package com.sklagat46.driveit.remote

import com.sklagat46.driveit.models.LoginResponse
import com.sklagat46.driveit.models.LoginUser
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

/**
 * CommonApi
 */
interface CommonApi {
    /**
     * loginAsync
     */
    @POST("api/users/2")
    fun loginAsync(@Body user: LoginUser): Deferred<Response<LoginResponse>>

}
