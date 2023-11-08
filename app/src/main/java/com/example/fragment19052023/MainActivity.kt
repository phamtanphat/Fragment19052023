package com.example.fragment19052023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    private lateinit var btnAddAndroid: Button
    private lateinit var btnAddIOS: Button
    private lateinit var btnReplaceAndroid: Button
    private lateinit var btnReplaceIOS: Button
    private lateinit var btnRemoveAndroid: Button
    private lateinit var btnRemoveIOS: Button
    private lateinit var btnPopBackStack: Button
    private lateinit var btnDetach: Button
    private lateinit var btnAttach: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAddAndroid = findViewById(R.id.buttonAddAndroid)
        btnAddIOS = findViewById(R.id.buttonAddios)
        btnReplaceAndroid = findViewById(R.id.buttonReplaceAndroid)
        btnReplaceIOS = findViewById(R.id.buttonReplaceios)
        btnRemoveAndroid = findViewById(R.id.buttonRemoveAndroid)
        btnRemoveIOS = findViewById(R.id.buttonRemoveios)
        btnPopBackStack = findViewById(R.id.buttonPopBackStack)
        btnDetach = findViewById(R.id.buttonDetach)
        btnAttach = findViewById(R.id.buttonAttach)

        btnAddAndroid.setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            val androidFragment = AndroidFragment()
            fragmentTransaction.add(R.id.linearlayoutContainer, androidFragment, "tag-android")
            fragmentTransaction.addToBackStack("tag-android")
            fragmentTransaction.commit()
        }

        btnAddIOS.setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            val iOS = IOSFragment()
            fragmentTransaction.add(R.id.linearlayoutContainer, iOS, "tag-ios")
            fragmentTransaction.addToBackStack("tag-ios")
            fragmentTransaction.commit()
        }

        btnReplaceAndroid.setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            val androidFragment = AndroidFragment()
            fragmentTransaction.replace(R.id.linearlayoutContainer, androidFragment, "tag-android")
            fragmentTransaction.addToBackStack("tag-android")
            fragmentTransaction.commit()
        }

        btnReplaceIOS.setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            val iOS = IOSFragment()
            fragmentTransaction.replace(R.id.linearlayoutContainer, iOS, "tag-ios")
            fragmentTransaction.addToBackStack("tag-ios")
            fragmentTransaction.commit()
        }

        btnRemoveAndroid.setOnClickListener {
            val androidFragment = supportFragmentManager.findFragmentByTag("tag-android")
            if (androidFragment != null) {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.remove(androidFragment)
                fragmentTransaction.commit()
            }
        }

        btnRemoveIOS.setOnClickListener {
            val iOSFragment = supportFragmentManager.findFragmentByTag("tag-ios")
            if (iOSFragment != null) {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.remove(iOSFragment)
                fragmentTransaction.commit()
            }
        }

        btnPopBackStack.setOnClickListener {
            supportFragmentManager.popBackStack(2, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        popToBackStack()
    }

    private fun popToBackStack() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            finishAffinity()
        }
    }
}