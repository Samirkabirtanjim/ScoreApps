package com.example.scoreapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.scoreapp.dataadapter.PostDataClassAdapter
import com.example.scoreapp.dataadapter.postdataclass

class Today : Fragment() {

    private lateinit var recyclerViewPostType: RecyclerView
    private lateinit var dataListPostType: ArrayList<postdataclass>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_today, container, false)

        // Initialize RecyclerView
        recyclerViewPostType = view.findViewById(R.id.recyclerView_posttype)
        recyclerViewPostType.layoutManager = LinearLayoutManager(context)
        recyclerViewPostType.setHasFixedSize(true)

        // Initialize data list
        dataListPostType = arrayListOf()
        getDataPostType()

        // Set up adapter
        val adapterPostType = PostDataClassAdapter(dataListPostType)
        recyclerViewPostType.adapter = adapterPostType

        return view
    }

    private fun getDataPostType() {
        val newsChannelImages = listOf(R.drawable.cnn, R.drawable.espn, R.drawable.cnn, R.drawable.espn, R.drawable.cnn)
        val newsChannelNames = listOf("CNN", "ESPN", "CNN", "ESPN", "CNN")
        val playerImages = listOf(R.drawable.mbappe, R.drawable.messi, R.drawable.benzema, R.drawable.endrikc, R.drawable.gavi)
        val postTitles = listOf(
            "Real Madrid’s Mbappé problem?",
            "The BEST LM10 & CR7",
            "Karim To Saudi?",
            "Endrick Presentation",
            "Spain Star Boy Yamal"
        )

        val postDescriptions = listOf(
            "Mbappé's struggle at Real Madrid continues, with no goals or assists in his first three LaLiga games.",
            "The debate heats up: Who's the greatest, Lionel Messi (LM10) or Cristiano Ronaldo (CR7)?",
            "Karim Benzema's potential move to Saudi Arabia sparks rumors and speculation.",
            "Real Madrid's new sensation Endrick is officially unveiled to fans with high expectations.",
            "Yamal, Spain's young talent, is making waves as the next big football star."
        )

        for (i in 0 until 5) {
            dataListPostType.add(
                postdataclass(
                    newschannel = newsChannelImages[i % newsChannelImages.size],
                    newschannelname = newsChannelNames[i % newsChannelNames.size],
                    playerimages = playerImages[i % playerImages.size],
                    posttitle = postTitles[i],
                    postdescription = postDescriptions[i]
                )
            )
        }
    }
}
