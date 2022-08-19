package br.com.ghabriel.forum.controller

import br.com.ghabriel.forum.dto.NovoTopicoForm
import br.com.ghabriel.forum.dto.TopicoView
import br.com.ghabriel.forum.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController()
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService) {

    @GetMapping()
    fun listar(): List<TopicoView> {
        return topicoService.findAll()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView {
        return topicoService.findById(id)
    }

    @PostMapping()
    fun cadastrar(@RequestBody @Valid dto: NovoTopicoForm){
        topicoService.registry(dto)
    }


}