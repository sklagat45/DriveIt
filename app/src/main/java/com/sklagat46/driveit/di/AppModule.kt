package com.sklagat46.driveit.di

import android.content.Context
import androidx.room.Room
import com.sklagat46.driveit.BuildConfig
import com.sklagat46.driveit.data.local.Settings
import com.sklagat46.driveit.utils.Constants
import com.sklagat46.driveit.data.local.Database
import com.sklagat46.driveit.data.repository.LoginRepository
import com.sklagat46.driveit.data.repository.LoginRepositoryImpl
import com.sklagat46.driveit.remote.CommonApi
import com.sklagat46.driveit.ui.auth.viewmodel.LoginViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val appModule = module {

    single { createNetworkClient(baseUrl, settings = get()) }
    single { (get() as? Retrofit)?.create(CommonApi::class.java) }

    single {
        Room.databaseBuilder( androidContext(), Database::class.java, "driveIt.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    single {
        get<Database>().userDao()
    }


    factory<LoginRepository> {
        LoginRepositoryImpl(
            commonApi = get()
        )
    }



    viewModel {
        LoginViewModel(
            loginRepository = get(),
            retrofit = get()
        )
    }

    single {
        androidApplication().getSharedPreferences("PREFERENCES", Context.MODE_PRIVATE)
    }
    single {
        Settings(get())
    }

}

val baseUrl: String = when (BuildConfig.BUILD_TYPE) {
    "staging" -> Constants.BASE_URL_STAGING
    "release" -> Constants.BASE_URL_RELEASE
    else -> Constants.BASE_URL_STAGING
}



