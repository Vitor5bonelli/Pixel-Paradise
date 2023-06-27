package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util;

import java.util.List;
import java.util.Optional;

public interface Repository<K, E> {
    void save(E entityDTO);

    Optional<E> findOneByKey(K key);

    List<E> findAll();

    void update(E entityDTO);

    void deleteByKey(K key);

    boolean existsByKey(K key);
}
