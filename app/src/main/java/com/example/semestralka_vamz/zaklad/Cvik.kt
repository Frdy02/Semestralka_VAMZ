package com.example.semestralka_vamz.zaklad

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.AnnotatedString

/**
 * Trieda reprezentujúca časti tela, používa sa pri push pull a legs a taktiež pri ExercisesScreen aby sa vyhlo duplikacii.
 *
 * @param name Názov cviku.
 * @param imageResId ID obrázka cviku.
 * @param route Trasa navigácie na obrazovku cviku.
 */
data class CastiTela(
    val name: String,
    val imageResId: Int,
    val route: String
)

/**
 * Trieda reprezentujúca cvik s jedným obrázkom a popisom.
 *
 * @param nazov Názov cviku.
 * @param imageResId ID obrázka cviku.
 * @param popis Popis cviku.
 * @param isExpanded Stav, či je cvik rozbalený.
 */
data class Cvik(
    val nazov: String,
    val imageResId: Int,
    val popis: String,
    val isExpanded: MutableState<Boolean> = mutableStateOf(false)
)

/**
 * Trieda reprezentujúca cvik s dvoma obrázkami a popismi.
 *
 * @param nazov Názov cviku.
 * @param imageResId1 ID prvého obrázka cviku.
 * @param popis1 Popis prvého cviku.
 * @param imageResId2 ID druhého obrázka cviku.
 * @param popis2 Popis druhého cviku.
 * @param isExpanded Stav, či je cvik rozbalený.
 */
data class Cviky(
    val nazov: String,
    val imageResId1: Int,
    val popis1: AnnotatedString,
    val imageResId2: Int,
    val popis2: AnnotatedString,
    val isExpanded: MutableState<Boolean> = mutableStateOf(false)
)