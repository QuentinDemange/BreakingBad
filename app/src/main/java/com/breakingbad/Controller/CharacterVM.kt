package com.breakingbad.Controller

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.breakingbad.Model.Character
import com.breakingbad.network.BASE_URL
import com.breakingbad.network.BreakingBadAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class CharacterVM {

    private val _characters: MutableLiveData<List<Character>> by lazy {
        MutableLiveData<List<Character>>()
    }

    val characters: LiveData<List<Character>>
        get() = _characters


    private var serviceApi: BreakingBadAPI

    init {
        _characters.value = ArrayList<Character>()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        serviceApi = retrofit.create(BreakingBadAPI::class.java)
        refresh()
    }

    private fun refresh() {
        val characterRequest = serviceApi.getCharacters()

        characterRequest.enqueue(object : Callback<List<Character>> {
            override fun onResponse(call: Call<List<Character>>, response: Response<List<Character>>) {
                _characters.value = response.body()
            }
            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                error("KO")
            }
        })
    }

    public fun refreshData() {
        refresh()
    }
}