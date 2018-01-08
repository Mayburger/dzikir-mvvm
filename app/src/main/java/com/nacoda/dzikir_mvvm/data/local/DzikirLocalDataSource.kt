package com.nacoda.moviesmvvm.data.source.local

import android.content.Context
import android.content.SharedPreferences
import android.support.annotation.VisibleForTesting
import com.nacoda.moviesmvvm.data.source.DzikirDataSource

/**
 * Created by irfanirawansukirman on 04/12/17.
 */

class DzikirLocalDataSource private constructor(private val preferences: SharedPreferences) : DzikirDataSource {
    override fun getDzikirList(callback: DzikirDataSource.GetDzikirListCallback, mContext: Context) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {

        private var INSTANCE: DzikirLocalDataSource? = null

        @JvmStatic
        fun getInstance(preferences: SharedPreferences): DzikirLocalDataSource {
            if (INSTANCE == null) {
                synchronized(DzikirLocalDataSource::javaClass) {
                    INSTANCE = DzikirLocalDataSource(preferences)
                }
            }
            return INSTANCE!!
        }

        @VisibleForTesting
        fun clearInstance() {
            INSTANCE = null
        }
    }
}