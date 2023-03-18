package com.ahaPoint.store.domain;

import com.ahaPoint.sysUser.domain.SysUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@Table(name = "store", catalog = "aha_point")
@Getter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderMethodName = "entityBuilder", toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Store {

    @Id @Column(name = "sys_id")
    private Long id; // sysUser의 pk
    @NotBlank
    private String storeName; // 상호명
    @NotBlank
    private String storePhoneNumber; // 가게번호
    @NotBlank
    private String storeAddress; // 가게 주소
    private String storeZipCode; // 가게 우편번호
    private Long storeImageId; // 가게 이미지

    private Integer pointPercentage; // 포인트 퍼센트
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    /* ============ <연관관계> ============ */
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sysId", insertable = false, updatable = false)
    private SysUser sysUser;

    public void setId(Long id) { // sysUser의 Id 값을 넣어서 save한다.
        this.id = id;
    }
}
