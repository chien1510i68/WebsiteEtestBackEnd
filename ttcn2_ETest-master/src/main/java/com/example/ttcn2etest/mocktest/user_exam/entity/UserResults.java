package com.example.ttcn2etest.mocktest.user_exam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
@Entity
public class UserResults {
    @Id

    private String id ;
    private Date createDate ;

    @Column(columnDefinition = "text")
    private String results ;
    private float point ;
    @Column(columnDefinition = "text")
    private String comment ;
    @ManyToOne
    @JoinColumn(name = "user_response_id")
    private UserResponse userResponse;
}
