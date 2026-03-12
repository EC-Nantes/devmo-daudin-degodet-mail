package com.example.appmail.ui

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appmail.R
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.ViewModel
import com.example.appmail.ui.theme.AppMailTheme




//préférence et réglage (passage en paysage avec un bouton de suivi/favoris)
@Composable
fun MailScreen(
    mailViewModel: MailViewModel = viewModel()
) {
    val mediumPadding = dimensionResource(R.dimen.padding_medium)
    val mailUiState by mailViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding()
            .padding(mediumPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(
            text = stringResource(R.string.app_name),
            style = typography.titleLarge,
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(mediumPadding),
            verticalArrangement = Arrangement.spacedBy(mediumPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                modifier = Modifier.fillMaxWidth()
                    .weight(1f)
                    .padding(start=8.dp),
                onClick = { }
            ) {
                Text(
                    text = stringResource(R.string.submit),
                    fontSize = 16.sp
                )
            }

            OutlinedButton(
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.skip),
                    fontSize = 16.sp
                )
            }
        }

        MailStatus(objet = mailUiState.mailObject,
            expeditor= mailUiState.mailExpeditor,
            category= mailUiState.mailCategory,
            content=mailUiState.mailContent,
            modifier = Modifier.padding(20.dp)
        )
    }
}

@Composable
fun MailStatus(objet: String, expeditor: String, category:String, content:String,  modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.objet, objet),
            style = typography.headlineMedium,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = stringResource(R.string.expeditor, expeditor),
            style = typography.headlineMedium,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = stringResource(R.string.category, category),
            style = typography.headlineMedium,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = content,
            style = typography.headlineMedium,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun MailLayout(
    modifier: Modifier = Modifier
) {
    val mediumPadding = dimensionResource(R.dimen.padding_medium)

    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(mediumPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(mediumPadding)
        ) {
            Text(
                modifier = Modifier
                    .clip(shapes.medium)
                    .background(colorScheme.surfaceTint)
                    .padding(horizontal = 10.dp, vertical = 4.dp)
                    .align(alignment = Alignment.End),
                text = "A modifier dans MailScreen",
                style = typography.titleMedium,
                color = colorScheme.onPrimary
            )
            Text(
                modifier = modifier.align(Alignment.CenterHorizontally),
                text = "A modifier Dans MailScreen",
                fontSize = 45.sp,
                style = typography.displayMedium
            )
            Text(
                text = "A modifier Dans MailScreen",
                textAlign = TextAlign.Center,
                style = typography.titleMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MailScreenPreview() {
    AppMailTheme {
        MailScreen()
    }
}
