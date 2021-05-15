package br.com.capegemini.advertising.dto;

import java.util.List;

public class ReportDto {

    private Long id;
    private String client;
    private Integer totalViews;
    private Integer maxShares;
    private Integer maxkClicks;
    private Double totalInvestment;

    public ReportDto(Long id, String client, List<Double> report, double totalInvestment) {
        this.id = id;
        this.client = client;
        this.totalViews = (int) Math.round(report.get(0));
        this.maxShares = (int) Math.round(report.get(1));
        this.maxkClicks = (int) Math.round(report.get(2));
        this.totalInvestment = totalInvestment;
    }

    @Deprecated
    public ReportDto() {
    }

    public Long getId() {
        return id;
    }

    public String getClient() {
        return client;
    }

    public Integer getTotalViews() {
        return totalViews;
    }

    public Integer getMaxShares() {
        return maxShares;
    }

    public Integer getMaxkClicks() {
        return maxkClicks;
    }

    public Double getTotalInvestment() {
        return totalInvestment;
    }
}
