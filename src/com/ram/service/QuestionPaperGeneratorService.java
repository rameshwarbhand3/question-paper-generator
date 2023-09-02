package com.ram.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import com.ram.model.Category;
import com.ram.model.Complexity;
import com.ram.model.Criteria;
import com.ram.model.Question;

public class QuestionPaperGeneratorService {

	public Set<Question> generateQuestionPaper(List<Question> list, List<Criteria> template) {
		Set<Question> finalQuestionPaperSet = new HashSet<>();
		for (Criteria criteria : template) {
			final List<Question> questionsByCategory = getQuestionByCategory(criteria.getCategory(), list);
			List<Question> questionsByCategoryAndComplexity = getQuestionByComplexity(criteria.getComplexity(),
					questionsByCategory);
			for (int i = 0; i < criteria.getNoOfQuestion() && !questionsByCategoryAndComplexity.isEmpty(); i++) {
				int index = (int) ((Math.random()) * questionsByCategoryAndComplexity.size());
				final Question question = questionsByCategoryAndComplexity.remove(index);
				final boolean isAdded = finalQuestionPaperSet.add(question);
				// Duplicate check might require in case someone sends the duplicate Criteria
				// with different noOfQuestions.
				if (!isAdded) {
					i--;
				}
			}
		}
		return finalQuestionPaperSet;
	}

	private List<Question> getQuestionByCategory(Category category, List<Question> questionsList) {
		List<Question> lCategory = new ArrayList<>();
		for (Question q1 : questionsList) {
			if (q1.getCategory() == category) {
				lCategory.add(q1);
			}
		}

		return lCategory;
	}

	private List<Question> getQuestionByComplexity(Complexity complexity, List<Question> questionsList) {
//        List<Question>lComplexity = new ArrayList<>();
//        for(Question q2 : questionsList){
//            if(q2.getComplexity()==complexity){
//                lComplexity.add(q2);
//            }
//        }
//        return lComplexity;
		return questionsList.stream().filter((Question q) -> q.getComplexity() == complexity)
				.collect(Collectors.toList());

	}
}
