package com.checklist.repository;

import com.checklist.domain.Checklist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChecklistRepos extends CrudRepository<Checklist, Integer> {

    List<Checklist> findByNameContaining(String name);
}