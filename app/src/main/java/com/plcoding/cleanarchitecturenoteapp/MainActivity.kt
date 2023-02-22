package com.plcoding.cleanarchitecturenoteapp

import android.os.Bundle
import android.transition.Scene
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgs
import androidx.navigation.navArgument
import com.google.android.material.shape.MarkerEdgeTreatment
import com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.edit_note.AddEditNoteScreen
import com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.edit_note.AddEditNoteViewModel
import com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.edit_questions.EditQuestionsScreen
import com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.notes.NotesScreen
import com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.util.Screen
import com.plcoding.cleanarchitecturenoteapp.ui.theme.CleanArchitectureNoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchitectureNoteAppTheme {
                androidx.compose.material.Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    var viewModel:AddEditNoteViewModel = hiltViewModel()
                    NavHost(navController = navController, startDestination = Screen.NotesScreen.route){
                        composable(route = Screen.NotesScreen.route){navBackStackEntry->
                            val parentEntry = remember(navBackStackEntry){
                                navController.getBackStackEntry(Screen.NotesScreen.route)
                            }
                            NotesScreen(navController = navController)
                        }
                        composable(
                            route = Screen.AddEditNoteScreen.route + "?noteId={noteId}&noteColor={noteColor}",
                            arguments = listOf(
                                navArgument(name="noteId"){ type= NavType.IntType;defaultValue = -1}, navArgument("noteColor"){type = NavType.IntType; defaultValue = -1})
                        ){navBackStackEntry->
                            val parentEntry = remember(navBackStackEntry){
                                navController.getBackStackEntry(Screen.AddEditNoteScreen.route+"?noteId={noteId}&noteColor={noteColor}")
                            }

                            val color = navBackStackEntry.arguments?.getInt("noteColor") ?: -1
                            AddEditNoteScreen(
                                navController = navController,
                                noteColor = color ,
                                viewModel = viewModel
                            )
                        }
                        composable(
                            route = Screen.EditQuestionsRoute.route,

                        ){navBackStackEntry ->
                            val parentEntry = remember(navBackStackEntry) {
                                navController.getBackStackEntry(Screen.EditQuestionsRoute.route)
                            }
                            EditQuestionsScreen(navController = navController, viewModel = viewModel )
                        }
                    }
                }
            }
        }
    }
}
