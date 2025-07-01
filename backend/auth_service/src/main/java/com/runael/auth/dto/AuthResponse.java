package com.runael.auth.dto;

import java.util.UUID;

public record AuthResponse(UUID id, String token) {
}
