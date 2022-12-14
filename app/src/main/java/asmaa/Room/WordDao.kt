package asmaa.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    @Query (" SELECT * FROM word_table ORDER BY word ASC ")
    // To observe data changes you will use Flow
    fun getAlphabetizedWords(): Flow<List<Word>>


    @Insert ( onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert ( word: Word )

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()

}