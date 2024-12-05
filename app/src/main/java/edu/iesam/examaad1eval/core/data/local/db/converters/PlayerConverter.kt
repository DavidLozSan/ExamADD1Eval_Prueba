package edu.iesam.examaad1eval.core.data.local.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.iesam.examaad1eval.features.ex2.domain.Player

class PlayerConverter {

    @TypeConverter
    fun from(player: String): List<Player> {
        val type = object : TypeToken<List<Player>>() {}.type
        return Gson().fromJson(player, type)
    }

    @TypeConverter
    fun to(player: List<Player>): String {
        val type = object : TypeToken<List<Player>>() {}.type
        return Gson().toJson(player, type)
    }
}