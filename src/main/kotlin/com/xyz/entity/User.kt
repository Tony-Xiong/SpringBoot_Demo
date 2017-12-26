package com.xyz.entity

import javax.persistence.*

@Entity
@Table(name = "user")
        class User{
    @Column var user = ""
    @Column var passwd = ""
    @Id
    @GeneratedValue
    var id :Int = 0
    @Column var phone_num = ""
    @Column var email = ""
    @Column var address = ""

    override fun toString(): String {
        return "user:$user , password:$passwd, ID:$id,phone Number:$phone_num,email:$email,address:$address"
    }


}
