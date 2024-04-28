package edu.ukma.lecture2

sealed class UIState {
    data object Loading : UIState()

    data class Success(val data: String) : UIState()

    data class Error(val exception: Exception) : UIState()
}

fun updateUI(state: UIState) {
    when (state) {
        is UIState.Loading -> {
            // showLoadingIndicator()
        }

        is UIState.Success -> {
            // showData(state.data)
        }

        is UIState.Error -> {
            // showError(state.exception)
        }
        // else не потрібно
    }
}
