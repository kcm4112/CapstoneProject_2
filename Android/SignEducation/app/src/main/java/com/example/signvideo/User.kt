package com.example.signvideo

class User {
    var id : String = ""
    var pw : String = ""
    var See : String = ""
    constructor()
    constructor(id : String, pw : String, see : String) {
        this.id = id
        this.pw = pw
        this.See = see
    }
}