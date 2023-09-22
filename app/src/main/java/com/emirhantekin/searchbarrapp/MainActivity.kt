package com.emirhantekin.searchbarrapp

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import java.util.*

import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var myAdapter: MyAdapter? = null
    private var users = ArrayList<User>()

    private val listener = object : OnClickListener {
        override fun onClickEvent(user: User) {
            Toast.makeText(applicationContext, user.name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Display UserList
        getUserList()

        //
        //EditText'te bir değişiklik olduğunda bir yöntemi çağırmak için bir TextChangedListener ekleme
        editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            //karakter kümesini temsil eder ve bu karakter kümesini incelemek için yöntemler tanımlar
            }

            override fun afterTextChanged(editable: Editable) {
                //yöntemi çağıran ve arama girişini ileten değişiklikten sonra
                filter(editable.toString())
            }
        })
    }

    //f bastıhım zaman neden f ile baslamayan da geliyor ve f ye bastıgım zaman ikisinin gelmesi süreci nasıl
    // son harfi sildigimde bütün hepsnin neden nasıl göründüğü

    private fun getUserList() {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        users = User.getUserList()
        myAdapter = MyAdapter(users)
        myAdapter!!.setListener(listener)
        recyclerView.adapter = myAdapter
    }

    private fun filter(text: String) {

        ///yeni filtrelenmiş verileri tutacak dizi listesi
        val filteredNames = ArrayList<User>()
        //mevcut elemanlar arasında geçiş yapmak ve elemanı filtrelenmiş listeye eklemek
        users.filterTo(filteredNames) {
            //mevcut öğeler arama girdisini içeriyorsa
            it.name.toLowerCase().contains(text.toLowerCase())
        }
        //bağdaştırıcı sınıfının bir yöntemini çağırma ve filtrelenmiş listeyi geçirme
        myAdapter!!.filterList(filteredNames)
    }





}