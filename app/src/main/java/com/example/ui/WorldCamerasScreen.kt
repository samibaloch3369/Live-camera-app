package com.example.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Sensors
import androidx.compose.material.icons.filled.Traffic
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.model.Country
import com.example.model.LiveCamera
import com.example.ui.components.BottomCameraSearchBar
import com.example.ui.components.CameraListItemCard
import com.example.ui.components.CountryGridCard
import com.example.ui.components.LiveCameraWebViewPlayer
import com.example.ui.theme.AmberAccent
import com.example.ui.theme.DarkBackground
import com.example.ui.theme.DarkSurface
import com.example.ui.theme.DarkSurfaceBorder
import com.example.ui.theme.DarkSurfaceElevated
import com.example.ui.theme.LiveCyanPrimary
import com.example.ui.theme.LiveRed
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary
import com.example.ui.theme.TextTertiary

@Composable
fun WorldCamerasScreen(
    modifier: Modifier = Modifier,
    viewModel: CameraViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val filteredCameras = viewModel.getFilteredCameras()

    // Handle back button on Android hardware / gesture
    BackHandler(enabled = uiState.activeCamera != null || uiState.selectedCountry != null || uiState.searchQuery.isNotEmpty()) {
        when {
            uiState.activeCamera != null -> viewModel.closeCameraPlayer()
            uiState.searchQuery.isNotEmpty() -> viewModel.updateSearchQuery("")
            uiState.selectedCountry != null -> viewModel.selectCountry(null)
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(DarkBackground)
            .statusBarsPadding()
    ) {
        Scaffold(
            containerColor = DarkBackground,
            bottomBar = {
                // Keep bottom search bar visible when player is not covering screen
                if (uiState.activeCamera == null) {
                    BottomCameraSearchBar(
                        query = uiState.searchQuery,
                        onQueryChange = { viewModel.updateSearchQuery(it) },
                        suggestedCities = listOf(
                            "Tokyo",
                            "New York",
                            "London",
                            "Lahore",
                            "Berlin",
                            "Toronto",
                            "Miami",
                            "Karachi"
                        )
                    )
                }
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // Top Header Bar
                TopHeaderBar(
                    selectedCountry = uiState.selectedCountry,
                    searchQuery = uiState.searchQuery,
                    onBackClick = {
                        if (uiState.searchQuery.isNotEmpty()) {
                            viewModel.updateSearchQuery("")
                        } else {
                            viewModel.selectCountry(null)
                        }
                    }
                )

                // Main Content Body
                AnimatedContent(
                    targetState = Triple(
                        uiState.selectedCountry,
                        uiState.searchQuery.isNotEmpty(),
                        filteredCameras.size
                    ),
                    transitionSpec = { fadeIn() togetherWith fadeOut() },
                    label = "content_transition"
                ) { (country, isSearching, count) ->
                    when {
                        // 1. Search Mode active
                        isSearching -> {
                            SearchResultsView(
                                query = uiState.searchQuery,
                                cameras = filteredCameras,
                                onCameraClick = { viewModel.openCameraPlayer(it) },
                                onClearSearch = { viewModel.updateSearchQuery("") }
                            )
                        }

                        // 2. Country Detail Mode (show YouTube live traffic cameras from that country)
                        country != null -> {
                            CountryCamerasListView(
                                country = country,
                                cameras = filteredCameras,
                                onCameraClick = { viewModel.openCameraPlayer(it) }
                            )
                        }

                        // 3. Home Mode: Grid of Countries + Featured Live Feeds
                        else -> {
                            HomeCountryGridView(
                                countries = uiState.countries,
                                onCountryClick = { viewModel.selectCountry(it) },
                                onCameraClick = { viewModel.openCameraPlayer(it) }
                            )
                        }
                    }
                }
            }
        }

        // Live WebView Player Overlay
        AnimatedVisibility(
            visible = uiState.activeCamera != null,
            enter = slideInVertically(initialOffsetY = { it }) + fadeIn(),
            exit = slideOutVertically(targetOffsetY = { it }) + fadeOut()
        ) {
            uiState.activeCamera?.let { camera ->
                LiveCameraWebViewPlayer(
                    camera = camera,
                    onClose = { viewModel.closeCameraPlayer() },
                    relatedCameras = viewModel.getRelatedCameras(camera),
                    onSelectRelatedCamera = { viewModel.openCameraPlayer(it) }
                )
            }
        }
    }
}

@Composable
private fun TopHeaderBar(
    selectedCountry: Country?,
    searchQuery: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, DarkSurfaceBorder),
        color = DarkSurface
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                if (selectedCountry != null || searchQuery.isNotEmpty()) {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier
                            .size(36.dp)
                            .testTag("top_bar_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back to countries",
                            tint = LiveCyanPrimary
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                } else {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .background(DarkSurfaceElevated, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Public,
                            contentDescription = null,
                            tint = LiveCyanPrimary,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }

                Column {
                    Text(
                        text = when {
                            searchQuery.isNotEmpty() -> "Search Results"
                            selectedCountry != null -> "${selectedCountry.flag} ${selectedCountry.name} Live Cams"
                            else -> "World Live Road Cams"
                        },
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = when {
                            searchQuery.isNotEmpty() -> "Live streams matching \"$searchQuery\""
                            selectedCountry != null -> "${selectedCountry.cameraCount} YouTube Live feeds available"
                            else -> "Global Traffic Webcams • WebView Player"
                        },
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            // Live Network Pulsing Tag
            Row(
                modifier = Modifier
                    .background(LiveRed.copy(alpha = 0.15f), RoundedCornerShape(20.dp))
                    .border(1.dp, LiveRed.copy(alpha = 0.4f), RoundedCornerShape(20.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(6.dp)
                        .background(LiveRed, CircleShape)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "ONLINE",
                    color = LiveRed,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp
                )
            }
        }
    }
}

@Composable
private fun HomeCountryGridView(
    countries: List<Country>,
    onCountryClick: (Country) -> Unit,
    onCameraClick: (LiveCamera) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
            .fillMaxSize()
            .testTag("home_country_grid")
    ) {
        // Hero Card
        item(span = { GridItemSpan(2) }) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = DarkSurface),
                border = androidx.compose.foundation.BorderStroke(1.dp, DarkSurfaceBorder),
                shape = RoundedCornerShape(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFF0F223D),
                                    Color(0xFF0E1A2C),
                                    Color(0xFF0A0F1A)
                                )
                            )
                        )
                        .padding(18.dp)
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Sensors,
                                contentDescription = null,
                                tint = LiveCyanPrimary,
                                modifier = Modifier.size(16.dp)
                            )
                            Text(
                                text = "GLOBAL LIVE MONITOR",
                                color = LiveCyanPrimary,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 1.sp
                            )
                        }

                        Text(
                            text = "Live World Road & Traffic Cameras",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.ExtraBold,
                            color = TextPrimary
                        )

                        Text(
                            text = "Select any country below to view real-time traffic streams, pedestrian scrambles, and expressway feeds via YouTube Live WebView player.",
                            style = MaterialTheme.typography.bodySmall,
                            color = TextSecondary,
                            lineHeight = 18.sp
                        )

                        // Quick Statistics Row
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 4.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            StatPill(title = "Countries", value = "6")
                            StatPill(title = "Live Feeds", value = "31")
                            StatPill(title = "Playback", value = "WebView")
                        }
                    }
                }
            }
        }

        // Section Title
        item(span = { GridItemSpan(2) }) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Explore Countries",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                Text(
                    text = "Tap country to watch",
                    fontSize = 12.sp,
                    color = TextTertiary
                )
            }
        }

        // Countries 2-column Grid Items
        items(countries) { country ->
            CountryGridCard(
                country = country,
                onClick = { onCountryClick(country) }
            )
        }

        // Spacer at bottom so content is not cut off by bottom search bar
        item(span = { GridItemSpan(2) }) {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun StatPill(title: String, value: String) {
    Row(
        modifier = Modifier
            .background(DarkSurfaceElevated, RoundedCornerShape(8.dp))
            .border(1.dp, DarkSurfaceBorder, RoundedCornerShape(8.dp))
            .padding(horizontal = 10.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Text(
            text = value,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = LiveCyanPrimary
        )
        Text(
            text = title,
            fontSize = 11.sp,
            color = TextSecondary
        )
    }
}

@Composable
private fun CountryCamerasListView(
    country: Country,
    cameras: List<LiveCamera>,
    onCameraClick: (LiveCamera) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("country_cameras_list"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Country Header Card
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = DarkSurface),
                border = androidx.compose.foundation.BorderStroke(1.dp, DarkSurfaceBorder),
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(54.dp)
                            .background(DarkSurfaceElevated, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = country.flag, fontSize = 32.sp)
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "${country.name} Traffic Cameras",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                        Text(
                            text = country.subtitle,
                            style = MaterialTheme.typography.bodySmall,
                            color = TextSecondary
                        )
                        Text(
                            text = "${cameras.size} Live YouTube Streams • Instant Play",
                            style = MaterialTheme.typography.bodySmall,
                            color = LiveCyanPrimary,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }

        // Camera items
        items(cameras) { camera ->
            CameraListItemCard(
                camera = camera,
                onClick = { onCameraClick(camera) }
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun SearchResultsView(
    query: String,
    cameras: List<LiveCamera>,
    onCameraClick: (LiveCamera) -> Unit,
    onClearSearch: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("search_results_list"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Found ${cameras.size} cameras for \"$query\"",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = TextPrimary
                )
                Text(
                    text = "Clear",
                    fontSize = 12.sp,
                    color = LiveCyanPrimary,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(onClick = onClearSearch)
                        .padding(4.dp)
                )
            }
        }

        if (cameras.isEmpty()) {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    colors = CardDefaults.cardColors(containerColor = DarkSurface),
                    border = androidx.compose.foundation.BorderStroke(1.dp, DarkSurfaceBorder),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(28.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .background(DarkSurfaceElevated, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Traffic,
                                contentDescription = null,
                                tint = AmberAccent,
                                modifier = Modifier.size(28.dp)
                            )
                        }

                        Text(
                            text = "No Live Cameras Found",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )

                        Text(
                            text = "We couldn't find any cameras matching \"$query\". Try searching for Tokyo, London, Lahore, Times Square, Berlin, or Toronto.",
                            style = MaterialTheme.typography.bodySmall,
                            color = TextSecondary,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )

                        Button(
                            onClick = onClearSearch,
                            colors = ButtonDefaults.buttonColors(containerColor = LiveCyanPrimary),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                text = "Show All Cameras",
                                color = Color(0xFF00363F),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        } else {
            items(cameras) { camera ->
                CameraListItemCard(
                    camera = camera,
                    onClick = { onCameraClick(camera) }
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
