package com.seminario.livros;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cauaq
 */
public interface LivroBeanLocal {

    Livro localizarPorId(Long id);

    void salvar(Livro livro);

    Livro selectLivro(Long id);

    void excluir(Livro livro);
    
    List<Livro> getListaLivros();

}