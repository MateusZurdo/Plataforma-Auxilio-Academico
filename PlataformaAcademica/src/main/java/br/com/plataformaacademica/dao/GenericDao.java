package br.com.plataformaacademica.dao;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.plataformaacademica.domain.Usuario;
import br.com.plataformaacademica.util.HibernateUtil;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class GenericDao<Entidade> {

	private Class<Entidade> classe;

	public GenericDao() {

		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
		} catch (Exception e) {

			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}
	}

	public List<Entidade> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		try {

			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();

			return resultado;
		} catch (Exception e) {

			throw e;

		} finally {
			sessao.close();
		}
	}

	public Entidade buscar(long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		try {
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			Entidade resultado = (Entidade) consulta.uniqueResult();

			return resultado;
		} catch (RuntimeException erro) {

			throw erro;

		} finally {
			sessao.close();
		}
	}

	public void excluir(Entidade entidade) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null; // Objeto que garante que todas as transações sejam executadas

		try {
			transacao = sessao.beginTransaction();

			sessao.delete(entidade);

			transacao.commit();

		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}

	public void editar(Entidade entidade) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null; // Objeto que garante que todas as transações sejam executadas

		try {
			transacao = sessao.beginTransaction();

			sessao.update(entidade);

			transacao.commit();

		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}

	public void merge(Entidade entidade) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null; // Objeto que garante que todas as transações sejam executadas

		try {
			transacao = sessao.beginTransaction();

			sessao.merge(entidade);

			transacao.commit();

		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}

	public void mergeWithReturn(Entidade entidade) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null; // Objeto que garante que todas as transações sejam executadas

		try {
			transacao = sessao.beginTransaction();

			sessao.merge(entidade);

			transacao.commit();

		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {

			sessao.close();
		}
	}
}
