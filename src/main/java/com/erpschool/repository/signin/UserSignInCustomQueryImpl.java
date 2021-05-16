package com.erpschool.repository.signin;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.erpschool.model.signin.UserSignInDtls;

@Component
@Transactional
public class UserSignInCustomQueryImpl implements UserSignInCustomQueryInterface {

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public UserSignInDtls getUserAccessInfo(String uname) {

		String getUserName = "select * from logindtls where username = ?";
		Query query = em.createNativeQuery(getUserName);
		query.setParameter(1, uname);
		List<Object[]> getUserSignInData = query.getResultList();

		if (getUserSignInData.size() > 0) {
			System.out.println("getUserSignInData...." + getUserSignInData.size());
			UserSignInDtls userSignInDtls = new UserSignInDtls();

			for (Object[] obj : getUserSignInData) {
				userSignInDtls.setId(Integer.parseInt(obj[0].toString()));
				userSignInDtls.setUsername(obj[1].toString());
				userSignInDtls.setPassword(obj[2].toString());
			}
			return userSignInDtls;
		} 
		else
		  return null;

	}

	@Override
	public String getUserEncryptPass(String uname) {

		String getUserEncryptPassword = "select password from logindtls where username = ?";
		Query query1 = em.createNativeQuery(getUserEncryptPassword);
		query1.setParameter(1, uname);
		String getUserEncryptionPass = (String) query1.getSingleResult();
		return getUserEncryptionPass;
	}
}
