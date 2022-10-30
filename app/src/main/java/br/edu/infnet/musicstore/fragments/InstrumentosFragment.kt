package br.edu.infnet.musicstore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import br.edu.infnet.musicstore.databinding.FragmentInstrumentosBinding
import br.edu.infnet.musicstore.models.Instrumento
import br.edu.infnet.musicstore.viewmodel.MainViewModel
import kotlinx.coroutines.launch


class InstrumentosFragment : Fragment() {

    val viewModel: MainViewModel by viewModels()

    private var _binding: FragmentInstrumentosBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInstrumentosBinding.inflate(inflater, container, false)
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
            val texto = viewModel.getAllInstrumentosString()
            binding.tvAllInstrumentos.text = texto
        }
    }

    private fun onUpdateClick() {
        val idInput = binding.inputIdInstrumentoUpdate.text.toString().toLong()
        val nomeInput = binding.inputNomeInstrumentoUpdate.text.toString()
        val tipoIdInput = binding.inputIdTipoUpdate.text.toString().toLong()
        val instrumento = Instrumento(id = idInput, nome = nomeInput, tipoId = tipoIdInput)
        viewModel.updateInstrumento(instrumento)
    }

    private fun onRemoveByIdClick() {
        val idInput = binding.inputNomeIdInstrumento.text.toString().toLong()
        viewModel.deleteInstrumentoById(idInput)
    }

    private fun onGetByIdClick() {
        val idInput = binding.inputNomeIdInstrumento.text.toString().toLong()
        lifecycleScope.launch {
            val produto = viewModel.getInstrumentoById(idInput)
            binding.tvInstrumento.text = produto.nome
        }
    }

    fun onSaveClick() {
        val nomeInput = binding.inputNomeInstrumento.text.toString()
        val tipoIdInput = binding.inputIdTipo.text.toString().toLong()
        viewModel.insertInstrumento(Instrumento(nome = nomeInput, tipoId = tipoIdInput))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}