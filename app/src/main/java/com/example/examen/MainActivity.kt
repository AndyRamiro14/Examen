import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.examen.EventAdapter
import com.example.examen.R
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var eventsRecyclerView: RecyclerView
    private lateinit var eventAdapter: EventAdapter
    private lateinit var addEventButton: Button
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "events-database"
        ).build()

        eventsRecyclerView = findViewById(R.id.eventsTextView)
        addEventButton = findViewById(R.id.addEventButton)

        eventsRecyclerView.layoutManager = LinearLayoutManager(this)
        EventAdapter.EventAdapter(events = listOf()).also { val also =
            it.also { eventAdapter = it }
        } // Un adaptador para el RecyclerView
        val also = this.eventAdapter.also { it.also { it.also {  eventsRecyclerView.adapter = it } } }

        addEventButton.setOnClickListener {
            // Redirigir a la pantalla de agregar evento
            val intent = Intent(this, AddEventActivity::class.java)
            startActivity(intent)
        }

        loadEvents()
    }

    private fun loadEvents() {
        lifecycleScope.launch {
            val events = db.eventDao().getAllEvents()
            runOnUiThread {
                eventAdapter.updateData(events)
            }
        }
    }
}
