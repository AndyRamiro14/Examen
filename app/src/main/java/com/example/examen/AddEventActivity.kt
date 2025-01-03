import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.examen.Event
import com.example.examen.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddEventActivity : AppCompatActivity() {

    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "events-database"
        ).build()

        titleEditText = findViewById(R.id.titleEditText)
        descriptionEditText = findViewById(R.id.descriptionEditText)
        saveButton = findViewById(R.id.saveButton)

        saveButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val description = descriptionEditText.text.toString()
            val currentTime = System.currentTimeMillis() // Aquí puedes obtener una fecha real

            val event = Event.Event(
                title = title,
                description = description,
                date = currentTime,
                time = currentTime
            )

            GlobalScope.launch {
                db.eventDao().insert(event)
                finish()
            }
        }
    }
}
