package com.example.dynamicrecycleview

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnsubmit:Button = findViewById(R.id.btnsubmit)
        val recycleview : RecyclerView = findViewById(R.id.recyclerview)
        val moviearray = arrayListOf<Movies>()

        btnsubmit.setOnClickListener {
            val movie: String  = edMovieName.text.toString()
            val genre : String = edGenre.text.toString()
            val movieyear : String = edYear.text.toString()

            val moviename = Movies(movie,genre,movieyear.toInt())
            moviearray.add(moviename)
            val adapter = MovieAdapter(this,moviearray)
            recycleview.adapter = adapter

        }


        // set up the Layout Manager
        val linearlayout = LinearLayoutManager(this)
        linearlayout.orientation = LinearLayoutManager.VERTICAL
        recycleview.layoutManager = linearlayout

        // Animation
        val value: RecyclerView.ItemAnimator  = DefaultItemAnimator()
        value.addDuration = 2000
        value.removeDuration =1000
        recycleview.itemAnimator = value


    }
}