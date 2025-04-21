package com.arrtish.godemperor.the_vault_android

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arrtish.godemperor.the_vault_android.CharacterStatsTopAppBar
import com.arrtish.godemperor.the_vault_android.ui.theme.TheVaultAndroidTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterStatsTopAppBar(onBackClick: () -> Unit) {
    CenterAlignedTopAppBar(
        title = { Text("Character Sheet") },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },
        actions = {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .clip(CutCornerShape(8.dp))) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_sword),
                    contentDescription = "Sword",
                    tint = Color.Unspecified
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CharacterStatsTopAppBarPreview() {
    TheVaultAndroidTheme {
        CharacterStatsTopAppBar(
            onBackClick = { }
        )
    }
}
