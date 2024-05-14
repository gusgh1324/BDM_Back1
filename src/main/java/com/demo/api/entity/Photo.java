package com.demo.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; //사진의 제목
    private String description; // 사진의 설명
    private String imageUrl; //사진의 URL 주소

    // 다른 필드들
}
