package com.example.appmail.ui


//les textes proposés sont des placeholder
data class MailUiState(
    val mailObject:String="Objet?",
    val mailContent:String="Texte du message?",
    val mailExpeditor:String="Expéditeur?",
    val mailReceiver:String="Destinataire?",
    val mailCategory:String="Catégorie?",

    val mailFollowed: Boolean=false,
) {
}