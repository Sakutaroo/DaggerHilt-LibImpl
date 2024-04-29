package fr.sakutaroo.catly.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.sakutaroo.catly.domain.repository.CatFactRepository
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

sealed interface HomeUiState {
    data class Success(val fact: String): HomeUiState
    data object Error: HomeUiState
    data object Loading: HomeUiState
}

@HiltViewModel
class HomeViewModel @Inject constructor(
    catFactRepository: Lazy<CatFactRepository>
): ViewModel() {
    private val repository = catFactRepository.get()
    var homeUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)

    init {
        loadFact()
    }

    fun loadFact() {
        homeUiState = HomeUiState.Loading
        viewModelScope.launch {
            homeUiState = try {
                HomeUiState.Success(repository.getCatFact().fact)
            } catch (_: IOException) {
                HomeUiState.Error
            }
        }
    }
}
