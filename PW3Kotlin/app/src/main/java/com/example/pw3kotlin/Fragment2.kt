package com.example.pw3kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pw3kotlin.databinding.Fragment2Binding

class Fragment2 : Fragment() {

    private lateinit var binding: Fragment2Binding
    private lateinit var viewModel: Fragment2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Инициализация привязки данных (binding)
        binding = Fragment2Binding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[Fragment2ViewModel::class.java]

        // Наблюдаем за изменениями LiveData и обновляем TextView
        viewModel.text.observe(viewLifecycleOwner) { text ->
            binding.textViewFragment2.text = text
        }

        // Переход на Fragment1 (назад)
        binding.buttonGotoFragment1.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Fragment1())
                .addToBackStack(null)
                .commit()
        }

        // Переход на Fragment3 (вперед)
        binding.buttonGotoFragment3.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Fragment3())
                .addToBackStack(null)
                .commit()
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        // Обновляем данные в LiveData при возвращении на фрагмент
        viewModel.updateText("Фрагмент 2")
    }
}
