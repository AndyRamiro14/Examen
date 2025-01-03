package com.example.examen

import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventAdapter {
    fun updateData(events: List<Event>) {
        TODO("Not yet implemented")
    }


    class EventAdapter(private var events: List<Event>) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)
            return EventViewHolder(view)
        }

        override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
            val event = events[position]
            holder.titleTextView.text = event.title
            holder.dateTextView.text = "Fecha: ${event.date} | Hora: ${event.time}"
            holder.descriptionTextView.text = event.description
        }

        override fun getItemCount(): Int = events.size

        fun updateData(newEvents: List<Event>) {
            events = newEvents
            notifyDataSetChanged()
        }

        class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val titleTextView: TextView = view.findViewById(R.id.eventTitleTextView)
            val dateTextView: TextView = view.findViewById(R.id.eventDateTextView)
            val descriptionTextView: TextView = view.findViewById(R.id.eventDescriptionTextView)
        }
    }

}