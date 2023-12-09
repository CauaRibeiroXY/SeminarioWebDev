package com.seminario.livros;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
/**
 * @author cauaq
 */
@Named
@RequestScoped
public class LivroController {

    @Inject
    private LivroBeanLocal livroBean;
    private String termoPesquisa;
    private Livro novoLivro = new Livro();
    
   private List<Livro> listaLivrosFiltrada;
    
    private List<Livro> listaLivros;

    public String getTermoPesquisa() {
        return termoPesquisa;
    }

    public void setTermoPesquisa(String termoPesquisa) {
        this.termoPesquisa = termoPesquisa;
    }

    public List<Livro> getListaLivrosFiltrada() {
        return listaLivrosFiltrada;
    }

    public void setListaLivrosFiltrada(List<Livro> listaLivrosFiltrada) {
        this.listaLivrosFiltrada = listaLivrosFiltrada;
    }
    

    public Livro getNovoLivro() {
        return novoLivro;
    }
    
    public List<Livro> getListaLivros() {
        if (listaLivros == null) {
            listaLivros = livroBean.getListaLivros();
        }
        return listaLivros;
    }

    public void setNovoLivro(Livro novoLivro) {
        this.novoLivro = novoLivro;
    }

    public void cadastrarLivro() {
        livroBean.salvar(novoLivro);
        novoLivro = new Livro(); // Limpar para o próximo cadastro
    }
    
    public void removerLivro(Livro livro) {
        livroBean.excluir(livro);
        // Recarrega a lista após a remoção para refletir as mudanças
        listaLivros = livroBean.getListaLivros();
    }
    
@PostConstruct
    public void carregarListaLivros() {
        listaLivros = livroBean.getListaLivros();

        // Filtrar a lista de acordo com o termo de pesquisa
        if (termoPesquisa != null && !termoPesquisa.isEmpty()) {
            listaLivrosFiltrada = new ArrayList<>();
            for (Livro livro : listaLivros) {
                if (livro.getTitulo().toLowerCase().contains(termoPesquisa.toLowerCase()) ||
                    livro.getAutor().toLowerCase().contains(termoPesquisa.toLowerCase())) {
                    listaLivrosFiltrada.add(livro);
                }
            }
        } else {
            listaLivrosFiltrada = listaLivros; // Sem filtro, exibir todos os livros
        }
    }
    
    // Métodos adicionais conforme necessário
}