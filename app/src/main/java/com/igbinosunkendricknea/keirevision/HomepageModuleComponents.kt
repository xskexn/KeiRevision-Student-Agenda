package com.igbinosunkendricknea.keirevision

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopAppBar(onIconClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(bottom = 8.dp),
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("KeiRevision")
                },
                navigationIcon = {
                    IconButton(onClick = { onIconClick() }) {
                        Icon(Icons.Default.Home, contentDescription = null)
                    }
                }
            )
        },
    ) { innerPadding ->
        ScrollContent(innerPadding)
    }
}

@Composable
fun HomeButton(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        FloatingActionButton(
            onClick = {
                navController.navigate("homepageDialog")
                },
            modifier = Modifier
                .align(Alignment.BottomEnd)
        ) {
            Icon(Icons.Filled.Add, "Floating action button for navigation")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppDrawer(navController: NavController) {
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Text("KeiRevision ", modifier = Modifier.padding(16.dp))
                Divider()
                //Creating the items for the Modal Drawer
                NavigationDrawerItem(
                    label = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Icon(Icons.Default.Home, contentDescription = "Homepage")
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Homepage")
                        }
                    },
                    selected = true,
                    onClick = {
                        navController.navigate("home")
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.calendar_button),
                                contentDescription = "Calendar"
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Calendar")
                        }
                    },
                    selected = false,
                    onClick = {
                        navController.navigate("calendar")
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.timetable_icon),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Timetable")
                        }
                    },
                    selected = false,
                    onClick = {
                        navController.navigate("timetable")
                    }
                )
                Divider(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(175.dp)
                )
                NavigationDrawerItem(
                    label = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.study_enviroment_icon),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Study Place")
                        }
                    },
                    selected = false,
                    onClick = {
                        navController.navigate("studyAmbient")
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.agenda_button),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Agenda")
                        }
                    },
                    selected = false,
                    onClick = {
                        navController.navigate("agenda")
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.microphone_icon),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Recordings")
                        }
                    },
                    selected = false,
                    onClick = {
                        navController.navigate("recordings")
                    }
                )
                Divider(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(175.dp)
                )
                NavigationDrawerItem(
                    label = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.grades_icon),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Grades")
                        }
                    },
                    selected = false,
                    onClick = {
                        navController.navigate("gradingPage")
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Icon(
                                Icons.Default.Person,
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Teachers")
                        }
                    },
                    selected = false,
                    onClick = {
                        navController.navigate("teacherPage")
                    }
                )
                Divider(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(175.dp)
                )
                NavigationDrawerItem(
                    label = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Icon(
                                Icons.Default.Settings,
                                contentDescription = "Accessing Setting page"
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Settings")
                        }
                    },
                    selected = false,
                    onClick = {
                        navController.navigate("settingPage")
                    }
                )
            }
        }
    ) { }
}

@Composable
fun HomepageModule(navController: NavController){
    SmallTopAppBar { }
    HomeAppDrawer(navController = navController)
    HomeButton (navController = navController)
}



