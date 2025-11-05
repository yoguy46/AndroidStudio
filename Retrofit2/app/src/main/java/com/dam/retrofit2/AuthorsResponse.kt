package com.dam.retrofit2

import com.google.gson.annotations.SerializedName

class AuthorsResponse(val numFound:Int, @SerializedName("docs") var autores:List<Autores>) {
}
class Autores(var key:String, var birthday:String,var name:String){


}