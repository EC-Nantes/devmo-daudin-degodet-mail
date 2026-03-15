package com.example.appmail.ui

import androidx.lifecycle.ViewModel
import com.example.appmail.data.mailData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.String

class MailViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(MailUiState())
    val uiState: StateFlow<MailUiState> = _uiState.asStateFlow()
    lateinit var mailUiState : MailUiState
    lateinit var currentMail: List<String>

    fun pickRandomMail(){
        currentMail = mailData.random()
        mailUiState = MailUiState(
            mailObject =currentMail[3],
            mailContent =currentMail[5],
            mailExpeditor = currentMail[1],
            mailReceiver = currentMail[2],
            mailCategory = currentMail[4],
        )
    }

    init{
    pickRandomMail()
    }

}