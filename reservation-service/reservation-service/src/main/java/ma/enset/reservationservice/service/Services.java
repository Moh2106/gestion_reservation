package ma.enset.reservationservice.service;

import ma.enset.reservationservice.dtos.PersonneDTO;

import java.util.List;

public interface Services<T> {
    List<T> findAll();
    T findById(Long id);
    T save(T t);
    T update(Long id, T t);
    void delete(Long id);
}
