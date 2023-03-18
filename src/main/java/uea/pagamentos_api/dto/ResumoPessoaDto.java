package uea.pagamentos_api.dto;

public class ResumoPessoaDto {
	private Long codigo;
    private String nome;
    private Boolean ativo;
	
    public ResumoPessoaDto() {
		super();
		
	}

	public ResumoPessoaDto(Long codigo, String nome, Boolean ativo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.ativo = ativo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
    
    
	
    
    

}
