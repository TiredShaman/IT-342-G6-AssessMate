package com.example.assessmate

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.res.painterResource

// Define colors
private val selectedColor = Color(0xFF3F51B5)  // Primary blue color
private val unselectedColor = Color(0xFF9E9E9E)  // Gray color
private val ratingStarColor = Color(0xFFFFC107)  // Yellow color for rating stars

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCoursesScreen(navController: NavController) {
    val categories = listOf("All", "Graphic Design", "3D Design", "Arts & Humanities", "Programming", "Web Development")

    val courses = listOf(
        CourseItem("Programming", "Object Oriented Programming", 4.2f, 7830),
        CourseItem("Graphic Design", "Advertisement Design", 3.9f, 12680),
        CourseItem("Programming", "Graphic Design Advanced", 4.2f, 990),
        CourseItem("Web Development", "Web Developer Concepts", 4.9f, 14580),
        CourseItem("SEO & Marketing", "Digital Marketing Campaign", 4.5f, 8750)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Courses") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { /* No functionality needed */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color.White
            ) {
                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.home),
                            contentDescription = "Home",
                            modifier = Modifier.size(22.dp),
                            tint = unselectedColor
                        )
                    },
                    label = { Text("Home") },
                    selected = false,
                    onClick = { navController.navigate("elearning_homepage") }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.courses),
                            contentDescription = "My Courses",
                            modifier = Modifier.size(22.dp),
                            tint = selectedColor
                        )
                    },
                    label = { Text("My\nCourses") },
                    selected = true,
                    onClick = { }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.inbox),
                            contentDescription = "Inbox",
                            modifier = Modifier.size(22.dp),
                            tint = unselectedColor
                        )
                    },
                    label = { Text("Inbox") },
                    selected = false,
                    onClick = { navController.navigate("inbox") }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.transaction),
                            contentDescription = "Transaction",
                            modifier = Modifier.size(22.dp),
                            tint = unselectedColor
                        )
                    },
                    label = { Text("Trans\naction") },
                    selected = false,
                    onClick = { navController.navigate("transaction") }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = "Profile",
                            modifier = Modifier.size(22.dp),
                            tint = unselectedColor
                        )
                    },
                    label = { Text("Profile") },
                    selected = false,
                    onClick = { navController.navigate("profile") }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF5F5F5))
        ) {
            // Categories chips
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categories) { category ->
                    val isSelected = category == "All"
                    CategoryChip(
                        name = category,
                        isSelected = isSelected
                    )
                }
            }

            // Course list
            LazyColumn(
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(courses) { course ->
                    CourseCard(course)
                }
            }
        }
    }
}

@Composable
fun CategoryChip(name: String, isSelected: Boolean) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = if (isSelected) Color(0xFF069380) else Color.Transparent,
        border = if (!isSelected) BorderStroke(1.dp, Color(0xFFE0E0E0)) else null
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            color = if (isSelected) Color.White else Color(0xFF757575),
            fontWeight = FontWeight.Medium
        )
    }
}

data class CourseItem(
    val category: String,
    val title: String,
    val rating: Float,
    val students: Int
)

@Composable
fun CourseCard(course: CourseItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.height(120.dp)
        ) {
            // Course thumbnail (placeholder)
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .fillMaxHeight()
                    .background(Color.Black)
            )
            
            // Course details
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(12.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Course category
                    Text(
                        text = course.category,
                        color = getCategoryColor(course.category),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                    
                    Spacer(modifier = Modifier.height(4.dp))
                    
                    // Course title
                    Text(
                        text = course.title,
                        color = Color(0xFF212121),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.fillMaxWidth()
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    // Rating and students count
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "Rating",
                            tint = ratingStarColor,
                            modifier = Modifier.size(16.dp)
                        )
                        
                        Spacer(modifier = Modifier.width(4.dp))
                        
                        Text(
                            text = course.rating.toString(),
                            fontSize = 14.sp,
                            color = Color(0xFF212121)
                        )
                        
                        Spacer(modifier = Modifier.width(12.dp))
                        
                        Text(
                            text = "${course.students} Students",
                            fontSize = 14.sp,
                            color = Color(0xFF757575)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun getCategoryColor(category: String): Color {
    return when (category) {
        "Programming" -> Color(0xFFFF6D00)
        "Graphic Design" -> Color(0xFFE65100)
        "Web Development" -> Color(0xFFFF8F00)
        "SEO & Marketing" -> Color(0xFF2E7D32)
        else -> Color(0xFF069380)
    }
}

@Preview(showBackground = true)
@Composable
fun MyCoursesScreenPreview() {
    MaterialTheme {
        MyCoursesScreen(rememberNavController())
    }
}