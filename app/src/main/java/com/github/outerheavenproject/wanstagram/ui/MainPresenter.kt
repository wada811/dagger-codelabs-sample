package com.github.outerheavenproject.wanstagram.ui

import com.github.outerheavenproject.wanstagram.ui.dogaction.DogActionSink

class MainPresenter(
    private val view: MainContract.View
) : MainContract.Presenter, DogActionSink {
    private val shareList = mutableSetOf<String>()

    override fun start() {
    }

    override fun write(url: String) {
        shareList.add(url)
    }

    override fun share() {
        view.shareDogs(shareList)
    }
}