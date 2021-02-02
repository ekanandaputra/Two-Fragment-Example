package com.shariawaysprovider.dynamicui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    private var fragmentDetail: DetailFragment? = null
    private var params: Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        params = intent.getBundleExtra("args")

        if (savedInstanceState == null) {
            fragmentDetail = DetailFragment()
            if (params != null) {
                fragmentDetail!!.setArguments(params)
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_detail_container, fragmentDetail!!)
                .commit();
        }
    }
}