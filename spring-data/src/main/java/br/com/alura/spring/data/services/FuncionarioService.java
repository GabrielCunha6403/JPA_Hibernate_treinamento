package br.com.alura.spring.data.services;

import br.com.alura.spring.data.repository.FuncionarioRepository;

public class FuncionarioService {
    public final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }


}
