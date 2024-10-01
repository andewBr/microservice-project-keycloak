package com.example.service;

import com.example.entity.CurriculumVitae;
import com.example.repository.CurriculumVitaeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;

@Service
@Qualifier("CurriculumVitaeService1")
public class CurriculumVitaeService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CurriculumVitaeRepository cvRepository;

    public Optional<CurriculumVitae> getCvByUuid(UUID uuid) {
        return cvRepository.findByUuid(uuid);
    }

    public String getCountryNameById(Long countryId) {
//        String url = "http://COUNTRY-SERVICE/api/v1/countries/" + countryId;
        String url = "http://api-gateway/country-server/api/v1/countries/" + countryId;
        return restTemplate.getForObject(url, String.class);
    }

    public String getCvDataForPdf(UUID uuid) {
        // Отправляем запрос в CurriculumVitae Service для получения данных о CV
//        String url = "http://localhost:8084/api/cv/" + uuid;
//        CurriculumVitae cv = restTemplate.getForObject(url, CurriculumVitae.class);
        CurriculumVitae cv = cvRepository.findByUuid(uuid).get();

        // Формируем строку с данными CV для вставки в PDF
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(cv.getName()).append("\n");
        sb.append("Surname: ").append(cv.getSurname()).append("\n");
        sb.append("City: ").append(cv.getCity()).append("\n");
        sb.append("Status: ").append(cv.getStatus()).append("\n");

        return sb.toString();
    }
}
