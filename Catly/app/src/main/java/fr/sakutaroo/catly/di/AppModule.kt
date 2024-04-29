package fr.sakutaroo.catly.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.sakutaroo.catly.data.remote.CatlyApiService
import fr.sakutaroo.catly.data.repository.NetworkCatlyRepository
import fr.sakutaroo.catly.domain.repository.CatFactRepository
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import javax.inject.Singleton
import okhttp3.MediaType.Companion.toMediaType

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCatlyApiService(): CatlyApiService {
        val baseUrl = "https://catfact.ninja"
        val json = Json { ignoreUnknownKeys = true }

        return Retrofit.Builder()
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(baseUrl)
            .build()
            .create(CatlyApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCatFactRepository(catlyApiService: CatlyApiService): CatFactRepository {
        return NetworkCatlyRepository(catlyApiService)
    }
}
