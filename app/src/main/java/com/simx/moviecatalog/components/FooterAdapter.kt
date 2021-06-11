package com.simx.moviecatalog.components

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.simx.moviecatalog.R

class FooterAdapter ( private val retry: () -> Unit): LoadStateAdapter<FooterAdapter.ViewHolder>() {
    class ViewHolder (view: View): RecyclerView.ViewHolder(view)

    override fun onBindViewHolder(holder: ViewHolder, loadState: LoadState) {
        val progress = holder.itemView.findViewById<ProgressBar>(R.id.load_state_progress)
        val btnRetry = holder.itemView.findViewById<MaterialButton>(R.id.load_state_retry)
        val txtErrorMessage = holder.itemView.findViewById<TextView>(R.id.load_state_errorMessage)

        btnRetry.isVisible = loadState !is LoadState.Loading
        txtErrorMessage.isVisible = loadState !is LoadState.Loading
        progress.isVisible = loadState is LoadState.Loading

        if (loadState is LoadState.Error){
            txtErrorMessage.text = loadState.error.localizedMessage
        }

        btnRetry.setOnClickListener {
            retry.invoke()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.footer_layout, parent, false))
    }
}
