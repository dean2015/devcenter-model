package cn.devcenter.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface CurdTemplate<T> {

    T save(T object);

    <E> Page<T> find(E condition, Pageable pageable);

    T findById(Serializable id);

    Serializable delete(Serializable id);

    Serializable update(T object);

}
