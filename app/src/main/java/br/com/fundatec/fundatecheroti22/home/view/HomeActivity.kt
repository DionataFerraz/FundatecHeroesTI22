package br.com.fundatec.fundatecheroti22.home.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.fundatecheroti22.R
import br.com.fundatec.fundatecheroti22.databinding.ActivityHomeBinding
import br.com.fundatec.fundatecheroti22.home.domain.CharacterModel

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private val adapter: CharacterListAdapter by lazy {
        CharacterListAdapter()
    }

//    Venom https://t.ctcdn.com.br/SBIRTmM0wCfRxC1OZ66Lk4-l7e4=/1024x576/smart/i527727.jpeg
//    Knull https://cdn.marvel.com/content/1x/kinginblack2020001_int-27.jpg
//    Grito http://www.guiadosquadrinhos.com/edicaoestrangeira/ShowImage.aspx?id=237492&path=ki1990001_237492.jpg
//    Miranha https://cdn.dicionariopopular.com/imagens/homem-aranha-meme-apontando-1-0.jpg

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FundatecHeroTI22)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvList.adapter = adapter
        adapter.addList(
            listOf(
                CharacterModel(
                    name = "Venom",
                    image = "https://t.ctcdn.com.br/SBIRTmM0wCfRxC1OZ66Lk4-l7e4=/1024x576/smart/i527727.jpeg"
                ),
                CharacterModel(
                    name = "Knull",
                    image = "https://cdn.marvel.com/content/1x/kinginblack2020001_int-27.jpg"
                ),
                CharacterModel(
                    name = "Grito",
                    image = "http://www.guiadosquadrinhos.com/edicaoestrangeira/ShowImage.aspx?id=237492&path=ki1990001_237492.jpg"
                ),
                CharacterModel(
                    name = "Miranha",
                    image = "https://cdn.dicionariopopular.com/imagens/homem-aranha-meme-apontando-1-0.jpg"
                ),
            )
        )

        binding.btTest.setOnClickListener {
            adapter.remove(3)
        }
    }
}