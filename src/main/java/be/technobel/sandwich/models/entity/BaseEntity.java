package be.technobel.sandwich.models.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter @Setter
@MappedSuperclass
public abstract class BaseEntity<TID> {

    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;

    public abstract TID getId();

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        lastModifiedAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity<?> that = (BaseEntity<?>) o;
        return this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        int result = createdAt != null ? createdAt.hashCode() : 0;
        result = 31 * result + (lastModifiedAt != null ? lastModifiedAt.hashCode() : 0);
        return result;
    }
}
