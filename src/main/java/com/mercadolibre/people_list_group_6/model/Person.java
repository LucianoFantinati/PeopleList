package com.mercadolibre.people_list_group_6.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Table(name = "tb_person")
public class Person {

    @Id
    @GeneratedValue
    @Type(type="uuid-char")
    @Column(name = "id", columnDefinition = "char(36) not null unique")
    private UUID UUID;

    @Column(length = 32, nullable = false)

    private String name;

    @Column(length = 10, nullable = false)
    private String nickname;

    @Column(columnDefinition = "varchar(10) not null")

    private String birthday;

    @Column(length = 200, nullable = false)
    private String stack;

}