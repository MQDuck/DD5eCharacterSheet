/*
 * Copyright 2018 Jeffrey Thomas Piercy
 *
 * This file is part of D&D 5e Character Sheet.
 *
 * D&D 5e Character Sheet is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * D&D 5e Character Sheet is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * D&D 5e Character Sheet.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.subhipstercollective.dd5echaractersheet

class Character {
    var strength = 0
    var dexterity = 0
    var constitution = 0
    var intelligence = 0
    var wisdom = 0
    var charisma = 0

    var name = ""
    var race = ""
    var subrace = ""
    var superclass = ""
    var subclass = ""
    var alignment = Alignment.TRUE_NEUTRAL

    var maxHP = 0
    var currentHP = 0
    var temporaryHP = 0

    var totalHitDice = 0
    var currentHitDice = 0

    var deathSuccesses = 0
    var deathFailures = 0

    var xp = 0
    val level get() = 1

    val strengthModifier get() = abilityModifier(strength)
    val dexterityModifier get() = abilityModifier(dexterity)
    val constitutionModifier get() = abilityModifier(constitution)
    val intelligenceModifier get() = abilityModifier(intelligence)
    val wisdomModifier get() = abilityModifier(wisdom)
    val charismaModifier get() = abilityModifier(charisma)

    enum class Alignment(val string: String) {
        LAWFUL_GOOD("Lawful Good"),
        NEUTRAL_GOOD("Neutral Good"),
        CHAOTIC_GOOD("Chaotic Good"),
        LAWFUL_NEUTRAL("Lawful Neutral"),
        TRUE_NEUTRAL("True Neutral"),
        CHAOTIC_NEUTRAL("Chaotic Neutral"),
        LAWFUL_EVIL("Lawful Evil"),
        NEUTRAL_EVIL("Neutral Evil"),
        CHAOTIC_EVIL("Chaotic Evil")
    }

    companion object {
        fun abilityModifier(abilityScore: Int) = abilityScore/2 - 5
    }
}