package com.xyz.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class SysRole(    @Id @GeneratedValue var id: Long = -1,var name : String = "")