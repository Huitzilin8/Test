package com.example.appnotas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appnotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // variable para acceder a los elementos de la vista
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // inicializar viewbinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // configurar eventos de los botones
        configurarEventos()
    }


    private fun configurarEventos() {
        // evento del botón guardar
        binding.buttonGuardarNota.setOnClickListener {
            val textoNota = binding.editTextNuevaNota.text.toString()
            if (textoNota.isNotBlank()) {
                // por ahora solo mostramos el texto en el área de notas
                binding.textViewListaNotas.text = "Nota guardada: $textoNota"
                binding.editTextNuevaNota.text.clear()
                // actualizar contador
                binding.textViewContadorNotas.text = "Total de notas: 1"
            }
        }

        // evento del botón limpiar
        binding.buttonLimpiarNotas.setOnClickListener {
            binding.textViewListaNotas.text = "No hay notas guardadas"
            binding.textViewContadorNotas.text = "Total de notas: 0"
        }
    }
}