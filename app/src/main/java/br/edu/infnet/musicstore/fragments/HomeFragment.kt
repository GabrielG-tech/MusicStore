package br.edu.infnet.musicstore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.edu.infnet.musicstore.R
import br.edu.infnet.musicstore.databinding.FragmentHomeBinding



class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        setup()
        return view
    }

    private fun setup() {
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.apply{
            btnTipos.setOnClickListener {
                nav(R.id.action_homeFragment_to_tipoFragment)
            }

            btnInstrumentos.setOnClickListener {
                nav(R.id.action_homeFragment_to_instrumentosFragment)
            }
        }
    }

    private fun nav(id: Int){
        findNavController().navigate(id)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}