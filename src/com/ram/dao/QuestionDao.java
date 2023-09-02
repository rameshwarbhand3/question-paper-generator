package com.ram.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ram.model.Category;
import com.ram.model.Complexity;
import com.ram.model.Question;

public class QuestionDao extends BaseDao{

	private static final String INSERT_QUESTION = "insert into questionBank"
			+ "(SrNo,Question,optionA,optionB,optionC,OptionD,CorrectAns,Category,Complexity)values"
			+ "(null,?,?,?,?,?,?,?,?)";

	private static final String SELECT_QUESTION = "select * from questionBank where srNo=?";

	private static final String SELECT_ALL_QUESTIONS = "select * from questionBank";

	private static final String UPDATE_QUESTION = "update questionBank set Question=?,optionA=?,optionB=?,optionC=?,optionD=?,correctAns=?,Category=?,complexity=? where srNo=?";

	private static final String DELETE_QUESTION = "delete from questionBank where srNo=?";

	private static final String FIND_BY_CATEGORY_QUESTION = "select * from questionBank where category=?";

	private static final String FIND_BY_COMPLEXITY_QUESTION = "select * from questionBank where complexity=?";

	public Question findById(int id) {
		try (Connection connection = getConnection();
				PreparedStatement pst = connection.prepareStatement(SELECT_QUESTION)) {
			pst.setInt(1, id);
			List<Question> questions = processResultSet(pst);
			if (!questions.isEmpty()) {
				return questions.get(0);
			}
			System.out.println("Question with srno " + id + " not found ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Question> findAll() {
		try (Connection connection = getConnection();
				PreparedStatement pst = connection.prepareStatement(SELECT_ALL_QUESTIONS)) {
			return processResultSet(pst);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Question>();
	}

	public List<Question> findByCategory(String questionByCategory) {
		try (Connection connection = getConnection();
				PreparedStatement pst = connection.prepareStatement(FIND_BY_CATEGORY_QUESTION)) {
			pst.setString(1, questionByCategory);
			return processResultSet(pst);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public List<Question> findByComplexity(String questionByComplexity) {
		try (Connection connection = getConnection();
				PreparedStatement pst = connection.prepareStatement(FIND_BY_COMPLEXITY_QUESTION)) {
			pst.setString(1, questionByComplexity);
			return processResultSet(pst);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<Question> processResultSet(PreparedStatement pst) throws SQLException {
		List<Question> listQuestion = new ArrayList<>();
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			int srno = rs.getInt("srno");
			String question = rs.getString("question");
			String optionA = rs.getString("optionA");
			String optionB = rs.getString("optionB");
			String optionC = rs.getString("optionC");
			String optionD = rs.getString("optionD");
			String correctAns = rs.getString("correctAns");
			String category = rs.getString("category");
			String complexity = rs.getString("complexity");
			Question q = new Question();
			q.setSrno(srno);
			q.setQuestion(question);
			q.setOption1(optionA);
			q.setOption2(optionB);
			q.setOption3(optionC);
			q.setOption4(optionD);
			q.setCorrectAns(correctAns);
			q.setComplexity(Complexity.valueOf(complexity));
			q.setType(Category.valueOf(category));
			listQuestion.add(q);
		}
		return listQuestion;
	}

	public void insert(Question question) {
		try (Connection connection = getConnection();
				PreparedStatement pst = connection.prepareStatement(INSERT_QUESTION)) {
			pst.setString(1, question.getQuestion());
			pst.setString(2, question.getOption1());
			pst.setString(3, question.getOption2());
			pst.setString(4, question.getOption3());
			pst.setString(5, question.getOption4());
			pst.setString(6, question.getCorrectAns());
			pst.setString(7, question.getCategory().name());
			pst.setString(8, question.getComplexity().name());

			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Question question) {
		try (Connection connection = getConnection();
				PreparedStatement pst = connection.prepareStatement(UPDATE_QUESTION)) {

			pst.setString(1, question.getQuestion());
			pst.setString(2, question.getOption1());
			pst.setString(3, question.getOption2());
			pst.setString(4, question.getOption3());
			pst.setString(5, question.getOption4());
			pst.setString(6, question.getCorrectAns());
			pst.setString(7, question.getCategory().name());
			pst.setString(8, question.getComplexity().name());
			pst.setInt(9, question.getSrno());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteQuestion(int srno) {
		try (Connection connection = getConnection();
				PreparedStatement pst = connection.prepareStatement(DELETE_QUESTION);) {
			pst.setInt(1, srno);
			pst.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
