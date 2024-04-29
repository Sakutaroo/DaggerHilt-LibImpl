package fr.sakutaroo.catly.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import fr.sakutaroo.catly.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val homeViewModel: HomeViewModel = hiltViewModel<HomeViewModel>()

    when (val homeUiState = homeViewModel.homeUiState) {
        is HomeUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is HomeUiState.Success -> ResultScreen(
            fact = homeUiState.fact,
            onClickReload = { homeViewModel.loadFact() },
            modifier = modifier
        )
        is HomeUiState.Error -> ErrorScreen(
            retryAction = { homeViewModel.loadFact() },
            modifier = modifier.fillMaxSize()
        )
    }
}

@Composable
fun ResultScreen(
    fact: String,
    onClickReload: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.cat_fact),
                modifier = Modifier.padding(bottom = 8.dp),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = fact,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )
            Button(
                onClick = onClickReload,
                modifier = Modifier.padding(top = 16.dp),
            ) {
                Text(text = stringResource(id = R.string.reload))
            }
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.loading_img),
        contentDescription = stringResource(id = R.string.loading),
        modifier = modifier
            .size(200.dp)
    )
}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error),
            contentDescription = ""
        )
        Text(
            text = stringResource(id = R.string.loading_failed),
            modifier = Modifier
                .padding(16.dp)
        )
        Button(onClick = retryAction) {
            Text(text = stringResource(id = R.string.retry))
        }
    }
}
