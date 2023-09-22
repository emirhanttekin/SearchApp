package com.emirhantekin.searchbarrapp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class MyAdapter(private var userList: ArrayList<User>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private var listener: OnClickListener? = null

    fun setListener(onClickListener: OnClickListener) {
        this.listener = onClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(userList[position])
        //Custom OnClickListener Event
        holder.itemView.setOnClickListener(View.OnClickListener {
            if (listener != null) {
                listener!!.onClickEvent(userList[position])
            }
        })
    }

    override fun getItemCount(): Int { //Tasarımın RecyclerView üzerinde kaç defa gösterileceğini ayarlar.


        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(user: User) {
            val tvName = itemView.findViewById<TextView>(R.id.tvName)
            val tvAddress = itemView.findViewById<TextView>(R.id.tvAddress)
            tvName.text = user.name;
            tvAddress.text = user.address
        }
    }

    /*Bu yöntem listeyi filtreleyecek ve burada filtrelenmiş verileri geçiyoruz
         ve notifyDataSetChanged yöntemi ile listeye atamak
     */
    fun filterList(filteredNames: ArrayList<User>) {
        this.userList = filteredNames
        notifyDataSetChanged()
        //Adaptore verinin değiştiğini bildirmek için kullanıyoruz
    }
}