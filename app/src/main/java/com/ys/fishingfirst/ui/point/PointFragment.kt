package com.ys.fishingfirst.ui.point

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ys.fishingfirst.databinding.FragmentPointBinding
import com.ys.fishingfirst.databinding.FragmentPreparationBinding

class PointFragment : Fragment() {

    private lateinit var preparationViewModel: PointViewModel
    private var _binding: FragmentPointBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        preparationViewModel =
            ViewModelProvider(this).get(PointViewModel::class.java)

        _binding = FragmentPointBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textPreparation
        preparationViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}