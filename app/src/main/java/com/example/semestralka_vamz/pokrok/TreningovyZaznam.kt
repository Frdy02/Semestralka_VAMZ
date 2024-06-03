package com.example.semestralka_vamz.pokrok

/**
 * Trieda reprezentujúca tréningový záznam.
 *
 * @param datum Dátum a čas záznamu.
 * @param hmotnost Hmotnosť užívateľa alebo vzdialenosť behu.
 * @param pocetOpakovani Počet opakovaní alebo čas behu.
 * @param poznamka Ďalšie poznámky k záznamu.
 */
class TreningovyZaznam(
    val datum: String,
    val hmotnost: String,
    val pocetOpakovani: String,
    val poznamka: String
)