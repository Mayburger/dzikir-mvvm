package com.nacoda.moviesmvvm.mvvm.main.movies.popular

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.widget.Toast
import com.google.gson.GsonBuilder
import com.nacoda.dzikir_mvvm.model.DzikirList
import com.nacoda.moviesmvvm.data.source.DzikirDataSource
import com.nacoda.moviesmvvm.data.source.DzikirRepository

/**
 * Created by irfanirawansukirman on 04/12/17.
 */

class DzikirListViewModel(context: Application, private val mDzikirRepository: DzikirRepository) : AndroidViewModel(context) {

    @SuppressLint("StaticFieldLeak")
    var mContext = context

    val dzikirList: ObservableList<DzikirList> = ObservableArrayList()

    fun start() {
        getPopular()
    }

    fun getPopular() {
        mDzikirRepository.getDzikirList(object : DzikirDataSource.GetDzikirListCallback {
            override fun onDzikirListLoaded(response: String?) {
                val gsonBuilder = GsonBuilder()
                val gson = gsonBuilder.create()
                val dzikir = gson.fromJson(response, DzikirList::class.java)

                with(dzikirList){
                    add(dzikir)
                }
            }

            override fun onError(errorMessage: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }, mContext)
    }
}


