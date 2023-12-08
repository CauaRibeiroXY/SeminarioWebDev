package com.seminario.livros;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.faces.application.ResourceDependency;

/**
 *
 * @author cauaq
 */
@ResourceDependency(name="jsf.js")
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
    public Livro SelectLivro(Long id){
            Livro l = em.find(Livro.class, id);
            em.close();
            return l;
    }
    
    @Override
    public void Excluir(Livro livro){
        em.remove(livro); 
    }

}