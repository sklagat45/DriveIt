package com.sklagat46.driveit.models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(indices = [Index(value = ["userId"], unique = true)])
class UserTest {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var userId: String? = null
    var name: String? = null
    var email: String? = null
}
