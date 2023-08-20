package com.javaguides.springboot.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "wikimedia_recentchange")
@Getter
@Setter
@NoArgsConstructor
public class WikimediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String wikiEventData;

    public WikimediaData(String wikiEventData) {
        this.wikiEventData = wikiEventData;
    }
}
