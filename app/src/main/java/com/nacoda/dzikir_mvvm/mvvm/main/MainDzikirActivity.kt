package com.nacoda.dzikir_mvvm.mvvm.main

import android.os.Bundle
import android.widget.Toolbar

import com.nacoda.dzikir_mvvm.R
import com.nacoda.dzikir_mvvm.base.BaseActivity
import com.nacoda.moviesmvvm.mvvm.main.movies.popular.DzikirListFragment
import com.nacoda.moviesmvvm.util.replaceFragmentInActivity

class MainDzikirActivity : BaseActivity() {

    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_dzikir_activity)
        setupFragment()
    }

    private fun setupFragment() {
        supportFragmentManager.findFragmentById(R.id.dzikir_main_frame)
        DzikirListFragment.newInstance().let {
            replaceFragmentInActivity(it, R.id.dzikir_main_frame)
        }
    }
}
