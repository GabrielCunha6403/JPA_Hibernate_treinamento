package br.com.alura.spring.data;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.services.CargoService;
import br.com.alura.spring.data.services.FuncionarioService;
import br.com.alura.spring.data.services.RelatoriosService;
import br.com.alura.spring.data.services.UnidadeTrabalhoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CargoService cargoService;
	private final FuncionarioService funcionarioService;
	private final UnidadeTrabalhoService unidadeTrabalhoService;
	private final RelatoriosService relatoriosService;
	private Boolean system = true;

	public SpringDataApplication(CargoService CargoService, FuncionarioService funcionarioService, UnidadeTrabalhoService unidadeTrabalhoService, RelatoriosService relatoriosService){
		this.cargoService = CargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatoriosService = relatoriosService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		while (system){
			System.out.println("Qual ação você deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionário");
			System.out.println("3 - Unidade de Trabalho");
			System.out.println("4 - Relatórios");

			int action = scanner.nextInt();
			switch (action){
				case 1:
					cargoService.inicial(scanner);
					break;
				case 2:
					funcionarioService.start(scanner);
					break;
				case 3:
					unidadeTrabalhoService.start(scanner);
					break;
				case 4:
					relatoriosService.start(scanner);
					break;
				default:
					system = false;
					break;
			}
		}

	}
}
