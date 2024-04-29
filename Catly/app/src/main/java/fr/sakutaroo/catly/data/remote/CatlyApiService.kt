package fr.sakutaroo.catly.data.remote

import fr.sakutaroo.catly.model.CatFact
import retrofit2.http.GET

interface CatlyApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFact
}
