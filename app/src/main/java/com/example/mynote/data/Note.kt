package com.example.mynote.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tblNotes")
data class Note(
    var title: String?,
    var description: String?,
    var priority: Int? = 1
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}

