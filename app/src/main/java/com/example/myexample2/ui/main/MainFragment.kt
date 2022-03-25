package com.example.myexample2.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myexample2.R
import com.example.myexample2.ui.main.viewmodel.MainViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {
    companion object {
        fun newInstance() = MainFragment()
    }
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //adding a layoutmanager
        recyclerview.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        val adapter = CustomAdapter()
        recyclerview.adapter = adapter

        context?.let { context ->
            viewModel.fetchUserDataOffline(context).observe(viewLifecycleOwner) { userList ->
                userList?.let { adapter.setUserData(userList.toList()) }
            }
            viewModel.fetchUserDataOnline(context)
            /*viewModel.myResponse.observe(viewLifecycleOwner) {
                it?.let { Log.e("Test", "Fragment: ${Gson().toJson(it)}") }
                it.data?.let {
                    adapter.setUserData(it)
                }
            }*/
        }
    }
}