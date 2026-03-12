package com.example.appmail.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MailViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(MailUiState())
    val uiState: StateFlow<MailUiState> = _uiState.asStateFlow()


    init{

    }

}