package br.com.ghabriel.forum.mapper

import br.com.ghabriel.forum.dto.NovoTopicoForm
import br.com.ghabriel.forum.dto.TopicoView
import br.com.ghabriel.forum.model.Topico
import br.com.ghabriel.forum.service.CursoService
import br.com.ghabriel.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(private val cursoService: CursoService,
                       private val autorService: UsuarioService
                       ): Mapper<NovoTopicoForm, Topico> {

    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem =  t.mensagem,
            curso = cursoService.findById(t.idCurso),
            autor = autorService.findById(t.idAutor)
        )
    }

}
