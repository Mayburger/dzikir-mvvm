package com.nacoda.dzikir_mvvm.model

/**
 * Created by Mayburger on 12/28/17.
 */


class DzikirList {

    var results: List<Dzikir>? = null

    data class Dzikir(
            var dzikirId: String? = null,
            var dzikirName:String? = null,
            var dzikirCount:String? = null
    )
}