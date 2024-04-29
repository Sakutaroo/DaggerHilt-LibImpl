package fr.sakutaroo.catly.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import fr.sakutaroo.catly.R
import fr.sakutaroo.catly.ui.home.HomeScreen

@Composable
fun CatlyApp(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = { CatlyTopBar() }
    ) { paddingValues ->
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            HomeScreen(modifier = Modifier.padding(paddingValues))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatlyTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
            )
        },
        modifier = modifier
    )
}
