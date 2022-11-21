package br.com.alura.spring.data.services;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {
    private final FuncionarioRepository funcionarioRepository;
    public boolean system = true;

    public RelatoriosService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void start(Scanner scanner){
        while(system){
            System.out.println("0 - Sair");
            System.out.println("1 - Buscar funcionário por nome");
            int select = scanner.nextInt();

            switch (select){
                case 1:
                    buscarFuncionarioPorNome(scanner);
                    break;
                case 0:
                    system = false;
                    break;
            }
        }
    }

    private void buscarFuncionarioPorNome(Scanner scanner){
        System.out.println("Digite o nome a ser pesquisado:");
        String nome = scanner.next();
        List<Funcionario> list = funcionarioRepository.findByNome(nome);
        list.forEach(System.out::println);
    }
}
