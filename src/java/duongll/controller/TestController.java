/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongll.controller;

import duongll.client.AnswerClient;
import duongll.client.CakeClient;
import duongll.client.CategoryClient;
import duongll.client.MaterialClient;
import duongll.client.QuestionClient;
import duongll.dto.Answers;
import duongll.dto.Cake;
import duongll.dto.CakeWeight;
import duongll.dto.Category;
import duongll.dto.Material;
import duongll.dto.Questions;
import duongll.utils.ConvertUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class TestController extends HttpServlet {

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
//        HashMap<Questions, List<Answers>> result = new HashMap<Questions, List<Answers>>();
//        List<Questions> listQuestion;
//        List<Cake> cakeList;
//        List<Material> materialList;
//        CakeWeight cakeWeight = new CakeWeight();
//        try {
//            QuestionClient questionClient = new QuestionClient();
//            CakeWeightClient cakeWeightClient = new CakeWeightClient();
//            MaterialClient materialClient = new MaterialClient();
//            AnswerClient answerClient = new AnswerClient();
//            CakeClient cakeClient = new CakeClient();
//            cakeList = cakeClient.findAllXML(List.class);
//            listQuestion = questionClient.findAllXML(List.class);
//            for (Questions questions : listQuestion) {
//                result.put(questions, answerClient.findByQuestionId_XML(List.class, questions.getId() + ""));
//            }
//            for (Questions questions : result.keySet()) {
//                if (questions.getId().intValue() == 1) {
//                    for (Answers answers : result.get(questions)) {
//                        if (answers.getId().intValue() == 1) {
//                            for (Cake cake : cakeList) {
//                                if (cake.getCategoryid().getId() == 1) {
//                                    cakeWeight.setId(new Long(0));
//                                    cakeWeight.setCakeid(cake);
//                                    cakeWeight.setAnswerid(answers);
//                                    cakeWeightClient.createCakeWeight_XML(cakeWeight, CakeWeight.class);
//                                }
//                            }
//                        } else if (answers.getId().intValue() == 2) {
//                            for (Cake cake : cakeList) {
//                                if (cake.getCategoryid().getId() == 2) {
//                                    cakeWeight.setId(new Long(0));
//                                    cakeWeight.setCakeid(cake);
//                                    cakeWeight.setAnswerid(answers);
//                                    cakeWeightClient.createCakeWeight_XML(cakeWeight, CakeWeight.class);
//                                }
//                            }
//                        } else if (answers.getId().intValue() == 3) {
//                            for (Cake cake : cakeList) {
//                                if (cake.getCategoryid().getId() == 3) {
//                                    cakeWeight.setId(new Long(0));
//                                    cakeWeight.setCakeid(cake);
//                                    cakeWeight.setAnswerid(answers);
//                                    cakeWeightClient.createCakeWeight_XML(cakeWeight, CakeWeight.class);
//                                }
//                            }
//                        } else if (answers.getId().intValue() == 4) {
//                            for (Cake cake : cakeList) {
//                                if (cake.getCategoryid().getId() == 4) {
//                                    cakeWeight.setId(new Long(0));
//                                    cakeWeight.setCakeid(cake);
//                                    cakeWeight.setAnswerid(answers);
//                                    cakeWeightClient.createCakeWeight_XML(cakeWeight, CakeWeight.class);
//                                }
//                            }
//                        } else if (answers.getId().intValue() == 5) {
//                            for (Cake cake : cakeList) {
//                                if (cake.getCategoryid().getId() == 5) {
//                                    cakeWeight.setId(new Long(0));
//                                    cakeWeight.setCakeid(cake);
//                                    cakeWeight.setAnswerid(answers);
//                                    cakeWeightClient.createCakeWeight_XML(cakeWeight, CakeWeight.class);
//                                }
//                            }
//                        }
//                    }
//                } else if (questions.getId().intValue() == 2) {
//                    materialList = materialClient.getMaterialByName_XML(List.class, "chocolate");
//                    for (Answers answers : result.get(questions)) {
//                        //for answer yes
//                        if (answers.getId() == 6) {
//                            for (Material material : materialList) {
//                                cakeWeight.setId(new Long(0));
//                                cakeWeight.setCakeid(material.getIngredientid().getCakeid());
//                                cakeWeight.setAnswerid(answers);
//                                cakeWeightClient.createCakeWeight_XML(cakeWeight, CakeWeight.class);
//                            }
//                            // for answer no
//                        }
////                        else if (answers.getId() == 7) {
////                            for (Material material : materialList) {
////                                cakeWeight.setId(new Long(0));
////                                cakeWeight.setCakeid(material.getIngredientid().getCakeid());
////                                cakeWeight.setAnswerid(answers);
////                                cakeWeightClient.createCakeWeight_XML(cakeWeight, CakeWeight.class);
////                            }
////                        }
//                    }
//                } else if (questions.getId().intValue() == 3) {
//                    materialList = materialClient.getMaterialByName_XML(List.class, "unsalted");
//                    for (Answers answers : result.get(questions)) {
//                        // for answer yes
//                        if (answers.getId() == 8) {
//                            for (Material material : materialList) {
//                                cakeWeight.setId(new Long(0));
//                                cakeWeight.setCakeid(material.getIngredientid().getCakeid());
//                                cakeWeight.setAnswerid(answers);
//                                cakeWeightClient.createCakeWeight_XML(cakeWeight, CakeWeight.class);
//                            }
//                            // for answer no    
//                        } 
////                        else if (answers.getId() == 9) {
////                            for (Material material : materialList) {
////                                cakeWeight.setId(new Long(0));
////                                cakeWeight.setCakeid(material.getIngredientid().getCakeid());
////                                cakeWeight.setAnswerid(answers);
////                                cakeWeightClient.createCakeWeight_XML(cakeWeight, CakeWeight.class);
////                            }
////                        }
//                    }
//                } else if (questions.getId().intValue() == 4) {
//                    materialList = materialClient.getMaterialByName_XML(List.class, "milk");
//                    for (Answers answers : result.get(questions)) {
//                        // for answer yes
//                        if (answers.getId() == 10) {
//                            for (Material material : materialList) {
//                                cakeWeight.setId(new Long(0));
//                                cakeWeight.setCakeid(material.getIngredientid().getCakeid());
//                                cakeWeight.setAnswerid(answers);
//                                cakeWeightClient.createCakeWeight_XML(cakeWeight, CakeWeight.class);
//                            }
//                            // for answer no                                
//                        } 
////                        else if (answers.getId() == 11) {
////                            for (Material material : materialList) {
////                                cakeWeight.setId(new Long(0));
////                                cakeWeight.setCakeid(material.getIngredientid().getCakeid());
////                                cakeWeight.setAnswerid(answers);
////                                cakeWeightClient.createCakeWeight_XML(cakeWeight, CakeWeight.class);
////                            }
////                        }
//                    }
//                } else if (questions.getId().intValue() == 5) {
//                    List<Cake> listCakeAnswerID12 = new ArrayList<>();
//                    List<Cake> listCakeAnswerID13 = new ArrayList<>();
//                    List<Cake> listCakeAnswerID14 = new ArrayList<>();
//                    List<Cake> listCakeAnswerID15 = new ArrayList<>();
//                    for (Cake cake : cakeList) {
//                        if (0 < ConvertUtils.convertTimeToMinute(cake.getTime()) && ConvertUtils.convertTimeToMinute(cake.getTime()) <= 30) {
//                            listCakeAnswerID12.add(cake);
//                        } else if (30 < ConvertUtils.convertTimeToMinute(cake.getTime()) && ConvertUtils.convertTimeToMinute(cake.getTime()) <= 60) {
//                            listCakeAnswerID13.add(cake);
//                        } else if (60 < ConvertUtils.convertTimeToMinute(cake.getTime()) && ConvertUtils.convertTimeToMinute(cake.getTime()) <= 180) {
//                            listCakeAnswerID14.add(cake);
//                        } else {
//                            listCakeAnswerID15.add(cake);
//                        }
//                    }
//                    for (Answers answers : result.get(questions)) {
//                        if (answers.getId() == 12) {
//                            for (Cake cake : listCakeAnswerID12) {
//                                cakeWeight.setId(new Long(0));
//                                cakeWeight.setCakeid(cake);
//                                cakeWeight.setAnswerid(answers);
//                                cakeWeightClient.createCakeWeight_XML(cakeWeight, CakeWeight.class);
//                            }
//                        } else if (answers.getId() == 13) {
//                            for (Cake cake : listCakeAnswerID13) {
//                                cakeWeight.setId(new Long(0));
//                                cakeWeight.setCakeid(cake);
//                                cakeWeight.setAnswerid(answers);
//                                cakeWeightClient.createCakeWeight_XML(cakeWeight, CakeWeight.class);
//                            }
//                        } else if (answers.getId() == 14) {
//                            for (Cake cake : listCakeAnswerID14) {
//                                cakeWeight.setId(new Long(0));
//                                cakeWeight.setCakeid(cake);
//                                cakeWeight.setAnswerid(answers);
//                                cakeWeightClient.createCakeWeight_XML(cakeWeight, CakeWeight.class);
//                            }
//                        } else if (answers.getId() == 15) {
//                            for (Cake cake : listCakeAnswerID15) {
//                                cakeWeight.setId(new Long(0));
//                                cakeWeight.setCakeid(cake);
//                                cakeWeight.setAnswerid(answers);
//                                cakeWeightClient.createCakeWeight_XML(cakeWeight, CakeWeight.class);
//                            }
//                        }
//                    }
//                } else if (questions.getId().intValue() == 7) {
//                    materialList = materialClient.getMaterialByName_XML(List.class, "cream cheese");
//                    for (Answers answers : result.get(questions)) {
//                        if (answers.getId() == 18) {
//                            for (Material material : materialList) {
//                                cakeWeight.setId(new Long(0));
//                                cakeWeight.setCakeid(material.getIngredientid().getCakeid());
//                                cakeWeight.setAnswerid(answers);
//                                cakeWeightClient.createCakeWeight_XML(cakeWeight, CakeWeight.class);
//                            }
//                        } 
////                        else if (answers.getId() == 19) {
////                            for (Material material : materialList) {
////                                cakeWeight.setId(new Long(0));
////                                cakeWeight.setCakeid(material.getIngredientid().getCakeid());
////                                cakeWeight.setAnswerid(answers);
////                                cakeWeightClient.createCakeWeight_XML(cakeWeight, CakeWeight.class);
////                            }
////                        }
//                    }
//                }
//            }
//            System.out.println("DONE");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
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
