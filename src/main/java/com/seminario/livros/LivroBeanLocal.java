package com.seminario.livros;

import javax.ejb.Local;

/**
 *
 * @author cauaq
 */
@Local
public interface LivroBeanLocal {
    
    public Livro localizarPorId(Long id);
    public void salvar(Livro Livro);
    public Livro SelectLivro(Long id);
    public void Excluir(Livro livro);
    
}