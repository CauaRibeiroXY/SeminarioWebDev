package com.seminario.livros;

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

    private Livro novoLivro = new Livro();
    
    
    private List<Livro> listaLivros;
    

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
    }
    // Métodos adicionais conforme necessário
}