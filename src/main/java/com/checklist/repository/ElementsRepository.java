package com.checklist.repository;

import com.checklist.domain.ListElement;
import org.springframework.data.repository.CrudRepository;

public interface ElementsRepository extends CrudRepository<ListElement, Integer> {
}
