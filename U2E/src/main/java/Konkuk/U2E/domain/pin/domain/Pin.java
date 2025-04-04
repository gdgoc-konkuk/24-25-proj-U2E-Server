package Konkuk.U2E.domain.pin.domain;

import Konkuk.U2E.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pins")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Pin extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pin_id")
    private Long pinId;

    @Column(name = "pin_color", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private PinColor pinColor;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @Builder
    public Pin(PinColor pinColor, Region region) {
        this.pinColor = pinColor;
        this.region = region;
    }
}
