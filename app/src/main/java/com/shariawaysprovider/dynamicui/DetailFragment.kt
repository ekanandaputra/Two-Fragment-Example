package com.shariawaysprovider.dynamicui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment


class DetailFragment : Fragment() {

    private var indice = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val arguments = arguments
        if (arguments != null) {
            indice = arguments.getInt("Indice")
        }

        val rootView = inflater.inflate(R.layout.fragment_detail, container, false)

        val clientes = resources.getStringArray(R.array.alumnos)
        val name = rootView.findViewById<TextView>(R.id.textView)
        val image = rootView.findViewById<ImageView>(R.id.imageView)

        if (indice < 0 ) {
            name.setText(resources.getString(R.string.sin_alumnos_warning))
        }
        else {
            name.setText(clientes[indice])
        }

        return rootView
    }

}