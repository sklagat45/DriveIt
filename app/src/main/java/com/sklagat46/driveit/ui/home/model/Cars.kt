package com.sklagat46.driveit.ui.home.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

class Cars {
    var id: String? = null
    var type: String? = null
    var model: String? = null
    var dealType: String? = null
    var imageUrl: String? = null
}
