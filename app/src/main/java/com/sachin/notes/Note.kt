package com.sachin.notes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
class Note(
    @PrimaryKey(autoGenerate = true) val id: String,
    @ColumnInfo(name = "text") val text: String
)