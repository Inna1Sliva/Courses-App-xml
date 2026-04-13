package com.it.shka.feature_main.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.it.shka.feature_main.R
import com.it.shka.feature_main.domain.model.Courses

class CoursesAdapter(private val courses: List<Courses>) :
    RecyclerView.Adapter<CoursesAdapter.CourseViewHolder>() {

    class CourseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textTitle: TextView = view.findViewById(R.id.title)
        val textText: TextView = view.findViewById(R.id.text)
        val textPrice: TextView = view.findViewById(R.id.price)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CourseViewHolder,
        position: Int
    ) {
        val list = courses[position]
        holder.textTitle.text = list.title
        holder.textText.text = list.text
        holder.textPrice.text = list.price
    }

    override fun getItemCount(): Int = courses.size


}


