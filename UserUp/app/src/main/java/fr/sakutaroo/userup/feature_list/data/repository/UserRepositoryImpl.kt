package fr.sakutaroo.userup.feature_list.data.repository

import fr.sakutaroo.userup.feature_list.data.data_source.UserDao
import fr.sakutaroo.userup.feature_list.domain.model.User
import fr.sakutaroo.userup.feature_list.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(
    private val dao: UserDao
): UserRepository {
    override fun getUsers(): Flow<List<User>> = dao.getUsers()

    override suspend fun insertUser(user: User) = dao.insertUser(user)

    override suspend fun deleteUser(user: User) = dao.deleteUser(user)
}
