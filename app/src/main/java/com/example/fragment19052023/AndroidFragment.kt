package com.example.fragment19052023

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class AndroidFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("BBB", "onCreateView")
        return inflater.inflate(R.layout.fragment_android, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("BBB", "onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("BBB", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("BBB", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("BBB", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("BBB", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("BBB", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("BBB", "onDestroy")
    }
}