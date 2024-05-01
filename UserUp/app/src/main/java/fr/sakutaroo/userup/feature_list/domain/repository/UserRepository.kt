package fr.sakutaroo.userup.feature_list.domain.repository

import fr.sakutaroo.userup.feature_list.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers(): Flow<List<User>>

    suspend fun insertUser(user: User)

    suspend fun deleteUser(user: User)
}
