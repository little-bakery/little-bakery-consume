/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongll.controller;

import duongll.client.AnswerClient;
import duongll.client.CakeClient;
import duongll.client.IngredientClient;
import duongll.client.MaterialClient;
import duongll.dto.Answers;
import duongll.dto.Cake;
import duongll.dto.CakePoint;
import duongll.dto.CakeResult;
import duongll.dto.Ingredient;
import duongll.dto.Material;
import duongll.utils.ConvertUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author duong
 */
public class SearchController extends HttpServlet {

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
        List<CakeResult> result = new ArrayList<>();
        List<Cake> cakeList = cakeClient.findAll_XML(List.class);
        List<CakeResult> servesResultList = new ArrayList<>();
        List<CakeResult> queryResultList;
        try {

            String listParam = "";
            String[] categoryAnswer = request.getParameterValues("category");
            if (categoryAnswer != null) {
                for (int i = 0; i < categoryAnswer.length; i++) {
                    listParam += categoryAnswer[i] + ", ";
                }
            }
            int sizeQues = Integer.parseInt(request.getParameter("size"));
            for (int i = 0; i < (sizeQues + 1); i++) {
                String answer = request.getParameter("ans" + i);
                if (answer != null) {
                    listParam += answer + ", ";
                }
            }
            listParam = listParam.trim().substring(0, listParam.length() - 2);
            String serves = request.getParameter("serves");
            if (serves != null) {
                int servesNumber = Integer.parseInt(serves);
                for (Cake cake : cakeList) {
                    CakeResult cakeResult = new CakeResult();
                    if (cake.getServes() == servesNumber) {
                        cakeResult.setCake(cake);
                        cakeResult.setPoint(5);
                    } else if (0 < Math.abs(cake.getServes() - servesNumber) && Math.abs(cake.getServes() - servesNumber) < 5) {
                        cakeResult.setCake(cake);
                        cakeResult.setPoint(3);
                    } else if (5 <= Math.abs(cake.getServes() - servesNumber) && Math.abs(cake.getServes() - servesNumber) < 10) {
                        cakeResult.setCake(cake);
                        cakeResult.setPoint(2);
                    } else if (10 <= Math.abs(cake.getServes() - servesNumber)) {
                        cakeResult.setCake(cake);
                        cakeResult.setPoint(1);
                    }
                    servesResultList.add(cakeResult);
                }
            }
            queryResultList = cakeClient.findResultForUser_XML(List.class, listParam);
            for (CakeResult servesResult : servesResultList) {
                for (CakeResult queryResult : queryResultList) {
                    if (queryResult.getCake().getId().intValue() == servesResult.getCake().getId().intValue()) {
                        int tmpPoint = servesResult.getPoint() + queryResult.getPoint();
                        queryResult.setPoint(tmpPoint);
                        break;
                    }
                }
            }
            queryResultList = queryResultList.stream().sorted(Comparator.comparing(CakeResult::getPoint).reversed()).collect(Collectors.toList());
            for (int i = 0; i < 50; i++) {
                result.add(queryResultList.get(i));
            }
            request.setAttribute("RESULT", result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher("result.jsp").forward(request, response);
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
