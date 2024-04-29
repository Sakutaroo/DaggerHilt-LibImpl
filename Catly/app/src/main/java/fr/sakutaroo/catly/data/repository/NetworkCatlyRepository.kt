package fr.sakutaroo.catly.data.repository

import fr.sakutaroo.catly.data.remote.CatlyApiService
import fr.sakutaroo.catly.domain.repository.CatFactRepository
import fr.sakutaroo.catly.model.CatFact

class NetworkCatlyRepository(
    private val catlyApiService: CatlyApiService
): CatFactRepository {
    override suspend fun getCatFact(): CatFact = catlyApiService.getCatFact()
}
