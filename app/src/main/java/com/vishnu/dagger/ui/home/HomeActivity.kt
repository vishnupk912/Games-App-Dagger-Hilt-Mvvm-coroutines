package com.vishnu.dagger.ui.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.vishnu.dagger.R
import com.vishnu.dagger.model.CategoryModel
import com.vishnu.dagger.model.GamesModel
import com.vishnu.dagger.ui.details.GameDetailsActivity
import com.vishnu.dagger.ui.home.adapter.GamesAdapter
import com.vishnu.dagger.utils.ApiResponse
import com.vishnu.dagger.utils.openActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), GamesAdapter.OnclickListener {

    private val homeViewModel: HomeViewModel by viewModels()
    private val category = ArrayList<CategoryModel>()

    private val gamesAdapter by lazy {
        GamesAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData2()
        addCategory()
//        homeViewModel.search("vishnu")

    }

    private fun getData2() {

        lifecycleScope.launchWhenStarted {
            homeViewModel.data.collect {
                when (it) {
                    is ApiResponse.Loading -> {

                    }
                    is ApiResponse.Success -> {
                        rv_games.apply {
                            gamesAdapter.submitList(it.data?.results)
                            adapter = gamesAdapter
                        }

                    }
                    is ApiResponse.Failure -> {

                    }
                }
            }

        }
    }


    private fun addCategory() {

        category.add(CategoryModel(1, "Favorites", R.drawable.favorite))
        category.add(CategoryModel(2, "Action", R.drawable.favorite))
        category.add(CategoryModel(3, "Puzzle", R.drawable.favorite))
        category.add(CategoryModel(4, "Cricket", R.drawable.favorite))
        category.add(CategoryModel(5, "Football", R.drawable.favorite))
        category.add(CategoryModel(6, "Cricket", R.drawable.favorite))

    }

    override fun onGamesClicked(games: GamesModel.Result) {
        openActivity(GameDetailsActivity::class.java){
            putInt("id", games.id)

        }
    }
}
