package com.example.semestralka_vamz.registracia

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * RegistraciaViewModel je zodpovedný za udržiavanie stavu registrácie a počiatočných testov.
 * A taktiež pri otočení obrazovky, aby vyplnene udaje zostali vyplnene
 */
class RegistraciaViewModel : ViewModel() {
    private val _meno = MutableStateFlow("")
    val meno: StateFlow<String> get() = _meno

    private val _vyska = MutableStateFlow("")
    val vyska: StateFlow<String> get() = _vyska

    private val _hmotnost = MutableStateFlow("")
    val hmotnost: StateFlow<String> get() = _hmotnost

    private val _vek = MutableStateFlow("")
    val vek: StateFlow<String> get() = _vek

    private val _pohlavie = MutableStateFlow("")
    val pohlavie: StateFlow<String> get() = _pohlavie

    private val _klik = MutableStateFlow("")
    val klik: StateFlow<String> get() = _klik

    private val _drep = MutableStateFlow("")
    val drep: StateFlow<String> get() = _drep

    private val _behTime = MutableStateFlow("")
    val behTime: StateFlow<String> get() = _behTime

    private val _bench = MutableStateFlow("")
    val bench: StateFlow<String> get() = _bench

    private val _zdvyh = MutableStateFlow("")
    val zdvyh: StateFlow<String> get() = _zdvyh

    fun onMenoChange(newMeno: String) { _meno.value = newMeno }
    fun onVyskaChange(newVyska: String) { _vyska.value = newVyska }
    fun onHmotnostChange(newHmotnost: String) { _hmotnost.value = newHmotnost }
    fun onVekChange(newVek: String) { _vek.value = newVek }
    fun onPohlavieChange(newPohlavie: String) { _pohlavie.value = newPohlavie }

    fun onKlikChange(newKlik: String) { _klik.value = newKlik }
    fun onDrepChange(newDrep: String) { _drep.value = newDrep }
    fun onBehTimeChange(newBehTime: String) { _behTime.value = newBehTime }
    fun onBenchChange(newBench: String) { _bench.value = newBench }
    fun onZdvyhChange(newZdvyh: String) { _zdvyh.value = newZdvyh }
}