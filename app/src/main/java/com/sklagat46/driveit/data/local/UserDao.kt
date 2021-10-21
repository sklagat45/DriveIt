package com.sklagat46.driveit.data.local

import androidx.room.Dao
import androidx.room.Query
import com.sklagat46.driveit.data.local.BaseDao
import com.sklagat46.driveit.models.User
import com.sklagat46.driveit.models.UserTest

@Dao
internal interface UserDao : BaseDao<UserTest> {
    @Query("SELECT * FROM UserTest WHERE userId  =:userId LIMIT 1")
    fun findUserById(userId: String): User
}