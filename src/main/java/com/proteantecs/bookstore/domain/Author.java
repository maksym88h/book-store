package com.proteantecs.bookstore.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.crnk.core.resource.annotations.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authors")
@JsonApiResource(type = "authors")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonApiId
    private Long id;

    @Column
    @JsonProperty
    private String name;

    @Column
    @JsonProperty
    private String email;

}
