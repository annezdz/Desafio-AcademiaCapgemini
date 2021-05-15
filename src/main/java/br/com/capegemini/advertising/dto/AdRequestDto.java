package br.com.capegemini.advertising.dto;

import br.com.capegemini.advertising.model.Ad;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class AdRequestDto {

    @NotBlank(message = "Nome do anúncio não pode ser deixado em branco.")
    @NotEmpty(message = "Nome do anúncio não pode ser deixado em branco.")
    private String name;

    @NotBlank(message = "Cliente do anúncio não pode ser deixado em branco.")
    @NotEmpty(message = "Cliente do anúncio não pode ser deixado em branco.")
    private String client;

    @FutureOrPresent(message = "Data de início do anúncio deve ser igual ou posterior à data atual.")
    private LocalDate startDate;

    @Future(message = "Data de término do anúncio deve ser posterior à data inicial.")
    private LocalDate endDate;

    @Positive(message = "Valor investido deve ser positivo.")
    private Double amount;

    @Deprecated
    public AdRequestDto () {}

    public AdRequestDto(String name, String client, LocalDate startDate, LocalDate endDate, Double amount) {
        this.name = name;
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getClient() {
        return client;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Double getAmount() {
        return amount;
    }

    public Ad toModel() {
        return new Ad(name, client, startDate, endDate, amount);
    }
}
