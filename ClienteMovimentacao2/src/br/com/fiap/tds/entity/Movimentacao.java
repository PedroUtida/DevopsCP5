package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_MOVIMENTACAO")
@SequenceGenerator(name="movimentacao", sequenceName="SQ_T_MOVIMENTACAO", allocationSize=1)
public class Movimentacao {

	@Id
	@Column(name="cd_sequencia")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="movimentacao")
	private int sequencia;
	
	@Column(name="dt_movimentacao", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar dataMovimentacao;
	
	@Column(name="nr_agencia", nullable=false)
	private int agencia;
	
	@Column(name="nr_conta", nullable=false)
	private int conta;
	
	@Column(name="nr_documento", nullable=false)
	private int documento;
	
	@Column(name="vl_operacao", nullable=false)
	private double operacao;
	
	@Column(name="ds_tipo", nullable=false)
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name="nr_cpf")
	private Cliente cliente;
	
	public Movimentacao() {}

	public Movimentacao(Calendar dataMovimentacao, int agencia, int conta, int documento, double operacao,
			String tipo) {
		super();
		this.dataMovimentacao = dataMovimentacao;
		this.agencia = agencia;
		this.conta = conta;
		this.documento = documento;
		this.operacao = operacao;
		this.tipo = tipo;
	}

	public Movimentacao(int sequencia, Calendar dataMovimentacao, int agencia, int conta, int documento,
			double operacao, String tipo) {
		super();
		this.sequencia = sequencia;
		this.dataMovimentacao = dataMovimentacao;
		this.agencia = agencia;
		this.conta = conta;
		this.documento = documento;
		this.operacao = operacao;
		this.tipo = tipo;
	}

	public int getSequencia() {
		return sequencia;
	}

	public void setSequencia(int sequencia) {
		this.sequencia = sequencia;
	}

	public Calendar getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(Calendar dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public double getOperacao() {
		return operacao;
	}

	public void setOperacao(double operacao) {
		this.operacao = operacao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
