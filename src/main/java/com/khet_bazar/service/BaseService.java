package com.khet_bazar.service;

import com.khet_bazar.entity.BaseEntity;
import com.khet_bazar.repository.BaseRepository;
import com.khet_bazar.utils.Context;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Slf4j
@Getter
@RequiredArgsConstructor
public abstract class BaseService<E extends BaseEntity> {
    public final BaseRepository<E> repository;

    @Transactional
    public E create(E entity) {
        return repository.save(entity);
    }

    @Transactional
    public E get(Long id) {
        return getRepository().findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Entity not found with Id %d", id)));
    }

    @Transactional
    public E update(Long id, E updatedEntity) {
        E existingEntity = getRepository().findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Entity not found with Id %d", id)));

        BeanUtils.copyProperties(updatedEntity, existingEntity, "id", "createdAt");
        return repository.save(existingEntity);
    }

    @Transactional
    public E delete(Long id) {
        E entity = getRepository().findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Entity not found with Id %d", id)));

        entity.setDeletedAt(LocalDateTime.now());
        entity.setDeletedBy(Context.getUserId());
        return repository.save(entity);
    }
}