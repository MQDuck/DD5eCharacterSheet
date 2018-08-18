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

import android.content.Context
import android.support.v4.app.Fragment

abstract class MainActivityFragment : Fragment() {
    protected var mainActivity: MainActivity? = null
    protected var rules: LinkedHashMap<String?, Any>? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) {
            mainActivity = context
            rules = context.rules
        } else {
            throw RuntimeException("context must be a MainActivity")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mainActivity = null
    }
}