package com.breakingbad

import android.content.Context
import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*
import com.breakingbad.Model.Character
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list_characters.view.*

class AdapterListCharacter(private val items : List<Character>, private val context: Context,
                      private val onclick: (character: Character) -> Unit) : RecyclerView.Adapter<AdapterListCharacter.MyViewHolder>() {


    private var mRecyclerView: RecyclerView? = null

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return  MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_characters, parent, false))
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)

        mRecyclerView = recyclerView
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val character: Character = items[position]

        Glide.with(context)
            .load(character.img)
            .into(holder.img)

        holder.status.text = character.status
        holder.name.text = character.name
        holder.nickname.text = character.nickname
        holder.portrayed.text = character.portrayed

        holder.view.setOnClickListener {
            onclick(character)
        }
    }


    class MyViewHolder (val view: View) : RecyclerView.ViewHolder(view) {

        val img: ImageView = view.img
        val status: TextView = view.status
        val name: TextView = view.name
        val nickname: TextView = view.nickname
        val portrayed: TextView = view.portrayed

    }
}