package com.example.myapplication

import com.example.myapplication.data.AuthConstants
import com.example.myapplication.ui.AuthState
import com.example.myapplication.ui.AuthViewModel
import org.junit.Assert.assertTrue
import org.junit.Test

class AuthViewModelTest {

    @Test
    fun `login with correct credentials returns Success`() {
        val viewModel = AuthViewModel()
        viewModel.login(AuthConstants.CORRECT_USERNAME, AuthConstants.CORRECT_PASSWORD)
        
        assertTrue(viewModel.authState.value is AuthState.Success)
    }

    @Test
    fun `login with incorrect credentials returns Error`() {
        val viewModel = AuthViewModel()
        viewModel.login("wrong", "wrong")
        
        assertTrue(viewModel.authState.value is AuthState.Error)
    }
}
