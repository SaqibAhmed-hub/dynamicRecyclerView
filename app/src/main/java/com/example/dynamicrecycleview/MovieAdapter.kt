package com.example.dynamicrecycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cardview.view.*


class MovieAdapter(val context: Context, var movie: ArrayList<Movies>) : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    fun setData(movie: Movies?){
        itemView.txvName.text = movie!!.title
        itemView.txvgenre.text = movie.genre
        itemView.txvyear.text = movie.movieYear.toString()
                    }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cardview,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movie.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movies = movie[position]
        holder.setData(movies)

    }

}
