package com.example.calcoloimp

class Impasto(val nome: String, val pesoTotale: Double, val ingredienti: List<Ingrediente>) {
    fun pesoIngrediente(nomeIngrediente: String): Double {
        return ingredienti.find { it.nome == nomeIngrediente }?.peso ?: 0.0
    }
    fun percentuali(): Map<String, Double> {
        val percentuali = mutableMapOf<String, Double>()
        for (ingrediente in ingredienti) {
            percentuali[ingrediente.nome] = ingrediente.peso / pesoTotale * 100.0
        }
        return percentuali
    }
}