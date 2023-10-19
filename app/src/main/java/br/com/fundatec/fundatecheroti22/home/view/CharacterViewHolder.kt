package br.com.fundatec.fundatecheroti22.home.view

import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.fundatecheroti22.databinding.CharacterListItemBinding
import br.com.fundatec.fundatecheroti22.gone
import br.com.fundatec.fundatecheroti22.home.domain.CharacterModel
import com.bumptech.glide.Glide

class CharacterViewHolder(
    private val binding: CharacterListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(character: CharacterModel) {
        Glide.with(binding.root.context)
            .load(character.image)
            .into(binding.ivCharacter)
        binding.tvName.text = character.name

        binding.tvName.setOnClickListener {
            binding.ivCharacter.gone()
        }

    }
}