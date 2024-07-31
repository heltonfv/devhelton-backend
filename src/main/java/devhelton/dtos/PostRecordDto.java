package devhelton.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public record PostRecordDto(@NotBlank String title, @NotNull String text) {
}
