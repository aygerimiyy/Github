package com.example.github.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.github.R
import com.example.github.data.models.RepositoryResponse
import com.example.github.databinding.ItemProfileRespoBinding

class ProfileRepoAdapter:
    ListAdapter<RepositoryResponse, ProfileRepoAdapter.RepoProfileViewHolder>(diffCallBack){

        inner class RepoProfileViewHolder(private val binding: ItemProfileRespoBinding):
                ViewHolder(binding.root){

    fun bind() {
        val take = getItem(adapterPosition)

        binding.apply {
            itemTextProjectProf.text = take.name
        }

    }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoProfileViewHolder {
        return RepoProfileViewHolder(
            ItemProfileRespoBinding.bind(
                LayoutInflater.from(
                    parent.context
                ).inflate(R.layout.item_profile_respo, parent, false)
            )
        )
    }

    override fun onBindViewHolder(holder: RepoProfileViewHolder, position: Int) {
       holder.bind()
    }

    private object diffCallBack: DiffUtil.ItemCallback<RepositoryResponse>(){
        override fun areItemsTheSame(
            oldItem: RepositoryResponse,
            newItem: RepositoryResponse
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: RepositoryResponse,
            newItem: RepositoryResponse
        ): Boolean {
            return oldItem == newItem
        }
    }
}