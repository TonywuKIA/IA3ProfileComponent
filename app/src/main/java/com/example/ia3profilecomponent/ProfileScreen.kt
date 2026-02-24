@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.ia3profilecomponent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.compose.ui.draw.shadow

@Composable
fun ProfileHeaderOverlayScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile") },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit")
                    }
                }
            )
        }
    ) { inner ->
        Surface(modifier = Modifier.fillMaxSize().padding(inner)) {

            // Outer Box: allows overlay card to overlap header area cleanly
            Box(modifier = Modifier.fillMaxSize()) {

                // Column to reserve vertical space for header + body
                Column(modifier = Modifier.fillMaxWidth()) {

                    // HEADER (Box layering)
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(16f / 7f) // requirement: aspectRatio
                            .background(
                                brush = Brush.verticalGradient(
                                    listOf(
                                        MaterialTheme.colorScheme.primary,
                                        MaterialTheme.colorScheme.primaryContainer
                                    )
                                )
                            ),
                        contentAlignment = Alignment.BottomCenter // requirement: contentAlignment
                    ) {
                        // Avatar foreground
                        Box(
                            modifier = Modifier
                                .size(96.dp) // requirement: fixed size
                                .clip(CircleShape) // requirement: clip(CircleShape)
                                .background(MaterialTheme.colorScheme.surface)
                                .shadow(6.dp, CircleShape) // extra polish (shadow)
                                .align(Alignment.BottomCenter)
                                .offset(y = 28.dp), // push avatar slightly down (intentional)
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = null
                            )
                        }
                    }

                    // Spacer to make room because avatar is offset downward
                    Spacer(Modifier.height(36.dp))

                    // Body content placeholder (below the overlay card)
                    Spacer(Modifier.height(160.dp))
                }

                // OVERLAY CARD (partially overlaps header)
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .align(Alignment.TopCenter)
                        .offset(y = 140.dp) // overlap position: card sits partly on header
                        .zIndex(2f), // requirement: zIndex (ensure on top)
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp) // requirement: elevation
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    "Tony Wu",
                                    style = MaterialTheme.typography.titleLarge,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    "SE @ BU·Music& sound computing ",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            Button(onClick = {}) { // Material 3: Button
                                Text("Follow")
                            }
                        }

                        Spacer(Modifier.height(12.dp))

                        // quick info row (icons)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                Icons.Default.LocationOn,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(Modifier.width(6.dp))
                            Text(
                                "Boston, MA",
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(Modifier.width(16.dp))
                            Icon(
                                Icons.Default.Email,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(Modifier.width(6.dp))
                            Text(
                                "tony@balabala.com",
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        Spacer(Modifier.height(14.dp))

                        // Material 3: AssistChip
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            AssistChip(
                                onClick = {},
                                label = { Text("Compose") }
                            )
                            AssistChip(
                                onClick = {},
                                label = { Text("Kotlin") }
                            )
                            AssistChip(
                                onClick = {},
                                label = { Text("ML") }
                            )
                        }

                        Spacer(Modifier.height(14.dp))

                        // Material 3: FilledTonalButton
                        FilledTonalButton(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Message")
                        }
                    }
                }
            }
        }
    }
}
