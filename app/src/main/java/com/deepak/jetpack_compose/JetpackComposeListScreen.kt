package com.deepak.jetpack_compose

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.deepak.jetpack_compose.data.DataSource.uiItems
import com.deepak.jetpack_compose.data.getFriendList
import com.deepak.jetpack_compose.text.SimpleText
import com.deepak.jetpack_compose.text.StyleText
import com.deepak.jetpack_compose.text.TextFields
import com.deepak.jetpack_compose.ui.theme.JetpackComposeTheme
import com.deepak.jetpack_compose.uicomponents.AlertDialogComp
import com.deepak.jetpack_compose.uicomponents.BoxComp
import com.deepak.jetpack_compose.uicomponents.ButtonComp
import com.deepak.jetpack_compose.uicomponents.CardComponent
import com.deepak.jetpack_compose.uicomponents.ColumnComp
import com.deepak.jetpack_compose.uicomponents.ConstraintLayoutComponent
import com.deepak.jetpack_compose.uicomponents.CountriesDialog
import com.deepak.jetpack_compose.uicomponents.CountriesDialogUsingLazyColumn
import com.deepak.jetpack_compose.uicomponents.ImageComponent
import com.deepak.jetpack_compose.uicomponents.LazyColumnComp
import com.deepak.jetpack_compose.uicomponents.LazyRowComp
import com.deepak.jetpack_compose.uicomponents.RowComponent
import com.deepak.jetpack_compose.uicomponents.SingleChoiceDialogComp
import com.deepak.jetpack_compose.uicomponents.SingleChoiceDialogWithLazyColumnComp

/**
 * enum values that represent the screens in the app
 */
enum class JetpackScreen(@StringRes val title: Int) {
    StartList(title = R.string.app_name),
    SimpleText(title = R.string.simple_text),
    StyleText(title = R.string.style_text),
    TextField(title = R.string.text_field),
    Column(title = R.string.column),
    LazyColumn(title = R.string.lazy_column),
    Row(title = R.string.row),
    LazyRow(title = R.string.lazy_row),
    Box(title = R.string.box),
    ConstraintLayout(title = R.string.constraint_layout),
    Button(title = R.string.button),
    Card(title = R.string.card),
    Image(title = R.string.image),
    AlertDialog(title = R.string.alert_dialog),
    SingleChoiceDialog(title = R.string.single_choice_dialog),
    SingleChoiceDialogLazyColumn(title = R.string.single_choice_dialog_lazy_column)
}

@Composable
fun JetpackComposeAppScreens(
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = JetpackScreen.valueOf(
        backStackEntry?.destination?.route ?: JetpackScreen.StartList.name
    )

    JetpackComposeTheme {
        Scaffold(
            topBar = {
                AddAppBar(
                    currentScreen = currentScreen,
                    canNavigateBack = navController.previousBackStackEntry != null,
                    navigateUp = { navController.navigateUp() }
                )
            },
            content = { padding ->
                NavHost(
                    navController = navController,
                    startDestination = JetpackScreen.StartList.name,
                    modifier = Modifier
                        .fillMaxSize()
                        //.verticalScroll(rememberScrollState())
                        .padding(padding)
                ) {
                    composable(route = JetpackScreen.StartList.name) {
                        ListItems(
                            uiItems,
                            onNextButtonClicked = {
                                when (it) {
                                    context.getString(R.string.simple_text) -> {
                                        navController.navigate(JetpackScreen.SimpleText.name)
                                    }

                                    context.getString(R.string.style_text) -> {
                                        navController.navigate(JetpackScreen.StyleText.name)
                                    }

                                    context.getString(R.string.text_field) -> {
                                        navController.navigate(JetpackScreen.TextField.name)
                                    }

                                    context.getString(R.string.column) -> {
                                        navController.navigate(JetpackScreen.Column.name)
                                    }

                                    context.getString(R.string.lazy_column) -> {
                                        navController.navigate(JetpackScreen.LazyColumn.name)
                                    }

                                    context.getString(R.string.row) -> {
                                        navController.navigate(JetpackScreen.Row.name)
                                    }

                                    context.getString(R.string.lazy_row) -> {
                                        navController.navigate(JetpackScreen.LazyRow.name)
                                    }

                                    context.getString(R.string.box) -> {
                                        navController.navigate(JetpackScreen.Box.name)
                                    }

                                    context.getString(R.string.constraint_layout) -> {
                                        navController.navigate(JetpackScreen.ConstraintLayout.name)
                                    }

                                    context.getString(R.string.button) -> {
                                        navController.navigate(JetpackScreen.Button.name)
                                    }

                                    context.getString(R.string.card) -> {
                                        navController.navigate(JetpackScreen.Card.name)
                                    }

                                    context.getString(R.string.image) -> {
                                        navController.navigate(JetpackScreen.Image.name)
                                    }

                                    context.getString(R.string.alert_dialog) -> {
                                        navController.navigate(JetpackScreen.AlertDialog.name)
                                    }

                                    context.getString(R.string.single_choice_dialog) -> {
                                        navController.navigate(JetpackScreen.SingleChoiceDialog.name)
                                    }

                                    context.getString(R.string.single_choice_dialog_lazy_column) -> {
                                        navController.navigate(JetpackScreen.SingleChoiceDialogLazyColumn.name)
                                    }
                                }
                            }
                        )
                    }
                    composable(route = JetpackScreen.SimpleText.name) {
                        SimpleText("Simple Text")
                    }

                    composable(route = JetpackScreen.StyleText.name) {
                        StyleText()
                    }

                    composable(route = JetpackScreen.TextField.name) {
                        TextFields()
                    }

                    composable(route = JetpackScreen.Column.name) {
                        ColumnComp()
                    }

                    composable(route = JetpackScreen.LazyColumn.name) {
                        LazyColumnComp(getFriendList())
                    }

                    composable(route = JetpackScreen.Row.name) {
                        RowComponent()
                    }

                    composable(route = JetpackScreen.LazyRow.name) {
                        LazyRowComp(getFriendList())
                    }

                    composable(route = JetpackScreen.Box.name) {
                        BoxComp()
                    }

                    composable(route = JetpackScreen.ConstraintLayout.name) {
                        ConstraintLayoutComponent()
                    }

                    composable(route = JetpackScreen.Button.name) {
                        ButtonComp()
                    }

                    composable(route = JetpackScreen.Card.name) {
                        CardComponent()
                    }

                    composable(route = JetpackScreen.Image.name) {
                        ImageComponent()
                    }

                    composable(route = JetpackScreen.AlertDialog.name) {
                        AlertDialogComp()
                    }

                    composable(route = JetpackScreen.SingleChoiceDialog.name) {
                        CountriesDialog()
                        SingleChoiceDialogComp()
                    }

                    composable(route = JetpackScreen.SingleChoiceDialogLazyColumn.name) {
                        CountriesDialogUsingLazyColumn()
                        SingleChoiceDialogWithLazyColumnComp()
                    }
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAppBar(
    currentScreen: JetpackScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(stringResource(currentScreen.title))
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}
