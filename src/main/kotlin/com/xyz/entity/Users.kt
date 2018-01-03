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

        fun getRoles() : List<SysRole> = roles

        override fun getAuthorities(): MutableCollection<GrantedAuthority> {
                var auths : MutableList<GrantedAuthority> = mutableListOf()
                var roles : List<SysRole> = this.getRoles()
                for (role in roles){
                    auths.add(SimpleGrantedAuthority(role.name))
                }
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
