package com.task.searchrepo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.task.searchrepo.model.Repo
import com.task.searchrepo.util.Convert

class RepoAdapter : RecyclerView.Adapter<RepoViewHolder>(){
    private var mItems = mutableListOf<Repo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        return RepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = mItems[position]
        holder.usernameTextView.text = "🙂" + repo.owner.login
        holder.gitrepoTextView.text = repo.name
        if (repo.description == null) {
            holder.descriptionTextView.visibility = View.GONE
        } else {
            holder.descriptionTextView.text = repo.description
        }
        if (repo.language == null) {
            holder.languageTextView.visibility = View.GONE
        } else {
            holder.languageTextView.text = repo.language
        }
        holder.starCountTextView.text = "🌟" + Convert().numToString(repo.stargazersCount)
        holder.updateDateTextView.text = repo.updatedAt?.let { Convert().stringDateToFormat(it) }
    }

    override fun getItemCount(): Int = mItems.size

    fun clear() {
        mItems.clear()
    }

    fun updateItems(items: List<Repo>) {
        this.mItems = items as MutableList<Repo>
        notifyDataSetChanged()
    }
}

class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var usernameTextView: TextView = itemView.findViewById(R.id.tv_username)
    var gitrepoTextView: TextView = itemView.findViewById(R.id.tv_repo_name)
    var descriptionTextView: TextView = itemView.findViewById(R.id.tv_description)
    var languageTextView: TextView = itemView.findViewById(R.id.tv_language)
    var starCountTextView: TextView = itemView.findViewById(R.id.tv_stargazers_count)
    var updateDateTextView: TextView = itemView.findViewById(R.id.tv_updated_at)

}