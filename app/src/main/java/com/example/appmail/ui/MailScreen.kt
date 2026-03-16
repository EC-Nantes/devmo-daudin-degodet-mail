package com.example.appmail.ui

import android.app.Activity
import android.text.BoringLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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



//à faire pour les maquettes : préférence et réglage
//et pour le code : passage en paysage avec un bouton de suivi/favoris qui doit rester dans son état


@Composable
fun MailLayout(
    objet: String,
    expeditor: String,
    category : String,
    receiver: String,
    mailFollowed: Boolean,
    content: String,
    mailViewModel: MailViewModel,
    modifier: Modifier = Modifier
)
{

    TopRow(
        modifier = modifier.verticalScroll(rememberScrollState()),
        mailCategory = category
    )
    Box(
        modifier= Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ){
    ObjectRow(
        modifier = modifier,
        mailObject = objet,
        mailFollowed = mailFollowed,
        mailViewModel = mailViewModel
    )


    Spacer(
        modifier = Modifier
            .height(16.dp)
    )

    InfoRow(
        modifier = modifier,
        expeditor = expeditor,
        receiver = receiver
    )

    ContentRow(
        modifier = modifier,
        content = content
    )



    IARow(
        modifier = modifier.align(Alignment.BottomCenter)
    )}
}

@Composable
fun MailScreen(
    mailViewModel: MailViewModel = viewModel()
)
{
    val mediumPadding = dimensionResource(R.dimen.padding_medium)
    val mailUiState by mailViewModel.uiState.collectAsState()


    Spacer(
        modifier = Modifier
            .height(8.dp)
    )

    /*Column(
        modifier = Modifier
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding()
            .padding(mediumPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {



    }*/
    MailLayout(objet = mailUiState.mailObject,
        expeditor= mailUiState.mailExpeditor,
        receiver = mailUiState.mailReceiver,
        content=mailUiState.mailContent,
        mailFollowed = mailUiState.mailFollowed,
        category = mailUiState.mailCategory,
        mailViewModel=mailViewModel,
        modifier = Modifier.padding(20.dp).fillMaxSize()
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopRow(
    modifier:Modifier,
    mailCategory: String,
){
    val buttonSize = 45.dp
    TopAppBar(
        modifier=modifier.padding(0.dp)
            .fillMaxWidth(),
        title={
            Text(
                text = stringResource(R.string.category, mailCategory),
                style = typography.headlineSmall,
                modifier = Modifier.padding(8.dp)
            )
        },
        actions ={
            Button(
                modifier = Modifier
                    .size(buttonSize)
                    .padding(start = 8.dp),
                onClick = { }
            ) {
                (Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "à faire")
                        )
            }
            Text(
                text =mailCategory,
                style = typography.bodyMedium,
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            )
            Button(
                modifier = Modifier
                    .size(buttonSize)
                    .padding(start = 8.dp),
                onClick = { }
            ) {
                (Icon(
                    imageVector = Icons.Default.Build,
                    contentDescription = "à faire")
                        )
            }
            Button(
                modifier = Modifier
                    .size(buttonSize)
                    .padding(start = 8.dp),
                onClick = { }
            ) {
                (Icon(
                    imageVector = Icons.Default.Build,
                    contentDescription = "à faire")
                        )
            }
            Button(
                modifier = Modifier
                    .size(buttonSize)
                    .padding(start = 8.dp),
                onClick = { }
            ) {
                (Icon(
                    imageVector = Icons.Default.Build,
                    contentDescription = "à faire")
                        )
            }
            Button(
                modifier = Modifier
                    .size(buttonSize)
                    .padding(start = 8.dp),
                onClick = { }
            ) {
                (Icon(
                    imageVector = Icons.Default.Build,
                    contentDescription = "à faire")
                        )
            }
            Button(
                modifier = Modifier
                    .size(buttonSize)
                    .padding(start = 8.dp),
                onClick = { }
            ) {
                (Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "à faire")
                        )
            }
        }
    )
}


@Composable
fun ObjectRow(
    modifier:Modifier,
    mailObject : String,
    mailFollowed: Boolean,
    mailViewModel: MailViewModel
){

        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 60.dp),
            ){
            Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment=Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

        ) {
        Text(
            text = stringResource(R.string.objet)+ mailObject,
            //style = typography.headlineMedium,
            modifier = Modifier
                .weight(1f)
                //.padding(top = 45.dp)
                )

            Button(
                modifier = Modifier,
                onClick = { mailViewModel.updateFollow(mailFollowed)}
            ) {
                if (mailFollowed){
                Icon(
                    imageVector =Icons.Filled.Star,
                    contentDescription = "arreter de suivre"
                )}
                else {
                    Icon(
                        imageVector = Icons.Outlined.Star,
                        contentDescription = "faire suivre"
                    )

            }}

    }}
}
@Composable
fun InfoRow(
    modifier:Modifier,
    expeditor:String,
    receiver: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 160.dp)
    )
    {
        Column(
            modifier = modifier
                .fillMaxWidth(),//.padding(mediumPadding),
            //verticalArrangement = Arrangement.spacedBy(mediumPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(modifier = Modifier.fillMaxWidth())
            {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "répondre")
                Text(stringResource(R.string.expeditor)+expeditor)
                Spacer(modifier.width(1.dp))
                Text(stringResource(R.string.receiver)+receiver)
                Spacer(Modifier.weight(1f))



                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Default.Build, contentDescription = "répondre")
                    Icon(
                        imageVector = Icons.Default.Build,
                        contentDescription = "Signaler comme spam"
                    )
                    Icon(imageVector = Icons.Default.Build, contentDescription = "transférer")
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = "plus d'action")
                }
            }
        }
    }
}
@Composable
fun ContentRow(
    modifier:Modifier,
    content:String
){
    Text(
        text = content,
        style = typography.headlineMedium,
        modifier = Modifier
            .padding(top=250.dp, bottom=8.dp)
    )}


@Composable
fun IARow(
    modifier:Modifier,
){
        Row(
            modifier = modifier
            .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
       horizontalArrangement=Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
){
    Button(
        modifier = modifier.weight(1f)
                ,
        onClick = { }
    ) {
        (Icon(
            imageVector = Icons.Default.Build,
            contentDescription = "à faire")
                )
        Text(
            text= "résumé"
        )
    }
    Button(
        modifier = Modifier.weight(1f)
            ,
        onClick = { }
    ) {
        (Icon(
            imageVector = Icons.Default.Build,
            contentDescription = "à faire")
                )
        Text(
            text= "répondre"
        )
    }
}}



    @Preview(showBackground = true)
    @Composable
    fun MailScreenPreview() {
        AppMailTheme {
            MailScreen()
        }
    }


