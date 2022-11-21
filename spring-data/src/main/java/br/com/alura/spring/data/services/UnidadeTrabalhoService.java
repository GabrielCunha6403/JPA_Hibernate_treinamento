package br.com.alura.spring.data.services;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class UnidadeTrabalhoService {
    public final UnidadeTrabalhoRepository unidadeTrabalhoRepository;

    public UnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
    }

    public void start(Scanner scanner) throws Exception{
        System.out.println("1 - Salvar");
        System.out.println("2 - Alterar");
        System.out.println("3 - Pesquisar");
        System.out.println("4 - Ver todos");
        System.out.println("5 - Deletar");
        int action = scanner.nextInt();

        switch (action){
            case 1:
                salvarUnidadeDeTrabalho(scanner);
                break;
            case 2:
                alterarUnidadeDeTrabalho(scanner);
                break;
            case 3:
                lerUnidadeDeTrabalho(scanner);
                break;
            case 4:
                lerTodos(scanner);
                break;
            case 5:
                deletarUnidadeDeTrabalho(scanner);
                break;
        }
    }

    private void salvarUnidadeDeTrabalho(Scanner scanner){
        System.out.println("Digite a descrição da nova unidade de trabalho:");
        String descricao = scanner.next();
        System.out.println("Digite o endereço da nova unidade de trabalho:");
        String endereco = scanner.next();
        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho(descricao, endereco);
        this.unidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println("Nova Unidade de Trabalho salva!");
    }

    private void alterarUnidadeDeTrabalho(Scanner scanner) throws Exception {
        System.out.println("Qual o id você deseja alterar?");
        int id = scanner.nextInt();
        Optional<UnidadeTrabalho> unidadeTrabalhoOp = this.unidadeTrabalhoRepository.findById(id);
        UnidadeTrabalho unidadeTrabalho = unidadeTrabalhoOp.orElseThrow(() -> new Exception("Unidade de trabalho não encontrada"));
        System.out.println("Endereço atual: " + unidadeTrabalho.getEndereco());
        System.out.println("Digite o novo endereço:");
        String endereco = scanner.next();
        System.out.println("Descrição atual: " + unidadeTrabalho.getDescricao());
        System.out.println("Digite a nova descrição:");
        String descricao = scanner.next();
        unidadeTrabalho.setEndereco(endereco);
        unidadeTrabalho.setDescricao(descricao);
        this.unidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println("Unidade de Trabalho atualizada!");
    }

    private void lerUnidadeDeTrabalho(Scanner scanner) throws Exception {
        System.out.println("Qual o id você deseja ler?");
        int id = scanner.nextInt();
        Optional<UnidadeTrabalho> unidadeTrabalhoOp = this.unidadeTrabalhoRepository.findById(id);
        UnidadeTrabalho unidadeTrabalho = unidadeTrabalhoOp.orElseThrow(() -> new Exception("Unidade de trabalho não encontrada"));
        System.out.println("ID: " + unidadeTrabalho.getId());
        System.out.println("DESCRIÇÃO: " + unidadeTrabalho.getDescricao());
        System.out.println("ENDEREÇO: " + unidadeTrabalho.getEndereco());
    }

    private void lerTodos(Scanner scanner){
        Iterable<UnidadeTrabalho> unidades = unidadeTrabalhoRepository.findAll();
        unidades.forEach((unidade -> System.out.println(unidades)));
    }

    private void deletarUnidadeDeTrabalho(Scanner scanner){
        System.out.println("Qual o id você deseja deletar?");
        int id = scanner.nextInt();
        this.unidadeTrabalhoRepository.deleteById(id);
        System.out.println("Unidade de trabalho deletada!");
    }
}
