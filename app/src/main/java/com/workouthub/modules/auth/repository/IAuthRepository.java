package com.workouthub.modules.auth.repository;

import com.workouthub.modules.auth.dto.AuthnDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IAuthRepository {
    @POST("auth/login")
    Call<AuthnDto.LoginDto> login(@Body AuthnDto.LoginDto loginDto);
}