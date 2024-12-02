package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import edu.iesam.examaad1eval.features.ex2.domain.Player

const val GAME_TABLE = "game"
const val GAME_ID = "game_id"

@Entity(tableName = GAME_TABLE)
data class GameEntity(
    @PrimaryKey @ColumnInfo(name = GAME_ID) val id: String,
    @ColumnInfo(name = "title") val title: String,
    @Embedded(prefix = "players") val players: List<Player>
)