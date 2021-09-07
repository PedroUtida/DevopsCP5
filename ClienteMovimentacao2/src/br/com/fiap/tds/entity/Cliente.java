package br.com.fiap.tds.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_CLIENTE")
@SequenceGenerator(name="cliente", sequenceName="SQ_T_CLIENTE", allocationSize=1)
public class Cliente {

	@Id
	@Column(name="nr_cpf")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente")
	private int cpf;
	
	@Column(name="nr_rg", nullable=false)
	private int rg;
	
	@Column(name="nm_cliente", nullable=false, length=50)
	private String nome;
	
	@Column(name="dt_nascimento", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	@Column(name="ds_endereco", nullable=false, length=50)
	private String endereco;
	
	@Column(name="nr_celular", nullable=false)
	private int celular;
	
	@Column(name="nr_telefone_fixo", nullable=false)
	private int telefoneFixo;
	
	@Column(name="nm_email", nullable=false, length=30)
	private String email;
	
	@Column(name="nm_profissao", nullable=false, length=25)
	private String profissao;
	
	@Column(name="ds_renda", nullable=false)
	private double renda;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Movimentacao> movimentacoes;
	
	public Cliente() {}

	public Cliente(int rg, String nome, Calendar dataNascimento, String endereco, int celular, int telefoneFixo,
			String email, String profissao, double renda) {
		super();
		this.rg = rg;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.celular = celular;
		this.telefoneFixo = telefoneFixo;
		this.email = email;
		this.profissao = profissao;
		this.renda = renda;
	}

	public Cliente(int cpf, int rg, String nome, Calendar dataNascimento, String endereco, int celular,
			int telefoneFixo, String email, String profissao, double renda) {
		super();
		this.cpf = cpf;
		this.rg = rg;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.celular = celular;
		this.telefoneFixo = telefoneFixo;
		this.email = email;
		this.profissao = profissao;
		this.renda = renda;
	}

	public void addMovimentacao(Movimentacao movimentacao) {
		if (getMovimentacoes() == null)
			setMovimentacoes(new ArrayList<>());
		
		getMovimentacoes().add(movimentacao);
		movimentacao.setCliente(this);
	}
	
	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public int getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(int telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	
}
