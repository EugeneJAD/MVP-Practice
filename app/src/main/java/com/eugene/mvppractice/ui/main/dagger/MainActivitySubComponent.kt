package com.eugene.mvppractice.ui.main.dagger

import com.eugene.mvppractice.ui.main.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [MainActivityModule::class])
interface MainActivitySubComponent {

    fun inject(target: MainActivity)
}