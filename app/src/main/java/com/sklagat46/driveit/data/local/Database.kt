package com.sklagat46.driveit.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sklagat46.driveit.models.UserTest

@Database(
    entities = [UserTest::class],
    version = 1
)
@TypeConverters(Converters::class)
internal abstract class Database : RoomDatabase() {
    abstract fun userDao(): UserDao
}
