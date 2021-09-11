package com.example.roomdatabaseconcept.fragments.add

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomdatabaseconcept.R
import com.example.roomdatabaseconcept.data.User
import com.example.roomdatabaseconcept.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.button_add.setOnClickListener {
            insertDataIntoDatabase()
        }

        return view
    }

    private fun insertDataIntoDatabase() {
        val firstName = first_name.text.toString()
        val lastName = last_name.text.toString()
        val age = age.text

        if (inputCheck(firstName, lastName, age)) {
            //create user object
            val user = User(0, firstName, lastName, age.toString().toInt())

            //add user
            mUserViewModel.addUser(user)
            Toast.makeText(
                requireContext(),
                "Successfully Added",
                Toast.LENGTH_SHORT
            ).show()

            //navigate back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
        else {
            Toast.makeText(
                requireContext(),
                "Please fill out all fields",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
        return !(firstName.isEmpty() and lastName.isEmpty() and age.isEmpty())
    }
}