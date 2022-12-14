package service;

import java.util.ArrayList;
import java.util.List;

import model.*;
public class PessoaService {

	private static List<PessoaModel> pessoas = new ArrayList<PessoaModel>();
	
	public void addPessoa(PessoaModel pessoa) {
		pessoa.setId(System.currentTimeMillis());
		this.pessoas.add(pessoa);
	}
	public List<PessoaModel>getPessoas(){
		return this.pessoas;
	}
	public PessoaModel getPessoa(Long id) {
		if(this.pessoas.isEmpty()) {
			return null;
		}
		for (PessoaModel p: this.pessoas) {
			if(p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}
}
