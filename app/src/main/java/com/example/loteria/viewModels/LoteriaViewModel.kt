package com.example.loteria.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoteriaViewModel : ViewModel() {
    private val _lottoNumbers = mutableStateOf(emptyList<Int>())
    val lottoNumbers: MutableState<List<Int>> = _lottoNumbers
    private val _reintegro = mutableIntStateOf(0)
    val reintegro: MutableState<Int> = _reintegro

    fun generateLottoNumbers() {
        _lottoNumbers.value = (1..49).shuffled().take(6).sorted()
        _reintegro.intValue = (0..9).random()
    }
}