package com.example.pw3kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pw3kotlin.databinding.Fragment3Binding

class Fragment3 : Fragment() {

    private lateinit var binding: Fragment3Binding
    private lateinit var viewModel: Fragment3ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Инициализация привязки данных (binding)
        binding = Fragment3Binding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[Fragment3ViewModel::class.java]

        // Наблюдаем за изменениями LiveData и обновляем TextView
        viewModel.text.observe(viewLifecycleOwner) { text ->
            binding.textViewFragment3.text = text
        }

        // Переход на Fragment2 (назад)
        binding.buttonGotoFragment2.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Fragment2())
                .addToBackStack(null)
                .commit()
        }

        // Переход на Fragment1 (вперед)
        binding.buttonGotoFragment1.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Fragment1())
                .addToBackStack(null)
                .commit()
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        // Обновляем данные в LiveData при возвращении на фрагмент
        viewModel.updateText("Фрагмент 3")
    }
}
