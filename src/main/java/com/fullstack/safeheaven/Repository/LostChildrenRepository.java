package com.fullstack.safeheaven.Repository;

import com.fullstack.safeheaven.entity.LostChildren;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LostChildrenRepository extends JpaRepository<LostChildren, Integer> {
    List<LostChildren> findByName(String name);
}
