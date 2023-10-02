package br.lab365.labcar.fixture;

import br.lab365.labcar.model.CarroModel;
import net.datafaker.Faker;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CarroFixture {

    private static final Faker faker = new Faker(new Locale("pt-BR"));

    public static List<CarroModel> criarCarrosValidos(Integer qtd){
        List<CarroModel> carros = new ArrayList<>();
        for(int i = 0; i < qtd; i++){
            carros.add(criarCarroValido());
        }
        return carros;
    }

    public static CarroModel criarCarroValido() {
        CarroModel carro = new CarroModel();
        carro.setMarca(faker.vehicle().make());
        carro.setModelo(faker.vehicle().model());
        carro.setAno(faker.date().birthday(1,15).toLocalDateTime().getYear());
        carro.setPreco(BigDecimal.valueOf(faker.number().numberBetween(5000, 300000)));
        carro.setFoto(faker.lorem().characters());
        return carro;
    }


}
