package com.example.pamprojcw

import android.widget.Toast

class User(private var username:String, private var password:String) {
    private   var budget :Float? = null

    fun getUsername(): String {
        return username
    }

    fun getPassword(): String {
        return password

    }

    //do zmiany nazwy uzytkownika
    fun setUsername(username: String) {
        this.username = username
    }
    //do zmiany hasla
    fun setPassword(password:String){
        this.password= password
    }


    fun setBudget(budget : Float){
        this.budget = budget
    }

    fun addToBudget(add : Float){
        if(this.budget != null) {
            this.budget = this.budget!! + add

        }
        else{
            this.budget = add

        }
    }
    fun takeFromBudget(subtract : Float) {
        if(this.budget != null && this.budget!! > 0){

            if(subtract <= this.budget!!) {
            this.budget = this.budget!! - subtract
            }
            else {
                throw IllegalAccessException("New budget value is negative!")
            }
        }

        if(this.budget!!.equals(0) || this.budget == null) {
            throw IllegalAccessException("New budget value is negative!")
        }
    }

    fun getBudget():Float {
        return if(this.budget != null) {
            this.budget!!
        } else {this.budget = 0.0f
            this.budget!!
        }
    }

}