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

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*
import org.yaml.snakeyaml.Yaml

class MainActivity : AppCompatActivity() {
    lateinit var rules: LinkedHashMap<String?, Any>
    var character = Character()

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                openFragment(CharacterFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                openFragment(DetailsFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                openFragment(SpellsFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: CharacterSheetFragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        @Suppress("UNCHECKED_CAST")
        rules = Yaml().load(resources.openRawResource(R.raw.rules)) as LinkedHashMap<String?, Any>

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        openFragment(CharacterFragment.newInstance())

        character.name = "Galur Moradar"
        character.race = "Dwarf"
        character.superclass = "Barbarian"
        character.strength = 18
        character.dexterity = 14
        character.constitution = 16
        character.intelligence = 8
        character.wisdom = 12
        character.charisma = 10
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //return super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.options, menu)
        return true
    }
}
