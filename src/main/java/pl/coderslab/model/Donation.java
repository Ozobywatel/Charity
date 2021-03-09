package pl.coderslab.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int quantity;

    @ManyToOne
    @NotNull
    private Category category;

    @ManyToOne
    @NotNull
    private Institution institution;

    @NotBlank
    private String street;

    @NotBlank
    private String city;

    @Pattern(regexp = "[0-9]{2}-[0-9]{3}")
    private String zipCode;

    @NotBlank
    private LocalDate pickUpDate;

    @NotBlank
    private LocalTime pickUpTime;

    @NotBlank
    private String pickUpComment;
}
