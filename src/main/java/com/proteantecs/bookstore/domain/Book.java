package com.proteantecs.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
@JsonApiResource(type = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonApiId
    private Long id;

    @Column
    @JsonProperty
    private String name;

    @Column
    @JsonProperty
    private Double price;

    @Column
    @JsonProperty
    private String cover;

    @Column
    @JsonProperty
    private String description;


}
