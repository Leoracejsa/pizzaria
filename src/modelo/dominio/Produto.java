package modelo.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tab_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PRODUTO")
	@SequenceGenerator(name = "ID_PRODUTO", sequenceName = "SEQ_PRODUTO", allocationSize = 1)
	private Integer codigo;
	private String nomeproduto;
	private String descricao;
	private int qntproduto;
	private float valorproduto;

	@ManyToOne
	@JoinColumn(name = "id_categoria_fk")
	private Categoria categoria;

	
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomeproduto() {
		return nomeproduto;
	}

	public void setNomeproduto(String nomeproduto) {
		this.nomeproduto = nomeproduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQntproduto() {
		return qntproduto;
	}

	public void setQntproduto(int qntproduto) {
		this.qntproduto = qntproduto;
	}

	public float getValorproduto() {
		return valorproduto;
	}

	public void setValorproduto(float valorproduto) {
		this.valorproduto = valorproduto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nomeproduto=" + nomeproduto + ", descricao=" + descricao
				+ ", qntproduto=" + qntproduto + ", valorproduto=" + valorproduto + ", categoria=" + categoria + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nomeproduto == null) ? 0 : nomeproduto.hashCode());
		result = prime * result + qntproduto;
		result = prime * result + Float.floatToIntBits(valorproduto);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nomeproduto == null) {
			if (other.nomeproduto != null)
				return false;
		} else if (!nomeproduto.equals(other.nomeproduto))
			return false;
		if (qntproduto != other.qntproduto)
			return false;
		if (Float.floatToIntBits(valorproduto) != Float.floatToIntBits(other.valorproduto))
			return false;
		return true;
	}

	
	
	
	

}
