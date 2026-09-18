package com.example.ui

import androidx.lifecycle.ViewModel
import com.example.data.CameraRepository
import com.example.model.Country
import com.example.model.LiveCamera
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class CameraUiState(
    val countries: List<Country> = CameraRepository.countries,
    val selectedCountry: Country? = null,
    val searchQuery: String = "",
    val activeCamera: LiveCamera? = null,
    val isCustomPlayerOpen: Boolean = false
)

class CameraViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CameraUiState())
    val uiState: StateFlow<CameraUiState> = _uiState.asStateFlow()

    fun selectCountry(country: Country?) {
        _uiState.update { it.copy(selectedCountry = country) }
    }

    fun updateSearchQuery(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun openCameraPlayer(camera: LiveCamera) {
        _uiState.update { it.copy(activeCamera = camera) }
    }

    fun closeCameraPlayer() {
        _uiState.update { it.copy(activeCamera = null) }
    }

    fun getFilteredCameras(): List<LiveCamera> {
        val state = _uiState.value
        val countryId = state.selectedCountry?.id
        return CameraRepository.searchCameras(state.searchQuery, countryId)
    }

    fun getRelatedCameras(currentCamera: LiveCamera): List<LiveCamera> {
        return CameraRepository.getCamerasForCountry(currentCamera.countryId)
    }
}
