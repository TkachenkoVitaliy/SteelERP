package ru.vtkachenko.nomenclatures.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Builder
@Entity
@Table(
        name="nomenclatures",
        indexes = {
                @Index(columnList = "short_name")
        }
)
public class Nomenclature implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Timestamp createdDt;
    @NotNull
    @NotBlank
    @Column(name = "short_name", unique = true)
    private String shortName;
    private String printName;
    @ManyToOne
    @JoinColumn(name = "unit_id")
    @NotNull
    private Unit unit;
    private Double thickness;
    private Double width;
    private Double length;
    private Double diameter;
    private String profile;
    private String series;
    @ManyToOne
    @JoinColumn(name = "grade_id")
    @NotNull
    private Grade grade;
    @ManyToOne
    @JoinColumn(name = "galvanized_class_id")
    private GalvanizedClass galvanizedClass;
    private ProductGroup productGroup;
    private SalesGroup salesGroup;
    private List<Gost> gosts;


}
