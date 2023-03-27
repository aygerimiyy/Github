package com.example.github.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.github.R
import com.example.github.data.models.RepositoryResponse
import com.example.github.databinding.ItemRepositoriesBinding

class RepositoryAdapter:
    androidx.recyclerview.widget.ListAdapter<RepositoryResponse, RepositoryAdapter.RepositoryViewHolder>(diffCallBack) {

    inner class RepositoryViewHolder(private val binding: ItemRepositoriesBinding):
      ViewHolder(binding.root){
          fun bind(){
                val take = getItem(adapterPosition)

              binding.apply {
                  Glide.with(profileImgItem)
                      .load(take.owner.avatar_url)
                      .into(profileImgItem)

                  textName.text = take.name
                  textUsername.text = take.owner.login
              }
          }
      }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(ItemRepositoriesBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.item_repositories, parent, false)
        ))
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind()
    }

    private object diffCallBack: DiffUtil.ItemCallback<RepositoryResponse>(){
        override fun areContentsTheSame(
            oldItem: RepositoryResponse,
            newItem: RepositoryResponse
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areItemsTheSame(
            oldItem: RepositoryResponse,
            newItem: RepositoryResponse
        ): Boolean {
            return oldItem == newItem
        }
    }
}