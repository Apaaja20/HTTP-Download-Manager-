package com.apaaja20.httpdownloadmanager.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DownloadDao {
    // Menyimpan atau mengganti data jika ID sudah ada
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(download: DownloadEntity)

    // Mengupdate data (misalnya update progres)
    @Update
    suspend fun update(download: DownloadEntity)

    // Mengambil semua daftar unduhan sebagai stream reaktif
    @Query("SELECT * FROM downloads ORDER BY id DESC")
    fun getAllDownloads(): Flow<List<DownloadEntity>>

    // Mengambil satu unduhan spesifik berdasarkan ID
    @Query("SELECT * FROM downloads WHERE id = :id")
    fun getDownloadById(id: String): Flow<DownloadEntity?>

    // Menghapus data unduhan
    @Delete
    suspend fun delete(download: DownloadEntity)
}
