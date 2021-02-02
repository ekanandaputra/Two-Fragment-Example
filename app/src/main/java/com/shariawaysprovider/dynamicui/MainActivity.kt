package com.shariawaysprovider.dynamicui

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), OnSelected {

    private val PORTRAIT_LAYOUT_MODE = 1
    private val LANDSCAPE_LAYOUT_MODE = 2

    private var layoutMode = PORTRAIT_LAYOUT_MODE

    var fragmentDetail: DetailFragment? = null
    var fragmentList: ListFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (findViewById<FrameLayout>(R.id.fragment_detail) != null) {
            layoutMode = LANDSCAPE_LAYOUT_MODE;

            if (savedInstanceState == null) {

                fragmentDetail = DetailFragment()

                val transaction =
                    supportFragmentManager.beginTransaction()

                transaction.add(R.id.fragment_detail, fragmentDetail!!, "frag_detail")
                transaction.commit();
            }
        }
    }

    override fun onClick(position: Int) {
        val args = Bundle()
        args.putInt("Indice", position)

        if (layoutMode === LANDSCAPE_LAYOUT_MODE) {
            val fragment = DetailFragment()
            fragment.arguments = args
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_detail, fragment)
                .commit();
        } else {
            val i = Intent(this, DetailActivity::class.java)
            i.putExtra("args", args)
            startActivity(i)
        }
    }


}