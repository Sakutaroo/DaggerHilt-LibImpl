package fr.sakutaroo.userup.feature_list.domain.use_case

import fr.sakutaroo.userup.feature_list.domain.model.User
import fr.sakutaroo.userup.feature_list.domain.repository.UserRepository

class DeleteUser(
    private val repository: UserRepository
) {
    suspend operator fun invoke(user: User) {
        repository.deleteUser(user)
    }
}
