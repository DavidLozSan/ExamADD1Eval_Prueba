package edu.iesam.examaad1eval.features.ex2.data.local.db

import edu.iesam.examaad1eval.features.ex2.domain.Game

class GameDbLocalDataSource(private val gameDao: GameDao) {

    suspend fun saveAll(games: List<Game>) {
        val gamesList = games.map { it.toEntity() }
        gameDao.saveAll(*gamesList.toTypedArray())
    }

    fun getAll() : List<Game>{
        return gameDao.getAll().map { it.toDomain() }
    }
}