package com.example.produtos.produtos.controller;

import com.example.produtos.produtos.database.ProdutoDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping("/cliente")
public class Cliente {

    @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

        ProdutoDAO som = new ProdutoDAO();
        ArrayList<Produtos> pro = som.listProduto();

        response.getWriter().println("<h1>LISTA PRODUTOS</h1>");
        response.getWriter().println("<table>" +
                "        <tr>" +
                "            <th> NOME </th>" +
                "            <th> PRECO </th>" +
                "            <th> COR </th>" +
                "            <th> MARCA </th>" +
                "            <th> POTENCIA </th>" +
                "            <th> CARRINHO </th>" +
                "        </tr>");
        for(var p: pro){
            response.getWriter().println("<tr>" +
                    "        <td>" + p.getNome()  + "</td>" +
                    "        <td>" + p.getPreco()  + "</td>" +
                    "        <td>" + p.getCor()  + "</td>" +
                    "        <td>" + p.getMarca()  + "</td>" +
                    "        <td>" + p.getPotenciarms()  + "</td>" +
                    "        <td><a href= \"/adicionarCarrinho?id=" + p.getId() + "\">adicionar </a></td>" +
                    "    </tr>");
        }
        response.getWriter().println("</table>");

        response.getWriter().println("</br>" +
                "</br>");
        response.getWriter().println("<a href= /verCarrinho > Ver Carrinho </a>  ");
    }

}
