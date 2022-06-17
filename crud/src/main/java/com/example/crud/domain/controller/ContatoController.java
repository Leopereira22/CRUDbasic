package com.example.crud.domain.controller;


import com.example.crud.domain.entity.Contato;
import com.example.crud.domain.exception.NotFoundException;
import com.example.crud.domain.repository.Contatos;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crud")
public class ContatoController {

    private Contatos contatos;

    @Autowired
    public ContatoController(Contatos contatos) {
        this.contatos = contatos;
    }

    @GetMapping("/{id}")
    public Optional<Contato> getContatoById(@PathVariable Integer id) throws NotFoundException {
        if (contatos.findById(id).isPresent()) {
            return contatos.findById(id);
        }
        throw new NotFoundException("Contato não encontrado");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contato save(@RequestBody Contato contato){
        return contatos.save(contato);
}


    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id) throws NotFoundException {
      if (contatos.findById(id).isEmpty()){
          throw new NotFoundException("Contato não encontrado");
      }
        contatos.deleteById(id);
    }

//    @PutMapping("/{id}")
//    public Contato update (@RequestBody Contato contato, @PathVariable Integer id) throws NotFoundException {
//        if (contatos.findById(id).isPresent()){
//        Contato contatoExistente = contato;
//        contato.setId(contatoExistente.getId());
//        contatos.save(contatoExistente);
//        }
//        throw new NotFoundException("Not Found");
//    }

//    @DeleteMapping
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public Contato delete (@PathVariable int id){
//        return contatos.findById(id);

    //    public Contato getClienteById(@PathVariable int id){
//        List<Contato>  = contato.getId();
//        }
}
