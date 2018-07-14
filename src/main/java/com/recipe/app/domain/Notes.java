package com.recipe.app.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
// Required because of circular references
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Here we don't want cascade operation. As we don't want to delete recipe when we delete Notes.
    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;
}
