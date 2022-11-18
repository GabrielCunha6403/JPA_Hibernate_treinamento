package br.com.alura.spring.data.services;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CargoService {
    public final CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void inicial(Scanner scanner) throws Exception {
        System.out.println("1 - Salvar");
        System.out.println("2 - Alterar");
        System.out.println("3 - Pesquisar");
        System.out.println("4 - Ver todos");
        System.out.println("5 - Deletar");
        int action = scanner.nextInt();

        switch (action){
            case 1:
                salvar(scanner);
                break;
            case 2:
                update(scanner);
                break;
            case 3:
                read(scanner);
                break;
            case 4:
                readAll(scanner);
                break;
            case 5:
                delete(scanner);
                break;

        }
    }

    private void salvar(Scanner scanner){
        System.out.println("Descrição do cargo:");
        String descricao = scanner.next();
        Cargo cargo = new Cargo(descricao);
        this.cargoRepository.save(cargo);
        System.out.println("Novo cargo salvo!");
    }

    private void update(Scanner scanner) throws Exception {
        System.out.println("Qual o id você deseja alterar?");
        int id = scanner.nextInt();
        Optional<Cargo> cargoOp = this.cargoRepository.findById(id);
        Cargo cargo = cargoOp.orElseThrow(() -> new Exception("Usuário não encontrado"));
        System.out.println("Descrição atual: " + cargo.getDescricao());
        System.out.println("Digite a nova descrição:");
        String descricao = scanner.next();
        cargo.setDescricao(descricao);
        this.cargoRepository.save(cargo);
        System.out.println("Cargo atualizado!");
    }

    private void read(Scanner scanner) throws Exception {
        System.out.println("Digite o id a ser lido:");
        int id = scanner.nextInt();
        Optional<Cargo> cargoOp = this.cargoRepository.findById(id);
        Cargo cargo = cargoOp.orElseThrow(() -> new Exception("Cargo não encontrado"));
        System.out.println("ID: " + cargo.getId() + "|| DESCRIÇÃO: " + cargo.getDescricao());
    }
    private void readAll(Scanner scanner) throws Exception {
        Iterable<Cargo> cargos = cargoRepository.findAll();
        cargos.forEach((cargo -> System.out.println(cargo)));
    }

    private void delete(Scanner scanner) throws Exception {
        System.out.println("Digite o id a ser excluído:");
        int id = scanner.nextInt();
        this.cargoRepository.deleteById(id);
        System.out.println("Cargo deletado");
    }

}
