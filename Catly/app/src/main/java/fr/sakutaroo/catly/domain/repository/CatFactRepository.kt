package fr.sakutaroo.catly.domain.repository

import fr.sakutaroo.catly.model.CatFact

interface CatFactRepository {
    suspend fun getCatFact(): CatFact
}
