package com.example.myapplication.ui

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.AuthConstants
import com.example.myapplication.data.PersonalInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

sealed class AuthState {
    object Idle : AuthState()
    object Loading : AuthState()
    data class Success(val user: PersonalInfo) : AuthState()
    data class Error(val message: String) : AuthState()
}

class AuthViewModel : ViewModel() {
    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    fun login(username: String, password: String) {
        _authState.value = AuthState.Loading
        
        // Simulating auth logic
        if (username == AuthConstants.CORRECT_USERNAME && password == AuthConstants.CORRECT_PASSWORD) {
            _authState.value = AuthState.Success(AuthConstants.DEFAULT_USER)
        } else {
            _authState.value = AuthState.Error("Invalid username or password")
        }
    }

    fun logout() {
        _authState.value = AuthState.Idle
    }
}
