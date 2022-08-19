package br.com.ghabriel.forum.service

import br.com.ghabriel.forum.dto.NovoTopicoForm
import br.com.ghabriel.forum.dto.TopicoView
import br.com.ghabriel.forum.mapper.TopicoFormMapper
import br.com.ghabriel.forum.mapper.TopicoViewMapper
import br.com.ghabriel.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service()
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper
) {

    fun findAll(): List<TopicoView> {
        return topicos.stream().map { t -> topicoViewMapper.map(t) }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        return topicoViewMapper.map(topico)
    }

    fun registry(form: NovoTopicoForm) {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topicoFormMapper.map(form))
    }


}