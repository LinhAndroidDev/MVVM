package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.adapter.TvShowsAdapter
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.viewmodel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: TvShowViewModel by viewModels()
    private lateinit var tvShowsAdapter: TvShowsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUpRv()
    }

    private fun setUpRv() {
        tvShowsAdapter = TvShowsAdapter()

        binding.rcv.apply {
            adapter = tvShowsAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity, GridLayoutManager.HORIZONTAL,
                false
            )
        }

        viewModel.responseTvShow.observe(this) { listTvShows ->
            tvShowsAdapter.tvShows = listTvShows
        }
    }
}