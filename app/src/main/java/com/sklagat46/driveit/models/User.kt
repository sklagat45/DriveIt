package com.sklagat46.driveit.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: String = "",
    val username: String = "",
    val email: String = "",
    val image: String = ""
) : Parcelable