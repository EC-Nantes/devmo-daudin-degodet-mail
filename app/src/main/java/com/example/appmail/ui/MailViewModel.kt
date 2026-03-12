package com.example.appmail.ui

import androidx.lifecycle.ViewModel
import com.example.appmail.data.mailData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MailViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(MailUiState())
    val uiState: StateFlow<MailUiState> = _uiState.asStateFlow()
    lateinit var currentMail: Set<String>

    fun pickRandomMail(){
        currentMail = mailData.random()
    }

    init{
    pickRandomMail()
    }

}