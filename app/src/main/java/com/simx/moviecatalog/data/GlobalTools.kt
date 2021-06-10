package com.simx.moviecatalog.data

class GlobalTools {
    fun youtubeUrl(key:String?):String {
        return "https://www.youtube.com/embed/$key"
    }
    fun image200(path:String?): String {
        return "https://image.tmdb.org/t/p/w200$path"
    }
    fun image300(path:String?): String {
        return "https://image.tmdb.org/t/p/w300$path"
    }
    fun image400(path:String?): String {
        return "https://image.tmdb.org/t/p/w400$path"
    }
    fun image500(path:String?): String {
        return "https://image.tmdb.org/t/p/w500$path"
    }
}