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
}
