package com.example.review.product.config;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.example.review.product.config.ProductConfig.Role.PUBLIC;
import static java.util.Objects.requireNonNullElse;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
public class ProductConfig {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Long productId;
    private Boolean visible;
    private Boolean commentable;
    private Boolean votable;
    @Enumerated(EnumType.STRING)
    private Role commenterRole;
    @Enumerated(EnumType.STRING)
    private Role voterRole;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    @Builder
    public ProductConfig(Long productId,
                         Boolean visible,
                         Boolean commentable,
                         Boolean votable,
                         Role commenterRole,
                         Role voterRole) {
        this.productId = productId;
        this.visible = visible;
        this.commentable = commentable;
        this.votable = votable;
        this.commenterRole = requireNonNullElse(commenterRole, PUBLIC);
        this.voterRole = requireNonNullElse(voterRole, PUBLIC);
    }

    @PreUpdate
    protected void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public enum Role {
        PUBLIC,
        BUYERS;
    }
}
