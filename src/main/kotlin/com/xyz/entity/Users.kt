package com.xyz.entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

@Entity
@Table(name = "sys_users")
        class Users : UserDetails{
        @Id
        @GeneratedValue
        private var id : Long = -1
        private var loginName : String = ""
        private var passwd : String = ""

        @OneToOne
        @JoinColumn(name = "parentId")
        var userDetail : UserDetail = UserDetail()

        @ManyToMany(cascade = [CascadeType.REFRESH],fetch = FetchType.EAGER)
        private var roles : List<SysRole> = ArrayList()

        fun addMap(map : HashMap<String,String>){
                this.userDetail.cname = map["cname"].toString()
                this.userDetail.address = map["address"].toString()
                this.userDetail.blog = map["blog"].toString()
                this.userDetail.email = map["email"].toString()
                this.userDetail.ename = map["ename"].toString()
                this.userDetail.facebook = map["facebook"].toString()
                this.userDetail.github = map["github"].toString()
                this.userDetail.hobby = map["hobby"].toString()
                this.userDetail.introduce = map["introduce"].toString()
                this.userDetail.mobile = map["mobile"].toString()
                this.userDetail.webPage = map["webPage"].toString()
                this.loginName = map["loginName"].toString()
                this.passwd = map["passwd"].toString()
                this.roles = listOf(SysRole(id = map["roleId"]!!.toLong(),name = map["role"].toString()))
        }

        override fun getAuthorities(): MutableCollection<GrantedAuthority> {
                var auths : MutableList<GrantedAuthority> = mutableListOf()
                var roles : List<SysRole> = this.roles
                roles.mapTo(auths) { SimpleGrantedAuthority(it.name) }
            return auths
        }

        override fun getPassword(): String {
                return "{noop}${this.passwd}"
        }

        override fun getUsername(): String {
                return this.loginName
        }

        override fun isAccountNonExpired(): Boolean {
                return true
        }

        override fun isAccountNonLocked(): Boolean {
                return true
        }

        override fun isCredentialsNonExpired(): Boolean {
                return true
        }

        override fun isEnabled(): Boolean {
                return true
        }
}
