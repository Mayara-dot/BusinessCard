package br.com.dio.businesscard_.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import br.com.dio.businesscard_.App
import br.com.dio.businesscard_.R
import br.com.dio.businesscard_.data.BusinessCard
import br.com.dio.businesscard_.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.BTNClose.setOnClickListener {
            finish()
        }

        binding.BTNConfirmar.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.TILNome.editText?.text.toString(),
                telefone = binding.TILTelefone.editText?.text.toString(),
                email = binding.TILEmail.editText?.text.toString(),
                empresa = binding.TILEmpresa.editText?.text.toString(),
                backgroundCardColor = binding.TILCor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}