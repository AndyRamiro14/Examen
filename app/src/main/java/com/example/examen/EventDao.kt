package com.example.examen

import androidx.room.*

@Dao
interface EventDao {

    @Insert
    suspend fun insert(event: Event)

    @Update
    suspend fun update(event: Event)

    @Delete
    suspend fun delete(event: Event)

    @Query("SELECT * FROM events_table ORDER BY date DESC")
    suspend fun getAllEvents(): List<Event>
}