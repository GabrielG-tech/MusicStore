package br.edu.infnet.musicstore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import br.edu.infnet.musicstore.databinding.FragmentTipoBinding
import br.edu.infnet.musicstore.models.Tipo
import br.edu.infnet.musicstore.viewmodel.MainViewModel
import kotlinx.coroutines.launch


class TipoFragment : Fragment() {
    val viewModel : MainViewModel by viewModels()

    private var _binding: FragmentTipoBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTipoBinding.inflate(inflater, container, false)
        val view = binding.root

        setup()
        return view
    }

    private fun setup() {
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.apply{
            btnSave.setOnClickListener {
                onSaveClick()
            }

            btnGetById.setOnClickListener {
                onGetByIdClick()
            }

            btnRemoveById.setOnClickListener {
                onRemoveByIdClick()
            }

            btnUpdate.setOnClickListener {
                onUpdateClick()
            }

            btnListAll.setOnClickListener {
                onListClick()
            }

        }
    }

    private fun onListClick() {
        lifecycleScope.launch {
            val texto = viewModel.getAllTiposString()
            binding.tvAllTipos.text = texto
        }
    }

    private fun onUpdateClick() {
        val idInput = binding.inputIdTipoUpdate.text.toString().toLong()
        val nomeInput = binding.inputNomeTipoUpdate.text.toString()
        val tipo = Tipo(id = idInput, nome = nomeInput)
        viewModel.updateTipo(tipo)
    }

    private fun onRemoveByIdClick() {
        val idInput = binding.inputNomeIdTipo.text.toString().toLong()
        viewModel.deleteTipoById(idInput)
    }

    private fun onGetByIdClick() {
        val idInput = binding.inputNomeIdTipo.text.toString().toLong()
        lifecycleScope.launch {
            val categoria = viewModel.getTipoById(idInput)
            binding.tvTipo.text = categoria.nome
        }
    }

    fun onSaveClick() {
        val nomeInput = binding.inputNomeTipo.text.toString()
        viewModel.insertTipo(Tipo(nome = nomeInput))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
