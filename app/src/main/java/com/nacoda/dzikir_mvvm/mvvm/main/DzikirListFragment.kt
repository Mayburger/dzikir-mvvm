package com.nacoda.moviesmvvm.mvvm.main.movies.popular

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.nacoda.dzikir_mvvm.base.BaseFragment
import com.nacoda.dzikir_mvvm.databinding.DzikirListFragmentBinding
import com.nacoda.dzikir_mvvm.mvvm.main.DzikirListAdapter
import com.nacoda.moviesmvvm.util.obtainViewModel
import kotlinx.android.synthetic.main.dzikir_list_fragment.*

class DzikirListFragment : BaseFragment() {

    private lateinit var mViewDataBinding: DzikirListFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mViewDataBinding = DzikirListFragmentBinding.inflate(inflater, container, false).apply {
            mViewModel = obtainViewModel()
        }

        return mViewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewDataBinding.mViewModel?.start()

        val mViewModel = mViewDataBinding.mViewModel

        if (mViewModel != null) {

            with(recycler_view) {
                adapter = DzikirListAdapter(mViewModel.dzikirList.get(0).results,mViewModel, activity)
                layoutManager = LinearLayoutManager(activity)
            }
        }
    }

    private fun obtainViewModel(): DzikirListViewModel = obtainViewModel(DzikirListViewModel::class.java)

    companion object {

        fun newInstance() = DzikirListFragment().apply {

        }
    }
}