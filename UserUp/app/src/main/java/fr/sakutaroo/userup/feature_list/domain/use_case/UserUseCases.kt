package fr.sakutaroo.userup.feature_list.domain.use_case

data class UserUseCases(
    val getUsers: GetUsers,
    val insertUser: InsertUser,
    val deleteUser: DeleteUser
)
