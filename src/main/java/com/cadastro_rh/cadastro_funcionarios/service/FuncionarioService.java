package com.cadastro_rh.cadastro_funcionarios.service;


import com.cadastro_rh.cadastro_funcionarios.model.Funcionario;
import com.cadastro_rh.cadastro_funcionarios.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarTodos(){
        return funcionarioRepository.findAll();
    }

    public Funcionario salvar(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario buscarId(Long id){
        return funcionarioRepository.findById(id).orElse(null);
    }

    public void deletarPorId(Long id){
        funcionarioRepository.deleteById(id);
    }

    public Funcionario atualizar(Long id, Funcionario funcionarioAtualizado) {
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
        if (optionalFuncionario.isPresent()) {
            Funcionario funcionarioExistente = optionalFuncionario.get();
            funcionarioExistente.setName(funcionarioAtualizado.getName());
            funcionarioExistente.setEmail(funcionarioAtualizado.getEmail());
            funcionarioExistente.setTelefone(funcionarioAtualizado.getTelefone());
            funcionarioExistente.setCpf(funcionarioAtualizado.getCpf());
            funcionarioExistente.setCargo(funcionarioAtualizado.getCargo());
            funcionarioExistente.setDepartamento(funcionarioAtualizado.getDepartamento());
            funcionarioExistente.setSalario(funcionarioAtualizado.getSalario());
            funcionarioExistente.setBonus(funcionarioAtualizado.getBonus());
            return funcionarioRepository.save(funcionarioExistente);
        } else {
            return null;
        }
    }

}
