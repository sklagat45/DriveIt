package com.sklagat46.driveit.ui

import android.app.Application
import android.os.Build.FINGERPRINT
import com.sklagat46.driveit.di.appModule
import org.jetbrains.annotations.NotNull
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.error.KoinAppAlreadyStartedException
import timber.log.Timber
import java.util.*
import javax.annotation.Nullable


internal class DriveItApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }


    private fun initKoin() {
        try {
            startKoin {
                androidContext(this@DriveItApplication)
                modules(
                    appModule
                )
            }
        } catch (error: KoinAppAlreadyStartedException) {
            Timber.e(error.localizedMessage)
        }
    }
}