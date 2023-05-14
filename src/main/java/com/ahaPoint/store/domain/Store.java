package com.ahaPoint.store.domain;

import com.ahaPoint.sysUser.domain.SysUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "store", catalog = "aha_point")
@Getter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderMethodName = "entityBuilder", toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Store {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // store pk
    @Column(name = "sys_id")
    private Long sysId; // sysUser의 pk
    @NotBlank
    private String storeName; // 상호명
    @Email
    private String email; // 이메일
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
    @JoinColumn(name = "sys_id", insertable = false, updatable = false)
    private SysUser sysUser;

    @OneToOne(fetch = FetchType.LAZY, optional = false, mappedBy = "store")
    private StoreDtlInfo storeDtlInfo;

    @OneToOne(fetch = FetchType.LAZY, optional = false, mappedBy = "store")
    private StoreDtlInfo storeDtlInfra;

    @OneToMany(mappedBy = "store")
    private List<StoreDtlMenu> storeDtlMenu;

    @OneToMany(mappedBy = "store")
    private List<StoreDtlMenu> storeDtlMenuList;

    @OneToMany(mappedBy = "store")
    private List<StoreCategory> storeCategoryList;

    public void setSysId(Long id) { // sysUser의 Id 값을 넣어서 save한다.
        this.sysId = id;
    }
}
