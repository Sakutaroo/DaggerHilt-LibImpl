package fr.sakutaroo.userup.feature_list.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    val id: Int = 0,
    val name: String,
    val work: String
)

class InvalidUserException(message: String): Exception(message)
