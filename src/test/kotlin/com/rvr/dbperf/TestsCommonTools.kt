package com.rvr.dbperf

import com.rvr.dbperf.user.User
import com.rvr.dbperf.user.UserDTO

// extensions

fun User.toDto(
        name: String = this.name,
        login: String = this.login,
        email: String = this.email,
        avatar: String? = this.avatar) = UserDTO(name, login, email, avatar)

// builders

fun createUser(id: Long? = null, name: String = "a user", login: String = "auser", email: String = "auser@users.com") = User(id, name, login, email)

