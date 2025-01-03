import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.examen.Event
import com.example.examen.EventDao

@Database(entities = [Event.Event::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao
}
