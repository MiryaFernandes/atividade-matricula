package br.senai.sp.jandira.app;

import br.senai.sp.jandira.model.Aluno;
import br.senai.sp.jandira.model.Periodo;
import br.senai.sp.jandira.repository.AlunoRepository;

public class App {

	public static void main(String[] args) {
		
	
		
		AlunoRepository ds1t = new AlunoRepository(8);
		
		Aluno flor = new Aluno();
		flor.setNome("Florbela da Silva");
		flor.setMatricula("00001");
		flor.setPeriodo(Periodo.TARDE);
		ds1t.gravar(flor, 0);
		
		Aluno lukas = new Aluno();
		lukas.setNome("Lukas Gomes");
		lukas.setMatricula("00002");
		lukas.setPeriodo(Periodo.TARDE);
		ds1t.gravar(lukas, 1);
		
		System.out.println(ds1t.listarAluno(1).getNome());
		System.out.println(ds1t.listarAluno(1).getMatricula());
		
		System.out.println(ds1t.listarAluno(0).getNome());
		System.out.println(ds1t.listarAluno(0).getPeriodo());
		
		for (int i = 0; i < ds1t.listarTodos().length; i++);
		
				

	}
	

}
