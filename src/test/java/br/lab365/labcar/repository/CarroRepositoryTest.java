package br.lab365.labcar.repository;

import br.lab365.labcar.fixture.CarroFixture;
import br.lab365.labcar.model.CarroModel;
import net.datafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CarroRepositoryTest {

    private Faker faker;

    private Integer quantidade;

    private List<CarroModel> carros;

    @Autowired
    CarroRepository carroRepository;


//    método para anotação @BeforeEach
    @BeforeEach
    public void beforeEach(){
        faker = new Faker(new Locale("pt_BR"));
        quantidade = faker.number().numberBetween(1,100);
        carros = CarroFixture.criarCarrosValidos(quantidade);

        carroRepository.saveAllAndFlush(carros);
    }


//    testar inclusão (método save)
    @Test
    public void postTest(){

        CarroModel carroNovo = CarroFixture.criarCarroValido();

        carroRepository.saveAndFlush(carroNovo);

        List<CarroModel> todosCarros = carroRepository.findAll();

        Assertions.assertNotNull(carroNovo.getId());
        Assertions.assertTrue(todosCarros.size() == quantidade + 1);

    }


//    testar método findById
//    testar método findAll
//    testar excessões


//TODO    Crie os testes unitários para os métodos “CarroRepository”:
//
//TODO    Utilizando “ ” crie alguns registros para popular o banco de dados
//
//TODO    Testar  inclusão (método “save”) criando um novo registro e verificando a quantidade de registros existentes
//
//TODO    Testar “findById”
//
//TODO    Testar “findAll”
//
//TODO    Testar excessões que possam ocorrer para cada atributo da entidade (como campos obrigatórios não enviados,
// tamanho excedente, valores defaults, …)
}