package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import edu.iesam.examaad1eval.features.ex2.domain.Player

const val GAME_TABLE = "game"

@Entity(tableName = GAME_TABLE)
data class GameEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "players") val players: List<Player>
)