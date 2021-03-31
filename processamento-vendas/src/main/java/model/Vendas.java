package model;

import java.math.BigDecimal;

public class Vendas {
	private long operacao;
	private long cliente;
	private Integer quantidadeImpressos;
	private BigDecimal valorTotal;
	private String status;
	
	public Vendas() {}
		
	public Vendas(Long operacao, Long cliente, Integer quantidadeImpressos, BigDecimal valorTotal) {
		super();
		this.operacao = operacao;
		this.cliente = cliente;
		this.quantidadeImpressos = quantidadeImpressos;
		this.valorTotal = valorTotal;
	}
	
	public Long getOperacao() {
		return operacao;
	}
	
	public void setOperacao(Long operacao) {
		this.operacao = operacao;
	}
	
	public Long getCliente() {
		return cliente;
	}
	
	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}
	
	public Integer getQuantidadeImpressos() {
		return quantidadeImpressos;
	}
	
	public void setQuantidadeImpressos(Integer quantidadeImpressos) {
		this.quantidadeImpressos = quantidadeImpressos;
	}
	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Vendas [operacao=" + operacao + ", cliente=" + cliente + ", quantidadeImpressos=" + quantidadeImpressos
				+ ", valorTotal=" + valorTotal + ", status=" + status + "]";
	}

}