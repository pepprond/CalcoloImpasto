package com.example.calcoloimp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.calcoloimp.databinding.FragmentCalcoloImpastoBinding

class CalcoloImpasto : Fragment() {
    private lateinit var binding: FragmentCalcoloImpastoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalcoloImpastoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val aggiungiIngredienteButton = binding.aggiungiIngredienteButton
        val calcolaPercentualiButton = binding.calcolaPercentualiButton
        val percentualiTextView = binding.percentualiTextView
        val ingredientiLayout = binding.ingredientiLayout

        val ingredienti = mutableListOf<Ingrediente>()

        aggiungiIngredienteButton.setOnClickListener {
            val nomeIngredienteEditText = EditText(requireContext())
            val pesoIngredienteEditText = EditText(requireContext())
            nomeIngredienteEditText.hint = "Nome ingrediente"
            pesoIngredienteEditText.hint = "Peso ingrediente"
            ingredientiLayout.addView(nomeIngredienteEditText)
            ingredientiLayout.addView(pesoIngredienteEditText)
        }

        calcolaPercentualiButton.setOnClickListener {
            val nomeImpastoEditText = binding.nomeImpastoEditText
            val pesoTotaleEditText = binding.pesoTotaleEditText

            val nomeImpasto = nomeImpastoEditText.text.toString()
            val pesoTotale = pesoTotaleEditText.text.toString().toDouble()

            for (i in 0 until ingredientiLayout.childCount step 2) {
                val nomeIngredienteEditText = ingredientiLayout.getChildAt(i) as EditText
                val pesoIngredienteEditText = ingredientiLayout.getChildAt(i + 1) as EditText
                val nomeIngrediente = nomeIngredienteEditText.text.toString()
                val pesoIngrediente = pesoIngredienteEditText.text.toString().toDouble()
                ingredienti.add(Ingrediente(nomeIngrediente, pesoIngrediente))
            }

            val impasto = Impasto(nomeImpasto, pesoTotale, ingredienti)
            val percentuali = impasto.percentuali()
            val percentualiText = StringBuilder()
            for ((ingrediente, percentuale) in percentuali) {
                percentualiText.append("$ingrediente: ${String.format("%.2f", percentuale)}%\n")
            }
            percentualiTextView.text = percentualiText.toString()
        }
    }

}