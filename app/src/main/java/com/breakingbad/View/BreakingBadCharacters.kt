package com.breakingbad.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.breakingbad.AdapterListCharacter
import com.breakingbad.Controller.CharacterVM
import com.breakingbad.Model.Character
import com.breakingbad.R
import com.breakingbad.network.BASE_URL
import com.breakingbad.network.BreakingBadAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class BreakingBadCharacters : AppCompatActivity() {

    private lateinit var charactersViewModel: CharacterVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        charactersViewModel = CharacterVM()

        var recyclerCharacters: RecyclerView = findViewById(R.id.recycler_characters)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerCharacters.layoutManager = layoutManager
        recyclerCharacters.isNestedScrollingEnabled = false


        charactersViewModel.characters.observe(this,
            Observer {
                characters ->
                    run {
                        var adapterListCharacter = AdapterListCharacter(characters, this,
                            onclick = { todo ->

                            }
                        )

                        recyclerCharacters.adapter = adapterListCharacter
                    }
            }
        )

    }
}
