package com.apaaja20.httpdownloadmanager.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "downloads")
data class DownloadEntity(
    @PrimaryKey val id: String, // ID unik unduhan
    val url: String,            // URL file
    val fileName: String,       // Nama file hasil unduh
    val progress: Int = 0,      // Progress (0-100)
    val status: String = "PENDING" // Status: PENDING, DOWNLOADING, COMPLETED, FAILED
)
