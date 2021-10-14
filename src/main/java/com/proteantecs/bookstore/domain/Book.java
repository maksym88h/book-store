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
@Table(name = "books")
@JsonApiResource(type = "books")
public class Book implements Serializable {

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonApiRelation(lookUp = LookupIncludeBehavior.NONE, serialize = SerializeType.LAZY)
    private Author author;

    @Column(name = "author_id", updatable = false, insertable = false)
    private Long authorId;

}
