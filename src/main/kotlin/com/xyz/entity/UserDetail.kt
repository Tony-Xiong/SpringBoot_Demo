package com.xyz.entity

import javax.persistence.*

@Entity
@Table(name = "user_detail")
class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long = -1
    var parentId : Long = -1
    var cname : String = ""
    var ename : String = ""
    var address : String = ""
    var email : String = ""
    var mobile : String = ""
    var hobby : String = ""
    var webPage : String = ""
    var introduce : String = ""
    var github : String = ""
    var facebook : String = ""
    var blog : String = ""
}