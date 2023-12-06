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
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Table(name = "tb_stack")
public class Stack {

    @Id
    @GeneratedValue
    @Type(type="uuid-char")
    @Column(name = "id", columnDefinition = "char(36) not null unique")
    private java.util.UUID UUID;

    @Column(columnDefinition = "varchar(32) not null unique")
    private String name;

}
