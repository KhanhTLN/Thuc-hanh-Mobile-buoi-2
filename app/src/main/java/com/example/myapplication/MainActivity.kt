package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.data.DanangLocations
import com.example.myapplication.data.HanoiLocations
import com.example.myapplication.data.LocationItem
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val hanoiLocations = remember { HanoiLocations.getLocations() }
    val danangLocations = remember { DanangLocations.getLocations() }
    val allLocations = remember {
        val list = ArrayList<LocationItem>()
        list.addAll(hanoiLocations)
        list.addAll(danangLocations)
        list
    }

    var searchQuery by remember { mutableStateOf("") }
    
    // Direct search on LocationItem list
    val searchResults = remember(searchQuery) {
        if (searchQuery.isBlank()) {
            emptyList()
        } else {
            allLocations.filter { 
                it.name.contains(searchQuery, true) || 
                it.address.contains(searchQuery, true)
            }
        }
    }

    // City Spinner States
    val cities = listOf("Thành phố Hà Nội", "Thành phố Đà Nẵng")
    var expandedCity by remember { mutableStateOf(false) }
    var selectedCityText by remember { mutableStateOf("Thành phố Hà Nội") } // Default to Hanoi

    // Current locations based on selected city
    val currentLocationList = remember(selectedCityText) {
        when (selectedCityText) {
            "Thành phố Hà Nội" -> hanoiLocations
            "Thành phố Đà Nẵng" -> danangLocations
            else -> hanoiLocations
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        // 1. MSSV - Họ tên
        Text(
            text = "B23DCCE053 - Trần Lê Nam Khánh",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        
        Spacer(modifier = Modifier.height(12.dp))

        // 2. Tiêu đề "Danh sách địa điểm"
        Text(
            text = "Danh sách địa điểm",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 3. Ô text để search trực tiếp
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Tìm kiếm theo tên hoặc địa điểm...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { searchQuery = "" }) {
                        Icon(Icons.Default.Clear, contentDescription = "Clear Search")
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (searchQuery.isNotBlank()) {
            // Hiển thị kết quả tìm kiếm trực tiếp dạng danh sách
            Text(
                text = "Kết quả tìm kiếm (${searchResults.size}):",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            if (searchResults.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Không tìm thấy địa điểm phù hợp với \"$searchQuery\"",
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(searchResults.size) { index ->
                        val location = searchResults[index]
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    val intent = Intent(context, DetailActivity::class.java).apply {
                                        putExtra("location_item", location)
                                    }
                                    context.startActivity(intent)
                                },
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = location.name,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "${location.address}",
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.secondary
                                )
                            }
                        }
                    }
                }
            }
        } else {
            // Khi không tìm kiếm: hiển thị Spinner chọn Thành phố, và bên dưới là danh sách các danh lam thắng cảnh của thành phố đó
            Text(
                text = "Chọn Thành phố",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            ExposedDropdownMenuBox(
                expanded = expandedCity,
                onExpandedChange = { expandedCity = !expandedCity },
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = selectedCityText,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedCity) },
                    modifier = Modifier
                        .menuAnchor(MenuAnchorType.PrimaryNotEditable, true)
                        .fillMaxWidth()
                )

                ExposedDropdownMenu(
                    expanded = expandedCity,
                    onDismissRequest = { expandedCity = false }
                ) {
                    cities.forEach { city ->
                        DropdownMenuItem(
                            text = { Text(city) },
                            onClick = {
                                selectedCityText = city
                                expandedCity = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Danh sách danh lam thắng cảnh ($selectedCityText):",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(currentLocationList.size) { index ->
                    val location = currentLocationList[index]
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                val intent = Intent(context, DetailActivity::class.java).apply {
                                    putExtra("location_item", location)
                                }
                                context.startActivity(intent)
                            },
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = location.name,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "${location.address}",
                                fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.secondary
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MyApplicationTheme {
        MainScreen()
    }
}
