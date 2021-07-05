package com.example.produtos.produtos.controller;

import com.example.produtos.produtos.database.ProdutoDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping
public class Carrinho {

    @GetMapping("/adicionarCarrinho")
    public void doG(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProdutoDAO lojasom = new ProdutoDAO();
        Produtos p = lojasom.buscar(id);
        HttpSession s = request.getSession();
        ArrayList<Produtos> lista = new ArrayList<>();
        if(s.getAttribute("carrinho") == null){
            s.setAttribute("carrinho", lista);
        }
        ArrayList<Produtos> carrinho = (ArrayList<Produtos>) s.getAttribute("carrinho");
        carrinho.add(p);
        RequestDispatcher encaminhar = request.getRequestDispatcher("/cliente");
        encaminhar.forward(request, response);


    }
    @GetMapping("/verCarrinho")
    public void doGe(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession s = request.getSession();
        if(s.getAttribute("carrinho")!= null){
            ArrayList<Produtos> carrinho = (ArrayList<Produtos>) s.getAttribute("carrinho");
            response.getWriter().println("<h1>LISTA CARRINHO</h1>");
            response.getWriter().println("<table>" +
                    "        <tr>" +
                    "            <th> NOME </th>" +
                    "            <th> PRECO </th>" +
                    "            <th> COR </th>" +
                    "            <th> MARCA </th>" +
                    "            <th> POTENCIA RMS </th>" +
                    "        </tr>");
            for(var p: carrinho){
                response.getWriter().println("<tr>" +
                        "        <td>" + p.getNome()  + "</td>" +
                        "        <td>" + p.getPreco()  + "</td>" +
                        "        <td>" + p.getCor()  + "</td>" +
                        "        <td>" + p.getMarca()  + "</td>" +
                        "        <td>" + p.getPotenciarms()  + "</td>" +
                        "    </tr>");
            }
            response.getWriter().println("</table>");
            response.getWriter().println("</br>" +
                    "</br>");
            response.getWriter().println("<a href=/finalizarCompra >Finalizar Compra</a>");
        }else{
            response.sendRedirect("/cliente");
        }
    }
    @GetMapping("finalizarCompra")
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("/cliente");



    }

}
