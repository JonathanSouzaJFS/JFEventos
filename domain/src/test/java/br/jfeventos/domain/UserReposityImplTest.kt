package br.jfeventos.domain

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import br.jfeventos.domain.repository.UserRepository
import br.jfeventos.domain.usecase.UserRepositoryImpl
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test

class UserReposityImplTest {

    private lateinit var repository: UserRepositoryImpl
    private lateinit var useCase: UserRepository
    private lateinit var sharedPreferences: SharedPreferences

    private val context = mockk<Context>(relaxed = true)

    @Before
    fun setUp() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

        useCase = UserRepositoryImpl(sharedPreferences)
    }

    @After
    fun finish() {
        unmockkAll()
    }


    @Test
    fun `GIVEN name WHEN set sharedPreferes name THEN call name`() = runBlockingTest {
        val name = "Jonathan Feitosa"
        coEvery { useCase.getName() } returns name
        assertEquals(name, useCase.getName())
    }

    @Test
    fun `GIVEN email WHEN set sharedPreferes email THEN call email`() = runBlockingTest {
        val email = "jfsjonathanfeitosa@gmail.com"
        coEvery { useCase.getEmail() } returns email
        assertEquals(email, useCase.getEmail())
    }
}