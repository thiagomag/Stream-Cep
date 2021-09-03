package br.com.thiago.streamcep.endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco implements Serializable {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    @Override
    public String toString() {
        return "Cep: " + cep + "\n" +
                "Logradouro: " + logradouro + "\n" +
                "Complemento: " + complemento + "\n" +
                "Bairro: " + bairro + "\n" +
                "Localidade: " + localidade + "\n" +
                "UF: " + uf + "\n" +
                "IBGE: " + ibge + "\n" +
                "GIA: " + gia + "\n" +
                "DDD: " + ddd + "\n" +
                "SIAFI: " + siafi;
    }
}

