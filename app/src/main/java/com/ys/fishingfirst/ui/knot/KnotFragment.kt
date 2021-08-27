package com.ys.fishingfirst.ui.knot

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.ys.fishingfirst.R
import com.ys.fishingfirst.databinding.FragmentKnotBinding

class KnotFragment : Fragment() {

    private lateinit var knotViewModel: KnotViewModel
    private var _binding: FragmentKnotBinding? = null
    lateinit var knotListAdapter: KnotListAdapter

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
        val context = activity as Context

        initRecycler(context)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        knotListAdapter.navController = Navigation.findNavController(view)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecycler(context: Context) {
        val rvProfile: RecyclerView = binding.rvProfile


        val datas = mutableListOf<KnotData>()

        knotListAdapter = KnotListAdapter(this.requireContext())
        rvProfile.adapter = knotListAdapter
        rvProfile.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )


        datas.apply {
            add(KnotData(img = R.drawable.intro_img, name = "고리 매듭"))
            add(KnotData(img = R.drawable.intro_img, name = "루어 매듭"))
            add(KnotData(img = R.drawable.intro_img, name = "직결"))
            add(KnotData(img = R.drawable.intro_img, name = "낚시바늘 매듭"))
            add(KnotData(img = R.drawable.intro_img, name = "기타"))

            knotListAdapter.datas = datas
            knotListAdapter.notifyDataSetChanged()

        }
    }

}