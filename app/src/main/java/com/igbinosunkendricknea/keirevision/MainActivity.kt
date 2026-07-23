package com.igbinosunkendricknea.keirevision

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.igbinosunkendricknea.keirevision.notePageData.NotesDatabase
import com.igbinosunkendricknea.keirevision.notepage.AddNoteScreen
import com.igbinosunkendricknea.keirevision.notepage.NotesScreen
import com.igbinosunkendricknea.keirevision.notepage.NotesViewModel
import com.igbinosunkendricknea.keirevision.ui.theme.KeiRevisionTheme

@Composable
fun ScrollContent(innerPadding: PaddingValues) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {}
}

class MainActivity : ComponentActivity() {

    private val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            NotesDatabase::class.java,
            "notes.db"
        ).build()
    }

    private val viewModel by viewModels<NotesViewModel> (
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun<T:  ViewModel> create(modelClass: Class<T>): T {
                    return NotesViewModel(database.dao) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KeiRevisionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val state by viewModel.state.collectAsState()
                    val navController = rememberNavController()
                        NavHost(navController = navController, startDestination = "home") {
                            composable("home") {
                                HomepageModule(navController)
                            }
                            composable("homepageDialog") {
                                HomepageButtonDialog(onDismissRequest = { navController.navigateUp() }, navController = navController)
                            }
                            composable("settingPage") {
                                SettingsPage(navController)
                            }
                            composable("calendar") {
                            }
                            composable("timetable") {
                            }
                            composable("studyAmbient") {
                            }
                            composable("agenda") {
                                NotesScreen(
                                state = state,
                                navController = navController,
                                onEvent = viewModel::onEvent
                                )
                            }
                            composable("addNoteScreen") {
                                AddNoteScreen(
                                state = state,
                                navController = navController,
                                onEvent = viewModel::onEvent
                                )
                            }
                            composable("recordings") {
                            }
                            composable("gradingPage") {
                            }
                            composable("teacherPage") {
                        }
                    }
                }
            }
        }
    }
}

