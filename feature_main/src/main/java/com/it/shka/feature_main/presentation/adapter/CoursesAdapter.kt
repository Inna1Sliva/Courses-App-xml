package com.it.shka.feature_main.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.it.shka.feature_main.R
import com.it.shka.feature_main.domain.model.Courses

class CoursesAdapter(private val courses: List<Courses>, private val context: Context) :
    RecyclerView.Adapter<CoursesAdapter.CourseViewHolder>() {

    class CourseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textTitle: TextView = view.findViewById(R.id.title)
        val textText: TextView = view.findViewById(R.id.text)
        val textPrice: TextView = view.findViewById(R.id.price)
        val textRate: TextView = view.findViewById(R.id.rate)
        val textStartData: TextView = view.findViewById(R.id.startData)
        val layoutStartData: LinearLayout = view.findViewById(R.id.layout_startData)
        val image: ImageView = view.findViewById(R.id.imageView)
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
        holder.textPrice.text = "${list.price} ₽"
        holder.textRate.text = list.rate
        when {
            list.startDate.isEmpty() -> {
                holder.layoutStartData.visibility = View.GONE
            }

            else -> {
                holder.textStartData.text = list.startDate
            }
        }
        Glide.with(context)
            .load(list.image)

            .into(holder.image)

    }

    override fun getItemCount(): Int = courses.size


}


