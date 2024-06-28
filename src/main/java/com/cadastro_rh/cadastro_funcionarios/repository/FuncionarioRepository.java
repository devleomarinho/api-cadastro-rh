package com.cadastro_rh.cadastro_funcionarios.repository;

import com.cadastro_rh.cadastro_funcionarios.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
