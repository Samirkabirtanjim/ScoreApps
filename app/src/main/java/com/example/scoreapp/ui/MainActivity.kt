package com.example.scoreapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.scoreapp.Discover
import com.example.scoreapp.Profile
import com.example.scoreapp.R
import com.example.scoreapp.Save
import com.example.scoreapp.Schedule
import com.example.scoreapp.Today
import com.example.scoreapp.dataadapter.DataPost
import com.example.scoreapp.dataadapter.PostDataClassAdapter
import com.example.scoreapp.dataadapter.adapterclass
import com.example.scoreapp.dataadapter.postdataclass
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView
    private lateinit var recyclerViewSportType: RecyclerView
    private lateinit var dataListSportType: ArrayList<DataPost>
    private lateinit var dataListPostType: ArrayList<postdataclass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottomNav)
        bottomNav.setOnApplyWindowInsetsListener(null)
        bottomNav.setPadding(0, 0, 0, 0)

        val todayFragment: Fragment = Today()
        val discoverFragment: Fragment = Discover()
        val scheduleFragment: Fragment = Schedule()
        val saveFragment: Fragment = Save()
        val profileFragment: Fragment = Profile()

        var activeFragment: Fragment = todayFragment

        supportFragmentManager.beginTransaction().apply {
            add(R.id.content, todayFragment, "TODAY")
            add(R.id.content, discoverFragment, "DISCOVER").hide(discoverFragment)
            add(R.id.content, scheduleFragment, "SCHEDULE").hide(scheduleFragment)
            add(R.id.content, saveFragment, "SAVE").hide(saveFragment)
            add(R.id.content, profileFragment, "PROFILE").hide(profileFragment)
            commit()
        }

        bottomNav.setOnItemSelectedListener { item ->
            val newFragment: Fragment =
                when (item.itemId) {
                    R.id.navigation_today -> todayFragment
                    R.id.navigation_discover -> discoverFragment
                    R.id.navigation_schedule -> scheduleFragment
                    R.id.navigation_save -> saveFragment
                    R.id.navigation_profile -> profileFragment
                    else -> return@setOnItemSelectedListener false
                }

            if (activeFragment != newFragment) {
                supportFragmentManager.beginTransaction().apply {
                    hide(activeFragment)
                    show(newFragment)
                    commit()
                }
                activeFragment = newFragment
            } else {
                Toast.makeText(this, "Already on this tab", Toast.LENGTH_SHORT).show()
            }
            true
        }

        recyclerViewSportType = findViewById(R.id.recyclerView_sportype)
        recyclerViewSportType.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewSportType.setHasFixedSize(true)

        dataListSportType = arrayListOf<DataPost>()
        getDataSportType()

        val adapterSportType = adapterclass(dataListSportType)
        recyclerViewSportType.adapter = adapterSportType

    }

    private fun getDataSportType() {
        dataListSportType.add(DataPost("Football"))
        dataListSportType.add(DataPost("NFL"))
        dataListSportType.add(DataPost("NBA"))
        dataListSportType.add(DataPost("Cricket"))
        dataListSportType.add(DataPost("Volleyball"))
        dataListSportType.add(DataPost("Table Tennis"))
        dataListSportType.add(DataPost("Baseball"))
        dataListSportType.add(DataPost("Golf"))
        dataListSportType.add(DataPost("Rugby"))
        dataListSportType.add(DataPost("Hockey"))
    }

}

