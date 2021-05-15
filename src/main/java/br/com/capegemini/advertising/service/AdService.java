package br.com.capegemini.advertising.service;

import br.com.capegemini.advertising.dto.AdRequestDto;
import br.com.capegemini.advertising.dto.ReportDto;
import br.com.capegemini.advertising.model.Ad;

import java.time.LocalDate;
import java.util.List;

public interface AdService {

    ReportDto buildReport(Long id);

    Ad create(AdRequestDto adRequestDto);

    List<Ad> findAll();

    double totalInvestment(Double amount, LocalDate startDate, LocalDate endDate);
}
