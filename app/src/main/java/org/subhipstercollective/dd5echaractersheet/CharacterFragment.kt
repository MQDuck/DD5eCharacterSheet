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
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_character.*
import kotlinx.android.synthetic.main.view_ability.view.*

class CharacterFragment : CharacterSheetFragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        ability_strength.score = 18
        ability_dexterity.score = 14
        ability_constitution.score = 16
        ability_intelligence.score = 8
        ability_wisdom.score = 12
        ability_charisma.score = 10
    }

    companion object {
        fun newInstance() = CharacterFragment()
    }
}

private class AbilityView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    var score: Int
        get() = Integer.parseInt(ability_score.text.toString())
        set(value) {
            ability_score.text = value.toString()
            ability_modifier.text = String.format("%+d", abilityModifier(value))
        }

    val modifier get() = Integer.parseInt(ability_modifier.text.toString())

    var name: String
        get() = ability_name.text.toString()
        set(value) {
            ability_name.text = value
        }

    init {
        inflate(getContext(), R.layout.view_ability, this)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.AbilityView)
        val name = attributes.getString(R.styleable.AbilityView_name)
        val score = attributes.getInt(R.styleable.AbilityView_score, Int.MIN_VALUE)
        attributes.recycle()

        if(name != null)
            this.name = name
        if(score != Int.MIN_VALUE)
            this.score = score
    }
}

//// TODO: Rename parameter arguments, choose names that match
//// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"
//
///**
// * A simple [Fragment] subclass.
// * Activities that contain this fragment must implement the
// * [CharacterFragment.OnFragmentInteractionListener] interface
// * to handle interaction events.
// *
// */
//class CharacterFragment : Fragment() {
//    private var listener: OnFragmentInteractionListener? = null
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_character, container, false)
//    }
//
//    // TODO: Rename method, update argument and hook method into UI event
//    fun onButtonPressed(uri: Uri) {
//        listener?.onFragmentInteraction(uri)
//    }
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is OnFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
//        }
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        listener = null
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     *
//     *
//     * See the Android Training lesson [Communicating with Other Fragments]
//     * (http://developer.android.com/training/basics/fragments/communicating.html)
//     * for more information.
//     */
//    interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        fun onFragmentInteraction(uri: Uri)
//    }
//
//}
