package com.example.semestralka_vamz.pokrok

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * PokrokViewModel je zodpovedný za udržiavanie stavu obrazovky pokroku,
 * vrátane zoznamu tréningových záznamov a aktuálnych vstupných údajov.
 * A taktiež pri otočení obrazovky, aby vyplnene udaje zostali vyplnene
 */
class PokrokViewModel : ViewModel() {
    private val _hmotnost = MutableStateFlow("")
    val hmotnost: StateFlow<String> get() = _hmotnost

    private val _pocetOpakovani = MutableStateFlow("")
    val pocetOpakovani: StateFlow<String> get() = _pocetOpakovani

    private val _poznamka = MutableStateFlow("")
    val poznamka: StateFlow<String> get() = _poznamka

    private val _treningoveZaznamy = MutableStateFlow<List<TreningovyZaznam>>(emptyList())
    val treningoveZaznamy: StateFlow<List<TreningovyZaznam>> get() = _treningoveZaznamy

    fun onHmotnostChange(newHmotnost: String) { _hmotnost.value = newHmotnost }
    fun onPocetOpakovaniChange(newPocetOpakovani: String) { _pocetOpakovani.value = newPocetOpakovani }
    fun onPoznamkaChange(newPoznamka: String) { _poznamka.value = newPoznamka }

    fun addTrainingRecord(record: TreningovyZaznam) {
        _treningoveZaznamy.value += record
    }


    fun removeTrainingRecord(record: TreningovyZaznam) {
        _treningoveZaznamy.value -= record
    }

    fun loadRecords(savedRecords: List<TreningovyZaznam>) {
        _treningoveZaznamy.value = savedRecords
    }
}