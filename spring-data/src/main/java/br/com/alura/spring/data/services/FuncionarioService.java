package br.com.alura.spring.data.services;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class FuncionarioService {
    public final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void start(Scanner scanner) throws Exception{
        System.out.println("1 - Salvar");
        System.out.println("2 - Alterar");
        System.out.println("3 - Pesquisar");
        System.out.println("4 - Ver todos");
        System.out.println("5 - Deletar");
        System.out.println("6 - Query nativa (menor que)");
        int action = scanner.nextInt();

        switch (action){
            case 1:
                salvarFuncionario(scanner);
                break;
            case 2:
                alterarFuncionario(scanner);
                break;
            case 3:
                lerFuncionario(scanner);
                break;
            case 4:
                lerTodos();
                break;
            case 5:
                deletarFuncionario(scanner);
                break;
            case 6:
                funcionarioMenorQue(scanner);
                break;
        }
    }

    private void funcionarioMenorQue(Scanner scanner){
        System.out.println("Pesquisar funcionários com salários a partir de:");
        Float salario = scanner.nextFloat();
        List<Funcionario> funcionariosMenorQue = funcionarioRepository.findBySalarioMenor(salario);
        funcionariosMenorQue.forEach(System.out::println);
    }

    private void salvarFuncionario(Scanner scanner){
        System.out.println("Digite o nome do novo funcionário:");
        String nome = scanner.next();
        System.out.println("Digite o cpf do novo funcionário:");
        String cpf = scanner.next();
        System.out.println("Digite o salário do novo funcionário:");
        Float salario = scanner.nextFloat();
        Funcionario funcionario = new Funcionario(nome, cpf, salario);
        this.funcionarioRepository.save(funcionario);
        System.out.println("Novo Funcionário salvo!");
    }

    private void alterarFuncionario(Scanner scanner) throws Exception {
        System.out.println("Qual o id você deseja alterar?");
        int id = scanner.nextInt();
        Optional<Funcionario> funcionarioOp = this.funcionarioRepository.findById(id);
        Funcionario funcionario = funcionarioOp.orElseThrow(() -> new Exception("Funcionário não encontrado"));
        System.out.println("Nome atual: " + funcionario.getNome());
        System.out.println("Digite o novo nome:");
        String nome = scanner.next();
        System.out.println("Cpf atual: " + funcionario.getCpf());
        System.out.println("Digite o novo cpf:");
        String cpf = scanner.next();
        System.out.println("Salário atual: " + funcionario.getSalario());
        System.out.println("Digite o novo salário:");
        Float salario = scanner.nextFloat();
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        this.funcionarioRepository.save(funcionario);
        System.out.println("Funcionário atualizado!");
    }

    private void lerFuncionario(Scanner scanner) throws Exception {
        System.out.println("Qual o id você deseja ler?");
        int id = scanner.nextInt();
        Optional<Funcionario> funcionarioOp = this.funcionarioRepository.findById(id);
        Funcionario funcionario = funcionarioOp.orElseThrow(() -> new Exception("Funcionário não encontrado"));
        System.out.println("ID: " + funcionario.getId());
        System.out.println("NOME: " + funcionario.getNome());
        System.out.println("CPF: " + funcionario.getCpf());
        System.out.println("SALÁRIO: " + funcionario.getSalario());
    }

    private void lerTodos(){
        Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
        funcionarios.forEach((funcionario -> System.out.println(funcionario)));
    }

    private void deletarFuncionario(Scanner scanner){
        System.out.println("Qual o id você deseja deletar?");
        int id = scanner.nextInt();
        this.funcionarioRepository.deleteById(id);
        System.out.println("Funcionário deletado!");
    }

}
