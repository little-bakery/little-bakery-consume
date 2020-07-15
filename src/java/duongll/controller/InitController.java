/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongll.controller;

import duongll.client.AnswerClient;
import duongll.client.CakeClient;
import duongll.client.CategoryClient;
import duongll.client.QuestionClient;
import duongll.dto.Answers;
import duongll.dto.Cake;
import duongll.dto.Category;
import duongll.dto.Questions;
import java.io.IOException;
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
public class InitController extends HttpServlet {

    private static final String SUCCESS = "index.jsp";
    private static final String ERROR = "error.js";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HashMap<Questions, List<Answers>> result = new HashMap<Questions, List<Answers>>();
        List<Questions> listQuestion;
        String URL = ERROR;
        try {            
            QuestionClient questionClient = new QuestionClient();
            AnswerClient answerClient = new AnswerClient();
            listQuestion = questionClient.findALlQuestion_XML(List.class);
            for (Questions questions : listQuestion) {
                result.put(questions, answerClient.findByQuestionId_XML(List.class, questions.getId() + ""));
            }            
            request.setAttribute("INFO", result);
            if (result != null) {
                URL = SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(URL).forward(request, response);
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
