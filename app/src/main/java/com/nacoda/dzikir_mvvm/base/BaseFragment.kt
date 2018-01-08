package com.nacoda.dzikir_mvvm.base

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.ViewGroup
import android.view.Window

/**
 * Created by irfanirawansukirman on 04/12/17.
 */

open class BaseFragment : Fragment() {

    private var mDialogProgress: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    /**
     * Show this dialog when the app request to API.
     * Hide it when the opposite
     * @param mMessage
     */
    fun showProgressDialog(isShowDialog: Boolean) {

        if (isShowDialog) {
            mDialogProgress?.show()
        } else {
            mDialogProgress?.dismiss()
        }
    }
}