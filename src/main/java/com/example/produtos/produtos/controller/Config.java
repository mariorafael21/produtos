package com.example.produtos.produtos.controller;

import com.example.produtos.produtos.database.ProdutoDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

@Controller
@RequestMapping("/config")
public class Config {
    @RequestMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, URISyntaxException {
        ProdutoDAO loja = new ProdutoDAO();
        loja.createTab();
        loja.insertProduto(new Produtos("AUTO  FALANTE 10 POL ",450,"PRETO", "TRITON",400));
        loja.insertProduto(new Produtos("AUTO  FALANTE 8 POL",400,"PRETO", "TRITON",300));
        loja.insertProduto(new Produtos("AUTO  FALANTE 15 POL",850,"PRETO", "TRITON",3800));
        loja.insertProduto(new Produtos("AUTO  FALANTE 18 POL",900,"PRETO", "TRITON",3800));
        loja.insertProduto(new Produtos("DRIVER TRD505 150 RMS",550,"PRETO", "TRITON",150));
        response.getWriter().println("ok");
    }
}

