package Model.BO;

import Model.DAO.ValidEmailDAO;

public class ValidEmailBO {
	public boolean validEmail(String email) {
		ValidEmailDAO validEmailDAO = new ValidEmailDAO();
		return validEmailDAO.validEmail(email);
	}
	public int validAcc(String email,String username) {
		ValidEmailDAO validEmailDAO = new ValidEmailDAO();
		return validEmailDAO.validAcc(email, username);
	}
}