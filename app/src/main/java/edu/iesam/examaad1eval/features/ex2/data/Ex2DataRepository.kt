package edu.iesam.examaad1eval.features.ex2.data

import edu.iesam.examaad1eval.features.ex2.data.local.db.GameDbLocalDataSource
import edu.iesam.examaad1eval.features.ex2.domain.Ex2Repository
import edu.iesam.examaad1eval.features.ex2.domain.Game

class Ex2DataRepository(
    private val local: GameDbLocalDataSource,
    private val repository: Ex2DataRepository
) : Ex2Repository {

    override fun getGames(): List<Game> {
        TODO("Not yet implemented")
    }

}