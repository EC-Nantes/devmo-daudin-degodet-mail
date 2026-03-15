package com.example.appmail.ui

data class MailUiState(
    val mailObject:String="",
    val mailContent:String="",
    val mailExpeditor:String="",
    val mailReceiver:String="",
    val mailCategory:String="",

    val mailFollowed: Boolean=false,
) {
}