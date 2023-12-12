package presentation.screens.cadastro

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import helpers.URLS.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import model.RegisterUser
import org.example.mybirdapp.BuildKonfig

class CadastroViewModel : ViewModel() {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun registerUser(name: String, email: String, pass: String) : Boolean{
        val url = "${BASE_URL}services/users"
        val response = httpClient.post(url) {
            header(
                BuildKonfig.NAME_KEY,
                BuildKonfig.API_KEY
            )
            contentType(ContentType.Application.Json)
            setBody(RegisterUser(name = name, email = email, password = pass))

        }.body<JsonObject>()
        return response.containsKey("error")
    }
}