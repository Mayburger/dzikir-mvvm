package com.nacoda.dzikir_mvvm.mvvm.main

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.nacoda.dzikir_mvvm.R
import com.nacoda.dzikir_mvvm.databinding.DzikirListItemBinding
import com.nacoda.dzikir_mvvm.model.DzikirList
import com.nacoda.moviesmvvm.mvvm.main.movies.popular.DzikirListViewModel

/**
 * Created by irfanirawansukirman on 04/12/17.
 */

class DzikirListAdapter(private var data: List<DzikirList.Dzikir>?, private var mDzikirListViewModel: DzikirListViewModel, var mContext: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val mMainItemBinding: DzikirListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context),
                R.layout.dzikir_list_item, parent, false)

        return MainItemHolder(mMainItemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val dataItem = data!![position]
        (holder as MainItemHolder).bindItem(dataItem)
    }

    override fun getItemCount(): Int {
        return data!!.size
    }

    fun replaceData(mMovies: List<DzikirList.Dzikir>) {
        setList(mMovies)
    }

    fun setList(data: List<DzikirList.Dzikir>) {
        this.data = data
        notifyDataSetChanged()
    }

    class MainItemHolder(itemView: DzikirListItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val mMainItemBinding: DzikirListItemBinding = itemView

        fun bindItem(data: DzikirList.Dzikir) {

            mMainItemBinding.item = data
            mMainItemBinding.executePendingBindings()

        }
    }


}