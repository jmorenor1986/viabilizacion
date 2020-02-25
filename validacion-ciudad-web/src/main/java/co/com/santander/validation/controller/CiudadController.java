package co.com.santander.validation.controller;

import co.com.santander.validation.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("v1/ciudad")
public class CiudadController {
    private final CiudadService ciudadService;

    @Autowired
    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @GetMapping(value = "/{ciudad}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean validarCiudad(@PathVariable("ciudad") String ciudad) {
        return ciudadService.validarCiudad(ciudad);
    }
}
