package fr.sakutaroo.catly.model

import kotlinx.serialization.Serializable

@Serializable
data class CatFact(
    val fact: String
)
