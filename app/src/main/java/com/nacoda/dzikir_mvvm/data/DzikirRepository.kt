package com.nacoda.moviesmvvm.data.source

import android.content.Context
import com.nacoda.dzikir_mvvm.model.DzikirList

/**
 * Created by irfanirawansukirman on 04/12/17.
 */
open class DzikirRepository(val remoteDataSource: DzikirDataSource, val localDataSource: DzikirDataSource) : DzikirDataSource {
    override fun getDzikirList(callback: DzikirDataSource.GetDzikirListCallback, mContext: Context) {
        remoteDataSource.getDzikirList(object : DzikirDataSource.GetDzikirListCallback {
            override fun onDzikirListLoaded(response: String?) {
                callback.onDzikirListLoaded(response)
            }
            override fun onError(errorMessage: String?) {
                callback.onError(errorMessage)
            }

        },mContext)
    }

    companion object {

        private var INSTANCE: DzikirRepository? = null

        /**
         * Returns the single instance of this class, creating it if necessary.

         * @param mJasaRaharjaRemoteDataSourcethe backend data source
         * *
         * @return the [DzikirRepository] instance
         */
        @JvmStatic
        fun getInstance(mDzikirRemoteDataSource: DzikirDataSource, mDzikirLocalDataSource: DzikirDataSource) =
                INSTANCE ?: synchronized(DzikirRepository::class.java) {
                    INSTANCE ?: DzikirRepository(mDzikirRemoteDataSource, mDzikirLocalDataSource)
                            .also { INSTANCE = it }
                }

        /**
         * Used to force [getInstance] to create a new instance
         * next time it's called.
         */
        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}