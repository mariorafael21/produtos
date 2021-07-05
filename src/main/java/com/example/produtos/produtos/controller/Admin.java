package com.example.produtos.produtos.controller;

import com.example.produtos.produtos.database.ProdutoDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class Admin {

    @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("<h1>CADASTRAR PRODUTO</h1>");
        response.getWriter().println("<form action=/admin/cadastra method = post>" +
                "       <label>Nome Produto: </label><input type=text name=nome > </br> </br>   " +
                "       <label>Preco: </label><input type=double name=preco  > </br> </br>  " +
                "       <label>Cor: </label><input type=text name=cor  > </br> </br>     " +
                "       <label>Marca: </label><input type=text name=marca  > </br> </br>     " +
                "       <label>Potencia RMS: </label><input type=int name=potenciarms  > </br> </br> " +
                "                <button type=submit  value=submit >ENVIAR</button>  " +
                "                      </form>  ");
        Date d = new Date();
        var acesso = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
        var dFormatada = acesso.format(d);
        Cookie c = new Cookie("visita",dFormatada);
        c.setMaxAge(3600*24);
        response.addCookie(c);


    }
    @RequestMapping(value = "/cadastra", method = RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, URISyntaxException {
        ProdutoDAO lojasom = new ProdutoDAO();
        String nome = request.getParameter("nome");
        Double preco = Double.parseDouble(request.getParameter("preco"));
        String cor = request.getParameter("cor");
        String marca = request.getParameter("marca");
        int potenciarms = Integer.parseInt(request.getParameter("potenciarms"));
        lojasom.insertProduto(new Produtos(nome,preco,cor,marca,potenciarms));
        response.sendRedirect("/admin");
    }
}
