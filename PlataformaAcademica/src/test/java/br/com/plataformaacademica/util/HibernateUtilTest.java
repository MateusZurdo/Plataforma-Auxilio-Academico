package br.com.plataformaacademica.util;

import org.hibernate.Session;
import org.junit.Test;

import br.com.plataformaacademica.domain.Aluno;
import br.com.plataformaacademica.util.HibernateUtil;

public class HibernateUtilTest {
	@Test
	public void conectar() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.close();
		HibernateUtil.getSessionFactory().close();
	}
}
