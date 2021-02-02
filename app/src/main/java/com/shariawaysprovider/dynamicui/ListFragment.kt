package com.shariawaysprovider.dynamicui

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment


class ListFragment : Fragment() {

    private val PORTRAIT_LAYOUT_MODE = 1
    private val LANDSCAPE_LAYOUT_MODE = 2

    private var mItemListener: OnSelected? = null

    private var layoutMode = PORTRAIT_LAYOUT_MODE
    private var mPosition = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val arguments = arguments
        if (arguments != null) {
            layoutMode = arguments.getInt("LayoutMode")
        }

        if (savedInstanceState != null) {
            mPosition = savedInstanceState.getInt("position")
        }

        val rootView =  inflater.inflate(R.layout.fragment_list, container, false)

        val mylistview = rootView.findViewById<ListView>(R.id.listView)
        val alumnos = resources.getStringArray(R.array.alumnos)

        val adapter = ArrayAdapter(
            activity!!.baseContext,
            android.R.layout.simple_list_item_1, android.R.id.text1, alumnos
        )
        mylistview.setAdapter(adapter);
        if(mPosition >= 0)
            mylistview.setSelection(mPosition);

        mylistview.onItemClickListener =
            OnItemClickListener { parent, view, position, id -> // Calling What To Do in the MainActivity.
                mItemListener!!.onClick(position)
            }
        return rootView
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("position", mPosition)
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        try {
            mItemListener = activity as OnSelected
        } catch (castException: ClassCastException) {
            /**
             * If this error rises, means that the Activity that is using
             * this fragment doesn't have a OnItemSelectedFromTheList
             * implementation.
             */
        }
    }


}