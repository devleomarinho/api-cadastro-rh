package com.cadastro_rh.cadastro_funcionarios.controller;

import com.cadastro_rh.cadastro_funcionarios.model.Funcionario;
import com.cadastro_rh.cadastro_funcionarios.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> listarTodos(){
        List<Funcionario> funcionarios = funcionarioService.listarTodos();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarId(@PathVariable Long id){
        Funcionario funcionario = funcionarioService.buscarId(id);
        if(funcionario != null){
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario){
        Funcionario funcionarioSave = funcionarioService.salvar(funcionario);
        return new ResponseEntity<>(funcionarioSave, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario funcionarioUpdated){
        Funcionario funcionario = funcionarioService.atualizar(id, funcionarioUpdated);
        if(funcionario != null){
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(funcionario, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id){
        if(funcionarioService.buscarId(id) != null){
            funcionarioService.deletarPorId(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
