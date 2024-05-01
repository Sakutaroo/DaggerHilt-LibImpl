package fr.sakutaroo.userup.feature_list.domain.use_case

import fr.sakutaroo.userup.feature_list.domain.model.User
import fr.sakutaroo.userup.feature_list.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUsers(
    private val repository: UserRepository
) {
    operator fun invoke(): Flow<List<User>> {
        return repository.getUsers()
    }
}
