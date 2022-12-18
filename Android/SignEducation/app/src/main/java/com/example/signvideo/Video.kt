package com.example.signvideo

class Video {
    //비디오에 대한 정보를 저장하는 클래스
    var id : Int = 0
    var name : String = ""
    var category : String = ""
    var url : String = ""

    constructor()
    constructor(id : Int, name : String, category: String, url : String) {
        this.id = id
        this.name = name
        this.category = category
        this.url = url
    }
}