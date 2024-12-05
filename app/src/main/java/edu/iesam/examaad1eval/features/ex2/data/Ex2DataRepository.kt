package edu.iesam.examaad1eval.features.ex2.data

import android.util.Log
import edu.iesam.examaad1eval.features.ex2.data.local.db.GameDbLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import edu.iesam.examaad1eval.features.ex2.domain.Ex2Repository
import edu.iesam.examaad1eval.features.ex2.domain.Game

class Ex2DataRepository(
    private val local: GameDbLocalDataSource,
    private val remote: MockEx2RemoteDataSource
) : Ex2Repository {

    private val localSizeLimit = 5

    override suspend fun getGames(): List<Game> {
        val localGames = local.getAll()
        val remoteGames = remote.getGames()

        if (localGames.isEmpty()) {
            local.saveAll(remoteGames.take(localSizeLimit))
            return remoteGames
        }

        val syncedList = mutableListOf<Game>()
        syncedList.addAll(localGames)

        for (item in remoteGames) {
            if (!syncedList.any { it.id == item.id }) {
                syncedList.add(item)
            }
        }

        local.saveAll(syncedList.take(localSizeLimit))
        return syncedList
    }

}