package com.example.calcoloimp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.navigation)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        // Carichiamo il primo fragment
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, CalcoloImpasto()).commit()
    }

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.CalcoloImpasto -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container,
                        CalcoloImpasto()
                    ).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.ListaImpasti -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container,
                        ListaImpasti()
                    ).commit()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
}

