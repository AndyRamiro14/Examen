package com.example.examen
import androidx.room.Entity
import androidx.room.PrimaryKey

class Event {
    val description: CharSequence?
        get() {
        }
    val time: String
        get() {
        }
    val date: String
        get() {

        }
    val title: CharSequence?
        get() {
        }

    @Entity(tableName = "events_table")
    data class Event(
        @PrimaryKey(autoGenerate = true) val id: Long = 0,
        val title: String,
        val description: String,
        val date: Long, // Representa la fecha en milisegundos
        val time: Long // Representa la hora en milisegundos
    }

}