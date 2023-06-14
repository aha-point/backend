package com.ahaPoint.common.domain;

import com.ahaPoint.store.domain.Store;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@Table(name = "image", catalog = "aha_point")
@Getter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderMethodName = "entityBuilder", toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Image {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String represent;
    private String url;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne()
    @JoinColumn(name = "IMAGE_ID", insertable = false, updatable = false)
    private Store store;

}
