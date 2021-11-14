package com.vishnu.dagger.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.vishnu.dagger.R
import com.vishnu.dagger.utils.ApiResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_game_details.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect
import org.jsoup.Jsoup

@AndroidEntryPoint
class GameDetailsActivity : AppCompatActivity() {

    private  val viewModel: GameDetailsViewModel by  viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_details)
        val id=intent.getIntExtra("id",0)

        viewModel.details(id)
        getData()

    }
    private fun getData() {

        lifecycleScope.launchWhenStarted {
            viewModel._details.collect {
                when (it) {
                    is ApiResponse.Loading -> {

                    }
                    is ApiResponse.Success -> {
                        Glide.with(this@GameDetailsActivity)
                            .load(it.data?.backgroundImage)
                            .into(imageView3)
                        tv_title.text = Jsoup.parse(it.data?.name).text();

                        tv_description.text=Jsoup.parse(it.data?.description).text()

                    }
                    is ApiResponse.Failure -> {

                    }
                }
            }

        }
    }

    
}