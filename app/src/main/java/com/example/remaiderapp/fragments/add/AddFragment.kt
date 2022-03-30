package com.example.remaiderapp.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.remaiderapp.R
import com.example.remaiderapp.data.User
import com.example.remaiderapp.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class addFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.add_btn.setOnClickListener{
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val name = editTextTextPersonName.text.toString()
        val note = editTextTextPersonNote.text.toString()
        val date = editTextTextPersonDate.text.toString()

        if(inputCheck(name,note,date)){
            val user = User(0,name,note,date)
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully added",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"Fill out all the fields",Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(name: String,note:String,date:String):Boolean{
        return !(TextUtils.isEmpty(name)&& TextUtils.isEmpty(note) && TextUtils.isEmpty(date))

    }
}

