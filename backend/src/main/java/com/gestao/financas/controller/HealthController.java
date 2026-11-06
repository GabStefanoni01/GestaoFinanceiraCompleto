package com.gestao.financas.controller;
import org.springframework.web.bind.annotation.*;import java.util.Map;
@RestController public class HealthController {@GetMapping("/health") public Map<String,String> health(){return Map.of("status","UP","service","GestaoFinanceira");}}