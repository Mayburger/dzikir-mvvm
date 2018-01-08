package com.nacoda.dzikir_mvvm.mvvm.main

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.annotation.IntegerRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.jaouan.revealator.Revealator
import com.nacoda.dzikir_mvvm.R
import com.nacoda.dzikir_mvvm.databinding.DzikirListItemBinding
import com.nacoda.dzikir_mvvm.model.DzikirList
import com.nacoda.dzikir_mvvm.mvvm.main.listener.DzikirListItemUserActionListener
import com.nacoda.moviesmvvm.mvvm.main.movies.popular.DzikirListViewModel
import kotlinx.android.synthetic.main.dzikir_list_item.*
import kotlinx.android.synthetic.main.dzikir_list_item.view.*

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

        val mUserActionListener = object : DzikirListItemUserActionListener {
            override fun onDzikirListClicked(data: DzikirList.Dzikir) {
                Toast.makeText(mContext, data.dzikirName, Toast.LENGTH_LONG).show()
            }
        }

        (holder as MainItemHolder).bindItem(dataItem, mContext, mUserActionListener,position)
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

        fun bindItem(data: DzikirList.Dzikir, mContext: Context, userActionListener: DzikirListItemUserActionListener, position: Int) {

            Revealator.reveal(itemView.item_parent)
                    .from(itemView.item_parent)
                    .withCurvedTranslation()
                    .withChildsAnimation()
                    .withRevealDuration(((position + 3).toString() + "00").toInt())
                    .start()

            mMainItemBinding.item = data
            mMainItemBinding.icon = mContext.resources.getDrawable(mContext.resources.getIdentifier(data.dzikirId, "drawable", mContext.packageName))
            mMainItemBinding.userActionListener = userActionListener
            mMainItemBinding.executePendingBindings()

        }
    }


}