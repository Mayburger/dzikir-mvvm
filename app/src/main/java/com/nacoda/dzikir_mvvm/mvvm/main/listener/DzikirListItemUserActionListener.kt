package com.nacoda.dzikir_mvvm.mvvm.main.listener

import com.nacoda.dzikir_mvvm.model.DzikirList

/**
 * Created by irfanirawansukirman on 04/12/17.
 */
interface DzikirListItemUserActionListener {

    fun onDzikirListClicked(data: DzikirList.Dzikir)

}