/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongll.controller;

import duongll.client.CakeClient;
import duongll.client.CakePreparationClient;
import duongll.client.FavoriteClient;
import duongll.client.IngredientClient;
import duongll.client.MaterialClient;
import duongll.dto.Account;
import duongll.dto.Cake;
import duongll.dto.CakePreparation;
import duongll.dto.Favorite;
import duongll.dto.Ingredient;
import duongll.dto.Material;
import duongll.utils.XMLUtils;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author duong
 */
public class DetailController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CakeClient cakeClient = new CakeClient();
        IngredientClient ingredientClient = new IngredientClient();
        FavoriteClient favoriteClient = new FavoriteClient();
        CakePreparationClient cakePreparationClient = new CakePreparationClient();
        MaterialClient materialClient = new MaterialClient();
        Favorite favorite = null;
        Cake result = null;
        try {
            HttpSession session = request.getSession();
            Account accountTmp = (Account) session.getAttribute("INFO");
            String username = null;
            if (accountTmp != null) {
                username = accountTmp.getUsername();
            }
            String id = request.getParameter("id");
            result = cakeClient.findByCakeId_XML(Cake.class, id);
            List<Ingredient> listIngredient = ingredientClient.findIngredientByCakeId_XML(List.class, id);
            for (Ingredient ingredient : listIngredient) {
                List<Material> materialList = materialClient.findMaterialByIngredientId_XML(List.class, ingredient.getId() + "");
                ingredient.setMaterialCollection(materialList);
            }
            result.setIngredientCollection(listIngredient);
            List<CakePreparation> cakePreparationList = cakePreparationClient.findPreparationByCakeId_XML(List.class, id);
            result.setCakePreparations(cakePreparationList);            
            if (result != null && username != null) {
                favorite = favoriteClient.findFavoriteFromUser_XML(Favorite.class, result.getId().toString(), username);
            }
            request.setAttribute("FAVO", favorite);
            request.setAttribute("DETAIL", result);
        } catch (Exception e) {
            log("Log at Detail Controller: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("detail.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
