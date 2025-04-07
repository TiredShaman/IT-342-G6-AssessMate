package com.example.assessmate
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

// Define app colors
private val PrimaryColor = Color(0xFF3F51B5)
private val SecondaryColor = Color(0xFF03A9F4)
private val AccentColor = Color(0xFFFF9800)
private val LightGrayColor = Color(0xFFF5F5F5)
private val MediumGrayColor = Color(0xFFE0E0E0)
private val DarkGrayColor = Color(0xFF9E9E9E)
private val TextPrimaryColor = Color(0xFF212121)
private val TextSecondaryColor = Color(0xFF757575)

// Data classes
data class Category(val id: Int, val name: String)
data class Course(
    val id: Int,
    val title: String,
    val category: String,
    val rating: Float,
    val students: Int,
    val imageRes: Int
)
data class Mentor(val id: Int, val name: String, val imageRes: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ELearningHomepage(navController: NavHostController) {
    // Sample data
    val categories = listOf(
        Category(1, "3D Design"),
        Category(2, "Arts & Humanities"),
        Category(3, "Graphic Design"),
        Category(4, "Programming"),
        Category(5, "UI/UX Design"),
        Category(6, "Marketing")
    )
    
    val courseCategories = listOf("All", "Graphic Design", "3D Design", "Arts")
    var selectedCategoryIndex by remember { mutableStateOf(0) }
    
    val courses = listOf(
        Course(1, "Programming and Design", "Programming", 4.2f, 7800, R.drawable.placeholder_course1),
        Course(2, "Advertising Mastery", "Marketing", 4.5f, 5200, R.drawable.placeholder_course2),
        Course(3, "UX Research Fundamentals", "UI/UX Design", 4.7f, 3500, R.drawable.placeholder_course3),
        Course(4, "3D Character Modeling", "3D Design", 4.1f, 2900, R.drawable.placeholder_course4)
    )
    
    val mentors = listOf(
        Mentor(1, "Sanja", R.drawable.placeholder_mentor1),
        Mentor(2, "Jensen", R.drawable.placeholder_mentor2),
        Mentor(3, "Victoria", R.drawable.placeholder_mentor3),
        Mentor(4, "Candela", R.drawable.placeholder_mentor4)
    )
    
    // Scaffold with bottom navigation
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            // Greeting section
            item {
                GreetingSection(userName = "Ronald A. Martin")
            }
            
            // Search bar
            item {
                SearchBar()
            }
            
            // Promotional banner
            item {
                PromotionalBanner()
            }
            
            // Categories section
            item {
                SectionHeader(title = "Categories", showSeeAll = true)
            }
            
            item {
                CategoriesList(categories = categories)
            }
            
            // Popular courses section
            item {
                SectionHeader(title = "Popular Courses", showSeeAll = true)
            }
            
            item {
                CourseTabBar(
                    categories = courseCategories,
                    selectedIndex = selectedCategoryIndex,
                    onCategorySelected = { selectedCategoryIndex = it }
                )
            }
            
            item {
                CoursesList(courses = courses)
            }
            
            // Top mentors section
            item {
                SectionHeader(title = "Top Mentor", showSeeAll = true)
            }
            
            item {
                MentorsList(mentors = mentors)
            }
        }
    }
}

@Composable
fun GreetingSection(userName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Hi, $userName",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimaryColor
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "What Would you like to learn today?",
                fontSize = 14.sp,
                color = TextSecondaryColor
            )
        }
        
        // Profile avatar
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.dp, MediumGrayColor, CircleShape)
                .background(LightGrayColor)
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile",
                tint = PrimaryColor,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
fun SearchBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search for...") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    tint = DarkGrayColor
                )
            },
            modifier = Modifier
                .weight(1f)
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = LightGrayColor,
                unfocusedBorderColor = MediumGrayColor
            ),
            singleLine = true
        )
        
        Spacer(modifier = Modifier.width(12.dp))
        
        // Filter button
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(PrimaryColor)
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Filter",
                tint = Color.White
            )
        }
    }
}

@Composable
fun PromotionalBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(SecondaryColor)
    ) {
        // Background design elements
        Box(
            modifier = Modifier
                .size(100.dp)
                .offset(x = 220.dp, y = (-20).dp)
                .clip(CircleShape)
                .background(Color(0x33FFFFFF))
        )
        Box(
            modifier = Modifier
                .size(60.dp)
                .offset(x = 260.dp, y = 50.dp)
                .clip(CircleShape)
                .background(Color(0x33FFFFFF))
        )
        
        // Curved shape at bottom
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .align(Alignment.BottomCenter)
                .background(
                    Color(0xFF1976D2),
                    shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)
                )
        )
        
        // Banner content
        Column(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 24.dp)
        ) {
            Text(
                text = "Today's Special",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Enroll Now!",
                color = Color.White,
                fontSize = 16.sp
            )
        }
        
        // Page indicator dots
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            repeat(3) { index ->
                Box(
                    modifier = Modifier
                        .size(width = if (index == 0) 24.dp else 8.dp, height = 8.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(if (index == 0) AccentColor else Color.White.copy(alpha = 0.5f))
                )
            }
        }
    }
}

@Composable
fun SectionHeader(title: String, showSeeAll: Boolean = false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimaryColor
        )
        
        if (showSeeAll) {
            Text(
                text = "SEE ALL",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = PrimaryColor,
                modifier = Modifier.clickable { }
            )
        }
    }
}

@Composable
fun CategoriesList(categories: List<Category>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(categories) { category ->
            CategoryItem(category)
        }
    }
}

@Composable
fun CategoryItem(category: Category) {
    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(LightGrayColor)
            .clickable { }
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = category.name,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = TextPrimaryColor
        )
    }
}

@Composable
fun CourseTabBar(categories: List<String>, selectedIndex: Int, onCategorySelected: (Int) -> Unit) {
    ScrollableTabRow(
        selectedTabIndex = selectedIndex,
        edgePadding = 16.dp,
        containerColor = Color.Transparent,
        contentColor = PrimaryColor,
        divider = {},
        indicator = { tabPositions ->
            if (selectedIndex < tabPositions.size) {
                // Empty indicator because we'll use background color for selected tab
            }
        }
    ) {
        categories.forEachIndexed { index, category ->
            Tab(
                selected = index == selectedIndex,
                onClick = { onCategorySelected(index) },
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(if (index == selectedIndex) PrimaryColor else Color.Transparent)
                        .border(
                            width = if (index == selectedIndex) 0.dp else 1.dp,
                            color = if (index == selectedIndex) Color.Transparent else MediumGrayColor,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = category,
                        color = if (index == selectedIndex) Color.White else TextSecondaryColor,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

@Composable
fun CoursesList(courses: List<Course>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(courses) { course ->
            CourseCard(course)
        }
    }
}

@Composable
fun CourseCard(course: Course) {
    Card(
        modifier = Modifier
            .width(240.dp)
            .clickable { },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            // Course image
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .background(MediumGrayColor)
            ) {
                // Replace with actual image resource when available
                // For now, using a placeholder
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.Center),
                    tint = DarkGrayColor
                )
                
                // Category chip
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(AccentColor)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = course.category,
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                
                // Bookmark icon
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Bookmark",
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .size(24.dp)
                )
            }
            
            // Course details
            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                Text(
                    text = course.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimaryColor,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null,
                        tint = Color(0xFFFFC107),
                        modifier = Modifier.size(16.dp)
                    )
                    
                    Spacer(modifier = Modifier.width(4.dp))
                    
                    Text(
                        text = course.rating.toString(),
                        fontSize = 14.sp,
                        color = TextPrimaryColor
                    )
                    
                    Spacer(modifier = Modifier.width(12.dp))
                    
                    Text(
                        text = "${course.students} Students",
                        fontSize = 14.sp,
                        color = TextSecondaryColor
                    )
                }
            }
        }
    }
}

@Composable
fun MentorsList(mentors: List<Mentor>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(mentors) { mentor ->
            MentorItem(mentor)
        }
    }
}

@Composable
fun MentorItem(mentor: Mentor) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(70.dp)
    ) {
        // Mentor image
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(MediumGrayColor),
            contentAlignment = Alignment.Center
        ) {
            // Replace with actual image when available
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                tint = DarkGrayColor
            )
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = mentor.name,
            fontSize = 14.sp,
            color = TextPrimaryColor,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val selectedColor = Color(0xFF3F51B5) // Primary blue color
    val unselectedColor = Color(0xFF9E9E9E) // Gray color
    val backgroundColor = Color.White

    NavigationBar(
        containerColor = backgroundColor,
        tonalElevation = 0.dp,
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Home",
                    modifier = Modifier.size(22.dp),
                    tint = selectedColor
                )
            },
            label = {
                Text(
                    text = "Home",
                    fontSize = 10.sp,
                    color = selectedColor,
                    modifier = Modifier.padding(top = 1.dp)
                )
            },
            selected = true,
            onClick = { },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                selectedTextColor = selectedColor,
                indicatorColor = backgroundColor,
                unselectedIconColor = unselectedColor,
                unselectedTextColor = unselectedColor
            ),
            modifier = Modifier.padding(vertical = 1.dp)
        )
        
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.courses),
                    contentDescription = "Courses",
                    modifier = Modifier.size(22.dp),
                    tint = unselectedColor
                )
            },
            label = {
                Text(
                    text = "My\nCourses",
                    fontSize = 10.sp,
                    color = unselectedColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 1.dp)
                )
            },
            selected = false,
            onClick = { navController.navigate("courses") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                selectedTextColor = selectedColor,
                indicatorColor = backgroundColor,
                unselectedIconColor = unselectedColor,
                unselectedTextColor = unselectedColor
            ),
            modifier = Modifier.padding(vertical = 1.dp)
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
            label = {
                Text(
                    text = "Inbox",
                    fontSize = 10.sp,
                    color = unselectedColor,
                    modifier = Modifier.padding(top = 1.dp)
                )
            },
            selected = false,
            onClick = { navController.navigate("inbox") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                selectedTextColor = selectedColor,
                indicatorColor = backgroundColor,
                unselectedIconColor = unselectedColor,
                unselectedTextColor = unselectedColor
            ),
            modifier = Modifier.padding(vertical = 1.dp)
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
            label = {
                Text(
                    text = "Trans\naction",
                    fontSize = 10.sp,
                    color = unselectedColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 1.dp)
                )
            },
            selected = false,
            onClick = { navController.navigate("transaction") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                selectedTextColor = selectedColor,
                indicatorColor = backgroundColor,
                unselectedIconColor = unselectedColor,
                unselectedTextColor = unselectedColor
            ),
            modifier = Modifier.padding(vertical = 1.dp)
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
            label = {
                Text(
                    text = "Profile",
                    fontSize = 10.sp,
                    color = unselectedColor,
                    modifier = Modifier.padding(top = 1.dp)
                )
            },
            selected = false,
            onClick = { navController.navigate("profile") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                selectedTextColor = selectedColor,
                indicatorColor = backgroundColor,
                unselectedIconColor = unselectedColor,
                unselectedTextColor = unselectedColor
            ),
            modifier = Modifier.padding(vertical = 1.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ELearningHomepagePreview() {
    MaterialTheme {
        ELearningHomepage(rememberNavController())
    }
}