package com.example.remaiderapp.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.remaiderapp.R
import com.example.remaiderapp.data.UserViewModel
import com.example.remaiderapp.databinding.FragmentListBinding
import kotlinx.android.synthetic.main.fragment_list.view.*


class listFragment : Fragment() {
    lateinit var viewmodel : UserViewModel
    lateinit var binding : FragmentListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater,container,false
        )
        viewmodel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewmodel.readAllData.observe(viewLifecycleOwner, Observer { it ->
            it.let { arr ->
    val arrList = mutableListOf<String>("")
    var attachString = ""
                arr.forEach { user ->
                    attachString = "${user.Name} -> ${user.date} : ${user.Note} "
                    arrList.add( attachString)

    }
                val string = arrList.joinToString(separator = "\n")
                binding.textView.setText( string)


            }
        })

        binding.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        binding.delete.setOnClickListener {

//            viewmodel.delete()
        }


        return  binding.root
    }
}
