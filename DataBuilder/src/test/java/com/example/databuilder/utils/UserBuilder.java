package com.example.databuilder.utils;

import com.example.databuilder.User;

public class UserBuilder {
    private String username;
    private String email;
    private double salario;
    private int idade;
    private String cpf;

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withSalario(double salario) {
        this.salario = salario;
        return this;
    }

    public UserBuilder withIdade(int idade) {
        this.idade = idade;
        return this;
    }

    public UserBuilder withCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public User build() {
        return new User(username, email, salario, idade, cpf);
    }
}