package com.seminario.livros;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @author cauaq
 */
@Named
@Stateless
public class LivroBean implements LivroBeanLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Livro localizarPorId(Long id) {
        return em.find(Livro.class, id);
    }

    @Override
    public void salvar(Livro livro) {
        em.merge(livro);
    }

    @Override
    public Livro selectLivro(Long id) {
        return em.find(Livro.class, id);
    }

    @Override
    public void excluir(Livro livro) {
        em.remove(em.merge(livro));
    }
    
    @Override
    public List<Livro> getListaLivros() {
        TypedQuery<Livro> query = em.createQuery("SELECT l FROM Livro l", Livro.class);
        return query.getResultList();
    }
}