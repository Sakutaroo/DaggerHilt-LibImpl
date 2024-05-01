package fr.sakutaroo.userup.feature_list.domain.use_case

import fr.sakutaroo.userup.feature_list.domain.model.InvalidUserException
import fr.sakutaroo.userup.feature_list.domain.model.User
import fr.sakutaroo.userup.feature_list.domain.repository.UserRepository

class InsertUser(
    private val repository: UserRepository
) {
    suspend operator fun invoke(user: User) {
        if (user.name.isBlank()) {
            throw InvalidUserException("The name of the user can't be empty.")
        }
        if (user.work.isBlank()) {
            throw InvalidUserException("The work of the user can't be empty.")
        }
        repository.insertUser(user)
    }
}
