package br.com.capegemini.advertising.dto;

import br.com.capegemini.advertising.model.Ad;

import java.time.LocalDate;

public class AdResponseDto {

    private Long id;
    private String name;
    private String client;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double amount;

    public AdResponseDto(Ad ad) {
        this.id = ad.getId();
        this.name = ad.getName();
        this.client = ad.getClient();
        this.startDate = ad.getStartDate();
        this.endDate = ad.getEndDate();
        this.amount = ad.getAmount();
    }

    public Long getId() {
        return id;
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
}
