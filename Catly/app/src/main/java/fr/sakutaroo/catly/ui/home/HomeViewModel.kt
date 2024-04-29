package fr.sakutaroo.catly.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface HomeUiState {
    data class Success(val fact: String): HomeUiState
    data object Error: HomeUiState
    data object Loading: HomeUiState
}

class HomeViewModel(

): ViewModel() {
    var homeUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)

    init {
        loadFact()
    }

    fun loadFact() {
        homeUiState = HomeUiState.Loading
        viewModelScope.launch {
            homeUiState = try {
                HomeUiState.Success("ok")
            } catch (_: IOException) {
                HomeUiState.Error
            }
        }
    }
}
