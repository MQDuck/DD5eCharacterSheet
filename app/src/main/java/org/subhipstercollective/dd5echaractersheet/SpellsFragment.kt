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
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class SpellsFragment : CharacterSheetFragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_spells, container, false)
    }

    companion object {
        fun newInstance() = SpellsFragment()
    }
}
