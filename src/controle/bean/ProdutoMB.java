package controle.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import modelo.dao.CategoriaDAO;
import modelo.dao.ProdutoDAO;
import modelo.dominio.Categoria;
import modelo.dominio.Produto;

@ManagedBean(name = "produtoMB")
@RequestScoped
public class ProdutoMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{logimMB}")
	private LoginMB logimMB;

	private Produto produto = new Produto();

	private Categoria filtroCategoria = null;
	private String filtroDescricao = null;

	private ProdutoDAO dao = new ProdutoDAO();

	private List<Produto> produtos = null;

	private List<Categoria> categorias = null;
	
	
	public String getContador()
	{
		String descricao = this.produto.getDescricao();
		if (descricao == null)
			return "0";
		
		return String.valueOf(descricao.length());
	}

	public List<Produto> getProdutos() {

		if (this.produtos == null)
			this.produtos = this.dao.lerTodos();

		return produtos;
	}

	public List<Categoria> getCategorias() {

		if (this.categorias == null)
			this.categorias = new CategoriaDAO().lerTodos();

		return categorias;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Categoria getFiltroCategoria() {
		return filtroCategoria;
	}

	public void setFiltroCategoria(Categoria filtroCategoria) {
		this.filtroCategoria = filtroCategoria;
	}

	public String getFiltroDescricao() {
		return filtroDescricao;
	}

	public void setFiltroDescricao(String filtroDescricao) {
		this.filtroDescricao = filtroDescricao;
	}

	public LoginMB getLogimMB() {
		return logimMB;
	}

	public void setLogimMB(LoginMB logimMB) {
		this.logimMB = logimMB;
	}

	public String acaoListar() {
		return "produtoListar.jsf?faces-redirect=true";
	}

	public String acaoPesquisar() {

		this.produtos = this.dao.filtrarProdutos(filtroCategoria, filtroDescricao);

		return "produtoListar.jsf";
	}

	public String acaoAbrirInclusao() {

		this.produto = new Produto();

		return "produtoEditar.jsf";
	}

	public String acaoAbrirAlteracao(Integer codigo) {

		this.produto = dao.lerPorId(codigo);

		return "produtoEditar.jsf";
	}

	public String acaoExcluir(Integer codigo) {

		// ler objeto do banco
		this.produto = dao.lerPorId(codigo);

		this.dao.excluir(this.produto);

		return acaoListar();
	}

	public String acaoSalvar() {

		this.dao.salvar(this.produto);

		return acaoListar();
	}

	public String acaoCancelar() {

		return acaoListar();
	}
}
