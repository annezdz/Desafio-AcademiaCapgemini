package br.com.capegemini.advertising.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "anuncios")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String client;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private Double amount;

    @Deprecated
    public Ad() {}

    public Ad(String name, String client, LocalDate startDate, LocalDate endDate, Double amount) {
        this.name = name;
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return Objects.equals(name, ad.name) && Objects.equals(client, ad.client) && Objects.equals(startDate, ad.startDate) && Objects.equals(endDate, ad.endDate) && Objects.equals(amount, ad.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, client, startDate, endDate, amount);
    }

    @Override
    public String toString() {
        return "Ad{" +
                "name:'" + name + '\'' +
                ", client:'" + client + '\'' +
                ", startDate:" + startDate +
                ", endDate:" + endDate +
                ", amount:" + amount +
                '}';
    }
}
