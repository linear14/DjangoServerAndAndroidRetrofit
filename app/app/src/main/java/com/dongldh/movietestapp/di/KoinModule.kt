package com.dongldh.movietestapp.di

import com.dongldh.movietestapp.viewmodel.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { (id: Int) -> MovieViewModel(id) }
}