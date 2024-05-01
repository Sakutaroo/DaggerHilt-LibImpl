package fr.sakutaroo.userup.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.sakutaroo.userup.feature_list.data.data_source.UserDatabase
import fr.sakutaroo.userup.feature_list.data.repository.UserRepositoryImpl
import fr.sakutaroo.userup.feature_list.domain.repository.UserRepository
import fr.sakutaroo.userup.feature_list.domain.use_case.DeleteUser
import fr.sakutaroo.userup.feature_list.domain.use_case.GetUsers
import fr.sakutaroo.userup.feature_list.domain.use_case.InsertUser
import fr.sakutaroo.userup.feature_list.domain.use_case.UserUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUserDatabase(app: Application): UserDatabase {
        return Room.databaseBuilder(
            app,
            UserDatabase::class.java,
            UserDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserRepository(db: UserDatabase): UserRepository {
        return UserRepositoryImpl(db.userDao)
    }

    @Provides
    @Singleton
    fun provideUserUseCases(repository: UserRepository): UserUseCases {
        return UserUseCases(
            getUsers = GetUsers(repository),
            insertUser = InsertUser(repository),
            deleteUser = DeleteUser(repository)
        )
    }
}
