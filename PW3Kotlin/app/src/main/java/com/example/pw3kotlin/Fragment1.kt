package com.example.pw3kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pw3kotlin.databinding.Fragment1Binding

class Fragment1 : Fragment() {

    private lateinit var binding: Fragment1Binding
    private lateinit var viewModel: Fragment1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Инициализация привязки данных (binding)
        binding = Fragment1Binding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[Fragment1ViewModel::class.java]

        // Наблюдаем за изменениями LiveData и обновляем TextView
        viewModel.text.observe(viewLifecycleOwner) { text ->
            binding.textViewFragment1.text = text
        }

        // Переход на Fragment3 (назад)
        binding.buttonGotoFragment3.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Fragment3())
                .addToBackStack(null)
                .commit()
        }

        // Переход на Fragment2 (вперед)
        binding.buttonGotoFragment2.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Fragment2())
                .addToBackStack(null)
                .commit()
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        // Обновляем данные в LiveData при возвращении на фрагмент
        viewModel.updateText("Фрагмент 1")
    }
}
