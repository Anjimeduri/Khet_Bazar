package com.khet_bazar.entity;

import com.khet_bazar.utils.Context;
import com.khet_bazar.utils.IdGenerator;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ParamDef;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@FilterDef(name = "notDeletedFilter", defaultCondition = "deleted_at IS NULL")
@FilterDef(name = "namespaceFilter", defaultCondition = "deleted_at IS NULL", parameters = @ParamDef(name = "namespaceId", type = String.class))
public abstract class BaseEntity implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @GenericGenerator(name = "id_generator", type = IdGenerator.class)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Column(name = "namespace_id")
    protected String namespaceId;

    @Column(name = "created_at", updatable = false, nullable = false)
    protected LocalDateTime createdAt;

    @Column(name = "updated_at")
    protected LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    protected LocalDateTime deletedAt;

    @Column(name = "created_by", updatable = false)
    protected String createdBy;

    @Column(name = "updated_by")
    protected String updatedBy;

    @Column(name = "deleted_by")
    protected String deletedBy;

    @Version
    @Column(name = "version")
    protected Long version;

    @PrePersist
    protected void onCreate() {
        namespaceId = Context.getNameSpace();
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
        this.updatedAt = this.createdAt;

        if (Objects.isNull(this.createdBy)) {
            this.createdBy = getCurrentUser();
        }
        this.updatedBy = this.createdBy;
    }

    @PreUpdate
    protected void onUpdate() {
        namespaceId = Context.getNameSpace();
        this.updatedAt = LocalDateTime.now();
        if (Objects.isNull(this.updatedBy)) {
            this.updatedBy = getCurrentUser();
        }
    }

    private String getCurrentUser() {
        return Context.getUserId() != null ? Context.getUserId() : "System";
    }
}