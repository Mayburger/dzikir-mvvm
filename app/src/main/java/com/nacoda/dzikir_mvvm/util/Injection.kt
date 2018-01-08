package com.nacoda.moviesmvvm.util

import android.content.Context
import android.preference.PreferenceManager
import com.nacoda.dzikir_mvvm.data.remote.DzikirRemoteDataSource
import com.nacoda.moviesmvvm.data.source.DzikirRepository
import com.nacoda.moviesmvvm.data.source.local.DzikirLocalDataSource

/**
 * Created by irfanirawansukirman on 04/12/17.
 */
object Injection {

    fun provideRepository(mContext: Context) =
            DzikirRepository.getInstance(DzikirRemoteDataSource(),
                    DzikirLocalDataSource.getInstance(PreferenceManager.getDefaultSharedPreferences(mContext)))
}