package com.github.outerheavenproject.wanstagram.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.fragment.app.commit
import com.github.outerheavenproject.wanstagram.App
import com.github.outerheavenproject.wanstagram.MainActivitySubcomponent
import com.github.outerheavenproject.wanstagram.R
import com.github.outerheavenproject.wanstagram.ui.dog.DogFragment
import com.github.outerheavenproject.wanstagram.ui.shiba.ShibaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), MainContract.View {
    val presenter: MainPresenter by lazy {
        MainPresenter(this)
    }
    val createNavigator by lazy {
        App.Instance.appComponent.createNavigator
    }

    val subComponent: MainActivitySubcomponent by lazy {
        App.Instance.appComponent.createMainActivitySubcomponent(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(R.id.container, DogFragment())
            }
        }

        val bottom: BottomNavigationView = findViewById(R.id.bottom)
        bottom.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_dog -> {
                    supportFragmentManager.commit {
                        replace(R.id.container, DogFragment())
                    }
                }
                R.id.action_shiba -> {
                    supportFragmentManager.commit {
                        replace(R.id.container, ShibaFragment())
                    }
                }
            }
            true
        }

        findViewById<View>(R.id.fab)
            .setOnClickListener { presenter.share() }

        presenter.start()
    }

    override fun shareDogs(dogs: Set<String>) {
        createNavigator(this).shareUris(this, ArrayList(dogs.map { it.toUri() }))
    }

}
