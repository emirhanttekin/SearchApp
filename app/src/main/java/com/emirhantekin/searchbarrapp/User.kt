package com.emirhantekin.searchbarrapp

import java.io.Serializable

/**
 * Created by Govind on 3/19/2018.
 */

class User(val name: String, val address: String) : Serializable {

    companion object {

        fun getUserList(): ArrayList<User> {
            val users = ArrayList<User>()
            users.clear()
            users.add(User("Emirhan", "Emirhan"))
            users.add(User("Burak", "Burak"))
            users.add(User("Yahya ", "Yahya"))
            users.add(User("Tekin ", "Tekin"))
            users.add(User("Gökdeniz ", "Gökdeniz"))
            users.add(User("Fatih ", "Fatih"))
            users.add(User("Adnan ", "Adana"))
            users.add(User("Yusuf ", "Yusuf"))
            users.add(User("Çağla ", "Çağla"))
            users.add(User("Kaan ", "Kaan"))
            users.add(User("Ahmet ", "Ahmet"))
            users.add(User("Umut ", "Umut"))

            return users
        }
    } }