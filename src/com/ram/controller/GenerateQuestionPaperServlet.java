package com.ram.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ram.dao.QuestionDao;
import com.ram.model.Criteria;
import com.ram.model.Question;
import com.ram.service.QuestionPaperGeneratorService;

/**
 * Servlet implementation class GenerateQuestionPaperServlet
 */
@WebServlet("/generate")
public class GenerateQuestionPaperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private QuestionDao questionDao = new QuestionDao();

	private QuestionPaperGeneratorService questionPaperGeneratorService = new QuestionPaperGeneratorService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		generate(request, response);
	}
	
	private void generate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("show by criteria");
		String jsonBody = getTemplateJsonStringFromRequest(req);
		System.out.println(jsonBody);

		List<Question> listQuestion = questionDao.findAll();
		Set<Question> generateQuestionSet = questionPaperGeneratorService.generateQuestionPaper(listQuestion,
				fromJsonToCriteriaTemplate(jsonBody));

		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.append(toQuestionSetToJson(generateQuestionSet));
		out.close();
	}

	private String getTemplateJsonStringFromRequest(HttpServletRequest req) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = req.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String requestBody = sb.toString();
		return requestBody;
	}

	private List<Criteria> fromJsonToCriteriaTemplate(String templateJsonStr) {
		Gson gson = new Gson();
		Criteria[] fromJson = gson.fromJson(templateJsonStr, Criteria[].class);
		List<Criteria> template = Arrays.asList(fromJson);
		// System.out.println(template);
		return template;
	}

	private String toQuestionSetToJson(Set<Question> generateQuestionSet) {
		Gson gson = new Gson();
		String json = gson.toJson(generateQuestionSet);
		return json;
	}

}
