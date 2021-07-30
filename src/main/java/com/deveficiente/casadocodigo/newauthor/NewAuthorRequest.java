package com.deveficiente.casadocodigo.newauthor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewAuthorRequest {

    @NotBlank(message = "Field 'name' must not be empty")
    private final String name;

    @NotBlank(message = "Field 'email' must not be null")
    @Email
    private final String email;

    @NotBlank(message = "Field 'description' must not be empty")
    @Size(message = "Field 'description' has max length of 400 characters", max = 400)
    private final String description;

    public NewAuthorRequest(@NotBlank String name,
                            @Email @NotNull String email,
                            @NotBlank @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Author toEntity() {
        return new Author(this.name, this.email, this.description);
    }
}
