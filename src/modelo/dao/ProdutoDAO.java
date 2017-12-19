package modelo.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import modelo.dominio.Categoria;
import modelo.dominio.Produto;

public class ProdutoDAO extends JpaDAO<Produto> {

	public List<Produto> filtrarProdutos(Categoria cat, String descricao) {
		String jpql = "from Produto f  ";

		if (cat != null) {
			jpql = jpql + " where p.categoria = :categ";
		} else if (descricao != null) {
			jpql = jpql + " where p.descricao like :descricao";
		}

		jpql = jpql + " order by p.descricao";

		TypedQuery<Produto> comando = this.getEntityManager().createQuery(jpql, Produto.class);

		if (cat != null)
			comando.setParameter("categ", cat);
		else if (descricao != null)
			comando.setParameter("descricao", "%" + descricao + "%");

		return comando.getResultList();
	}


}
