package Demoproject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@Entity
@XStreamAlias("Veiculo")
public class Veiculo {
	@Id
	String nomeCliente;
    String marcaModeloVeiculo;
    int  anoModelo;
    double valorVenda;
    Date dataPublicacao;
	
    public Veiculo() {
		super();
	}

	public Veiculo(String nomeCliente, String marcaModeloVeiculo, int anoModelo, double valorVenda,
			Date dataPublicacao) {
		super();
		
		this.nomeCliente = nomeCliente;
		this.marcaModeloVeiculo = marcaModeloVeiculo;
		this.anoModelo = anoModelo;
		this.valorVenda = valorVenda;
		this.dataPublicacao = dataPublicacao;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getMarcaModeloVeiculo() {
		return marcaModeloVeiculo;
	}

	public void setMarcaModeloVeiculo(String marcaModeloVeiculo) {
		this.marcaModeloVeiculo = marcaModeloVeiculo;
	}

	public int getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
}
