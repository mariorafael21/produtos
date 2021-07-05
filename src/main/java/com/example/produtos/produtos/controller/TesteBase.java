package com.example.produtos.produtos.controller;

import com.example.produtos.produtos.database.ConectionBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

@Controller
@RequestMapping("/teste")
public class TesteBase {

    @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Connection connection = null;
        try {
            connection = ConectionBase.getConnection();
        } catch (SQLException | URISyntaxException ex) {
            response.getWriter().append("A conexão falhou!");
        }

        if (connection != null) {
            response.getWriter().append("A conexão com o banco foi realizada!");
        } else {
            response.getWriter().append("A conexão com o banco falhou!");
        }

        try {
            assert connection != null;
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
