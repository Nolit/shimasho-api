package net.nolit.dredear.service

import net.nolit.dredear.entity.User
import net.nolit.dredear.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
        private val repository: UserRepository,
        private val passwordEncoder: PasswordEncoder) {

    @Transactional
    fun create(email: String, password: String): User {
        val user = User()
        user.email = email
        user.pass = passwordEncoder.encode(password)
        return repository.save(user)
    }

    @Transactional
    fun getAll(): List<User> {
        return repository.findAll()
    }
}