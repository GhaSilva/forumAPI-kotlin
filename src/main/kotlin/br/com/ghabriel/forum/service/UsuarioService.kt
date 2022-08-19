package br.com.ghabriel.forum.service

import br.com.ghabriel.forum.model.Curso
import br.com.ghabriel.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service()
class UsuarioService(var usuarios: List<Usuario>) {
    init {
        val usuario = Usuario(
            id = 1,
            nome = "Ana da silva",
            email = "ana@gmail.com"
        )
        usuarios = Arrays.asList(usuario)
    }

    fun findById(id: Long): Usuario {
        return usuarios.stream().filter({
                c -> c.id == id
        }).findFirst().get()
    }
}
