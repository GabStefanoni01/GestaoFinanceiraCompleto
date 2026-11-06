package com.gestao.financas.dto;
public record AuthResponse(String accessToken,String tokenType,long expiresIn){}