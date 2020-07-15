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
import duongll.dto.CakeWeight;
import duongll.dto.Category;
import duongll.dto.Ingredient;
import duongll.dto.Material;
import duongll.utils.ConvertUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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
        List<CakePoint> tmpResult = new ArrayList<>();
        List<CakePoint> result = new ArrayList<>();
        AnswerClient answerClient = new AnswerClient();
        IngredientClient ingredientClient = new IngredientClient();
        MaterialClient materialClient = new MaterialClient();
        CakeClient cakeClient = new CakeClient();
        List<Cake> tmpList = cakeClient.findAll_XML(List.class);
        try {
            String[] answerCategory = request.getParameterValues("category");
            if (answerCategory != null) {
                for (int i = 0; i < answerCategory.length; i++) {
                    Answers tmp = answerClient.find_XML(Answers.class, answerCategory[i]);
                    for (Cake cake : tmpList) {
                        if (cake.getCategoryid().getName().equalsIgnoreCase(tmp.getName())) {
                            CakePoint cakePoint = new CakePoint();
                            cakePoint.setCake(cake);
                            cakePoint.setPoint(tmp.getPoint());
                            tmpResult.add(cakePoint);
                        }
                    }
                }
            }
            // initial material and ingredient for cake in result list
            for (CakePoint cakePoint : tmpResult) {
                Cake tmpCake = cakePoint.getCake();
                List<Ingredient> tmpIngredientList = ingredientClient.findIngredientByCakeId_XML(List.class, cakePoint.getCake().getId() + "");
                if (tmpIngredientList != null) {
                    for (Ingredient ingredient : tmpIngredientList) {
                        List<Material> tmpMaterialList = materialClient.findMaterialByIngredientId_XML(List.class, ingredient.getId() + "");
                        if (tmpMaterialList != null) {
                            ingredient.setMaterialCollection(tmpMaterialList);
                        }
                    }
                    tmpCake.setIngredientCollection(tmpIngredientList);
                }
            }
            String serves = request.getParameter("serves");
            int tmpServes = Integer.parseInt(serves);
            if (serves != null) {
                if (!serves.isEmpty()) {
                    for (CakePoint cakePoint : tmpResult) {
                        int tmpPoint = 0;
                        if (cakePoint.getCake().getServes() == tmpServes) {
                            tmpPoint = cakePoint.getPoint().intValue() + 5;
                            cakePoint.setPoint(tmpPoint);
                        } else if (0 < Math.abs(cakePoint.getCake().getServes() - tmpServes) && Math.abs(cakePoint.getCake().getServes() - tmpServes) < 5) {
                            tmpPoint = cakePoint.getPoint().intValue() + 3;
                            cakePoint.setPoint(tmpPoint);
                        } else if (5 <= Math.abs(cakePoint.getCake().getServes() - tmpServes) && Math.abs(cakePoint.getCake().getServes() - tmpServes) < 10) {
                            tmpPoint = cakePoint.getPoint().intValue() + 2;
                            cakePoint.setPoint(tmpPoint);
                        } else if (10 <= Math.abs(cakePoint.getCake().getServes() - tmpServes)) {
                            tmpPoint = cakePoint.getPoint().intValue() + 1;
                            cakePoint.setPoint(tmpPoint);
                        }
                    }
                }
            }
            int sizeQues = Integer.parseInt(request.getParameter("size"));
            for (int i = 0; i < (sizeQues + 1); i++) {
                String answer = request.getParameter("ans" + i);
                if (answer != null) {
                    Answers tmp = answerClient.find_XML(Answers.class, answer);
                    if (tmp.getName().equalsIgnoreCase("yes")) {
                        for (CakePoint cakePoint : tmpResult) {
                            boolean fitAnswer = false;
                            if (tmp.getQuestionid().getTag().equalsIgnoreCase("material")) {
                                if (tmp.getQuestionid().getKeyword() != null) {
                                    for (Ingredient ingredient : cakePoint.getCake().getIngredientCollection()) {
                                        for (Material material : ingredient.getMaterialCollection()) {
                                            if (material.getName().equalsIgnoreCase(tmp.getQuestionid().getKeyword())) {
                                                fitAnswer = true;
                                                break;
                                            }
                                        }
                                    }
                                }
                            } else if (tmp.getQuestionid().getTag().equalsIgnoreCase("serves")) {
                                if (tmp.getQuestionid().getKeyword() != null) {
                                    if (Integer.parseInt(tmp.getQuestionid().getKeyword()) == cakePoint.getCake().getServes().intValue()) {
                                        fitAnswer = true;
                                    }
                                }
                            } else if (tmp.getQuestionid().getTag().equalsIgnoreCase("time")) {
                                if (tmp.getQuestionid().getKeyword() != null) {
                                    int tmpTime = ConvertUtils.convertTimeToMinute(tmp.getQuestionid().getKeyword());
                                    int cakeTime = ConvertUtils.convertTimeToMinute(cakePoint.getCake().getTime());
                                    if (cakeTime == tmpTime) {
                                        fitAnswer = true;
                                    }
                                }
                            } else if (tmp.getQuestionid().getTag().equalsIgnoreCase("category")) {
                                if (tmp.getQuestionid().getKeyword() != null) {
                                    if (cakePoint.getCake().getCategoryid().getName().equalsIgnoreCase(tmp.getQuestionid().getKeyword())) {
                                        fitAnswer = true;
                                    }
                                }
                            }
                            if (fitAnswer) {
                                int tmpPoint = tmp.getPoint().intValue() + cakePoint.getPoint().intValue();
                                cakePoint.setPoint(tmpPoint);
                            }
                        }
                    } else if (tmp.getName().equalsIgnoreCase("no")) {
                        for (CakePoint cakePoint : tmpResult) {
                            boolean fitAnswer = false;
                            if (tmp.getQuestionid().getTag().equalsIgnoreCase("material")) {
                                if (tmp.getQuestionid().getKeyword() != null) {
                                    fitAnswer = true;
                                    for (Ingredient ingredient : cakePoint.getCake().getIngredientCollection()) {
                                        for (Material material : ingredient.getMaterialCollection()) {
                                            if (material.getName().equalsIgnoreCase(tmp.getQuestionid().getKeyword())) {
                                                fitAnswer = false;
                                            }
                                        }
                                    }
                                }
                            } else if (tmp.getQuestionid().getTag().equalsIgnoreCase("serves")) {
                                if (tmp.getQuestionid().getKeyword() != null) {
                                    if (Integer.parseInt(tmp.getQuestionid().getKeyword()) != cakePoint.getCake().getServes().intValue()) {
                                        fitAnswer = true;
                                    }
                                }
                            } else if (tmp.getQuestionid().getTag().equalsIgnoreCase("time")) {
                                if (tmp.getQuestionid().getKeyword() != null) {
                                    int tmpTime = ConvertUtils.convertTimeToMinute(tmp.getQuestionid().getKeyword());
                                    int cakeTime = ConvertUtils.convertTimeToMinute(cakePoint.getCake().getTime());
                                    if (cakeTime != tmpTime) {
                                        fitAnswer = true;
                                    }
                                }
                            } else if (tmp.getQuestionid().getTag().equalsIgnoreCase("category")) {
                                if (tmp.getQuestionid().getKeyword() != null) {
                                    if (!cakePoint.getCake().getCategoryid().getName().equalsIgnoreCase(tmp.getQuestionid().getKeyword())) {
                                        fitAnswer = true;
                                    }
                                }
                            }
                            if (fitAnswer) {
                                int tmpPoint = tmp.getPoint().intValue() + cakePoint.getPoint().intValue();
                                cakePoint.setPoint(tmpPoint);
                            }
                        }
                    }
                }
            }
            CakePoint maxPointResult = tmpResult.stream().max(Comparator.comparing(CakePoint::getPoint)).get();
            for (CakePoint cakePoint : tmpResult) {
                if (cakePoint.getPoint().intValue() == maxPointResult.getPoint().intValue()) {
                    result.add(cakePoint);
                }
            }
            if (result.size() >= 2) {
                Collections.sort(result);
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
