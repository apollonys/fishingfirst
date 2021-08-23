package com.ys.fishingfirst.ui.knot

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ys.fishingfirst.databinding.FragmentKnotBinding

class KnotFragment : Fragment() {

    private lateinit var knotViewModel: KnotViewModel
    private var _binding: FragmentKnotBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        knotViewModel =
            ViewModelProvider(this).get(KnotViewModel::class.java)

        _binding = FragmentKnotBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val activity = activity as Context

        val textView: TextView = binding.textKnot
        val knotList: ListView = binding.knotListView

        knotViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        var knot = ArrayList<String>()
        knot.add("모든 매듭법")
        knot.add("기본 낚시 매듭법")
        knot.add("플라이 낚시 매듭법")
        knot.add("list1")
        knot.add("list1")
        knot.add("list1")
        knot.add("list1")
        knot.add("list1")
        knot.add("list1")
        knot.add("list1")
        knot.add("list1")
        knot.add("list1")
        knot.add("list1")
        knot.add("list1")
        knot.add("list1")
        knot.add("list1")
        knot.add("list1")
        knot.add("list1")
        var knotsAdapter = ArrayAdapter(activity,android.R.layout.simple_list_item_1,knot)



        knotList.adapter=knotsAdapter


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}