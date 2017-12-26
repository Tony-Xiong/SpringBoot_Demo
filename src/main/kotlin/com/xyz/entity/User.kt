package com.xyz.entity

import javax.persistence.*

@Entity
@Table(name = "user")
        class User{
    @Column var user = ""
    @Column var passwd = ""
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id :Int = 0
    @Column var phone_num = ""
    @Column var email = ""
    @Column var address = ""

    override fun toString(): String {
        return "user:$user , password:$passwd, ID:$id,phone Number:$phone_num,email:$email,address:$address"
    }

    fun toUser(map : HashMap<String,String>) : User {
        var user:User = User()
        map.mapNotNull {
            user.user = map["name"].toString()
            user.passwd = map["passwd"].toString()
            user.phone_num = map["phone_num"].toString()
            user.address = map["address"].toString()
            user.email = map["email"].toString()
        }
        return user
    }

}
