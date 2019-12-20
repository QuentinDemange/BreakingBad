package com.breakingbad.View

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.breakingbad.Model.Character
import com.breakingbad.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_characters.*
import kotlinx.android.synthetic.main.item_list_characters.view.*

class ActivityDetailCharacter: AppCompatActivity() {
    private lateinit var character: Character

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_characters)

        val extras = intent.extras

        if (extras != null) {
            character = intent.getSerializableExtra("character") as Character
        }

        Glide.with(this)
            .load(character.img)
            .into(img)

        name.text = character.name
        status.text = character.status
        nickname.text = character.nickname

        occupation.text = character.occupation.joinToString().replace(",", "\n")
        appearance.text = character.appearance.joinToString().replace(",", " -")
    }

}