package fr.sakutaroo.userup.feature_list.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.sakutaroo.userup.feature_list.domain.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract val userDao: UserDao

    companion object {
        const val DATABASE_NAME = "users_db"
    }
}
