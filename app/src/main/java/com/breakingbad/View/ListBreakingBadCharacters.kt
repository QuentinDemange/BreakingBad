package com.breakingbad.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.breakingbad.AdapterListCharacter
import com.breakingbad.Controller.ListCharacterVM
import com.breakingbad.R

class ListBreakingBadCharacters : AppCompatActivity() {

    private lateinit var charactersViewModel: ListCharacterVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_breaking_bad_characters)

        charactersViewModel = ListCharacterVM()

        val recyclerCharacters: RecyclerView = findViewById(R.id.recycler_characters)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerCharacters.layoutManager = layoutManager


        charactersViewModel.characters.observe(this,
            Observer {
                characters ->
                    run {
                        var adapterListCharacter = AdapterListCharacter(characters, this,
                            onclick = { character ->
                                Toast.makeText(this, "Test", Toast.LENGTH_LONG).show()
                                val intent = Intent(this@ListBreakingBadCharacters, ActivityDetailCharacter::class.java)
                                intent.putExtra("character", character)
                                startActivity(intent)
                            }
                        )

                        recyclerCharacters.adapter = adapterListCharacter
                    }
            }
        )

    }
}
