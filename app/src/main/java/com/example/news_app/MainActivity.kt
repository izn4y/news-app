package com.example.news_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        bottomNav = findViewById(R.id.bottom_navigation_menu)

        bottomNav.setOnNavigationItemSelectedListener {
            //Log.d("TP", "Menu item id ${it.itemId}")
            when(it.itemId){
                R.id.action_headlines_fragment -> {
                    pushFragment(HeadlinesFragment.prepare()); true
                }
                R.id.action_search_fragment -> {
                    pushFragment(SearchFragment.prepare()); true
                }
                R.id.action_favorites_fragment -> {
                    pushFragment(FavoritesFragment.prepare()); true
                }
                R.id.action_bookmarks_fragment -> {
                    pushFragment(BookmarksFragment.prepare()); true
                }
                else -> false
            }
        }
        if (savedInstanceState == null) {
            bottomNav.selectedItemId = R.id.action_headlines_fragment
        }
    }

    private fun pushFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.displayed_content,fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }
}