package com.breakingbad.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.breakingbad.AdapterListCharacter
import com.breakingbad.Controller.ListCharacterVM
import com.breakingbad.R
import kotlinx.android.synthetic.main.activity_list_breaking_bad_characters.*

class ActivityListCharacters : AppCompatActivity() {

    private lateinit var charactersViewModel: ListCharacterVM
    private lateinit var recyclerCharacters: RecyclerView


    private fun setupRecycler() {
        recyclerCharacters = findViewById(R.id.recycler_characters)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerCharacters.layoutManager = layoutManager
    }

    private fun observeViewModel() {
        charactersViewModel.characters.observe(this,
            Observer {
                    characters ->
                run {
                    if (characters == null) {
                        retry_btn.visibility = View.VISIBLE

                        Toast.makeText(this@ActivityListCharacters,
                            "An error occurred, please verify your internet connection",
                            Toast.LENGTH_LONG).show()
                    } else {
                        var adapterListCharacter = AdapterListCharacter(characters, this,
                            onclick = { character ->
                                val intent = Intent(this@ActivityListCharacters, ActivityDetailCharacter::class.java)
                                intent.putExtra("character", character)
                                startActivity(intent)
                            }
                        )

                        recyclerCharacters.adapter = adapterListCharacter
                        retry_btn.visibility = View.GONE
                    }
                }
            }
        )
    }
    
    private fun initViews() {
        retry_btn.setOnClickListener {
            charactersViewModel.refreshData()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_breaking_bad_characters)

        charactersViewModel = ListCharacterVM()

        initViews()
        setupRecycler()
        observeViewModel()

    }
}
