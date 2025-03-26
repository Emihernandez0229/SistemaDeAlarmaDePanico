package com.example.sistemadealarmadepanico

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val firstFragment = FirstFragment()
    private val secondFragment = SecondFragment()
    private val thirdFragment = ThirdFragment()
    private val fourthFragment = FourthFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        navigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.firstFragment -> {
                    loadFragment(firstFragment)
                    true
                }
                R.id.secondFragment -> {
                    loadFragment(secondFragment)
                    true
                }
                R.id.thirdFragment -> {
                    loadFragment(thirdFragment)
                    true
                }
                R.id.fourthFragment -> {
                    loadFragment(fourthFragment)
                    true
                }
                else -> false
            }
        }
        // Cargar el primer fragmento por defecto
        loadFragment(firstFragment)
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment)
        transaction.commit()
    }
}
