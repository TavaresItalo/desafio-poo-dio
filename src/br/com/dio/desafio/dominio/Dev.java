package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
	private Scanner leitor = new Scanner(System.in);
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    private double totalXp = 0;

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        double soma = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calcularXp();
            soma += next;
        }
        totalXp += soma;
        return totalXp;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }
    
    public void realizarTesteConhecimento(TesteConhecimento teste) {
    	int acertos = 0;
    	int i = 0;
    	
    	for(String pergunta : teste.getPerguntas() ) {
    		
    		System.out.println(pergunta);
    		System.out.println("Digite sua resposta [V]-verdadeiro ou [F]-falso: ");
    		String respostaDev = leitor.next();
    		
    		if(respostaDev.equals(teste.getRespostas().get(i))) {
    			acertos++;
    		}
    		
    		i++;
    	}
    	
    	if(acertos >= teste.getAcertos()) {
    		teste.setSituação("Aprovado");
    		adicionaXpTeste(teste.getXpTeste());
    	} else {
    		teste.setSituação("Reprovado");
    	}
    	
    	System.out.println("Você foi " + teste.getSituação() + "no teste de conhecimento");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }

	public double getTotalXp() {
		return totalXp;
	}

	public void setTotalXp(double totalXp) {
		this.totalXp = totalXp;
	}
    
	private void adicionaXpTeste(double xpTeste) {
		this.totalXp = this.getTotalXp() + xpTeste;
	}
    
}
