package com.br.fatecrl.conta.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;

public interface IController<T> {
   ResponseEntity<List<T>> getAll();
   ResponseEntity<?> get(Long id);
   ResponseEntity<T> post(T obj);
   ResponseEntity<?> put(T obj);
   ResponseEntity<?> patch(T obj);
   ResponseEntity<?> delete(Long id);
}
