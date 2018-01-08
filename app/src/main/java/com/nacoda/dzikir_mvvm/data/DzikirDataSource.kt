package com.nacoda.moviesmvvm.data.source

import android.content.Context
import com.nacoda.dzikir_mvvm.model.DzikirList

/**
 * Created by irfanirawansukirman on 04/12/17.
 */
interface DzikirDataSource {

    fun getDzikirList(callback: GetDzikirListCallback, mContext:Context)

    interface GetDzikirListCallback {
        fun onDzikirListLoaded(response: String?)
        fun onError(errorMessage: String?)
    }

}