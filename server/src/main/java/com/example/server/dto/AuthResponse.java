package com.example.server.dto;

/** 认证响应体（code/msg/userInfo/token）；对外载荷见 AuthData。 */
public record AuthResponse(int code, String msg, UserInfo userInfo, String token) {

    public record UserInfo(Long id, String username, String nickname, String avatar, String role) {
    }
}
