package com.srping.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tutorials")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tutorial {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column(name = "title")
  private String title;
  @Column(name = "description")
  private String description;
  @Column(name = "published")
  private boolean published;
}
